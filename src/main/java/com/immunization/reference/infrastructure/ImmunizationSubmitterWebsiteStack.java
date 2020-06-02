package com.immunization.reference.infrastructure;

import software.amazon.awscdk.core.CfnOutput;
import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.RemovalPolicy;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;
import software.amazon.awscdk.services.certificatemanager.DnsValidatedCertificate;
import software.amazon.awscdk.services.cloudfront.AliasConfiguration;
import software.amazon.awscdk.services.cloudfront.Behavior;
import software.amazon.awscdk.services.cloudfront.CloudFrontWebDistribution;
import software.amazon.awscdk.services.cloudfront.S3OriginConfig;
import software.amazon.awscdk.services.cloudfront.SSLMethod;
import software.amazon.awscdk.services.cloudfront.SecurityPolicyProtocol;
import software.amazon.awscdk.services.cloudfront.SourceConfiguration;
import software.amazon.awscdk.services.route53.ARecord;
import software.amazon.awscdk.services.route53.HostedZone;
import software.amazon.awscdk.services.route53.HostedZoneProviderProps;
import software.amazon.awscdk.services.route53.IHostedZone;
import software.amazon.awscdk.services.route53.RecordTarget;
import software.amazon.awscdk.services.route53.targets.CloudFrontTarget;
import software.amazon.awscdk.services.s3.Bucket;
import software.amazon.awscdk.services.s3.deployment.BucketDeployment;
import software.amazon.awscdk.services.s3.deployment.ISource;
import software.amazon.awscdk.services.s3.deployment.Source;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImmunizationSubmitterWebsiteStack extends Stack {

    public ImmunizationSubmitterWebsiteStack(final Construct scope, final String id, final StackProps props) {

        super(scope, id, props);
        try {

            // S3 Bucket resource and Content
            final Bucket siteBucket =
                    Bucket.Builder.create(this, "SiteBucket")
                            .bucketName("immunization-website-bucket")
                            .websiteIndexDocument("index.html")
                            .websiteErrorDocument("error.html")
                            .publicReadAccess(true)
                            .removalPolicy(RemovalPolicy.DESTROY)
                            .build();

            CfnOutput.Builder.create(this, "Bucket")
                    .description("Bucket Name")
                    .value(siteBucket.getBucketName())
                    .build();

            // CloudFront distribution that provides HTTPS
            final List<Behavior> behavioursList = new ArrayList<>(1);
            behavioursList.add(Behavior.builder().isDefaultBehavior(true).build());

            final List<SourceConfiguration> sourceConfigurationsList = new ArrayList<>(1);
            sourceConfigurationsList.add(
                    SourceConfiguration.builder()
                            .s3OriginSource(S3OriginConfig.builder().s3BucketSource(siteBucket).build())
                            .behaviors(behavioursList)
                            .build());

            @SuppressWarnings({ "deprecation" }) final CloudFrontWebDistribution distribution =
                    CloudFrontWebDistribution.Builder.create(this, "SiteDistribution")
                            .originConfigs(sourceConfigurationsList)
                            .build();

            CfnOutput.Builder.create(this, "DistributionId")
                    .description("CloudFront Distribution Id")
                    .value(distribution.getDistributionId())
                    .build();

            // Deploy site contents to S3 bucket
            final List<ISource> sources = new ArrayList<>(1);
            sources.add(Source.asset("./site-contents"));

            BucketDeployment.Builder.create(this, "DeployWithInvalidation")
                    .sources(sources)
                    .destinationBucket(siteBucket)
                    .distribution(distribution)
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}