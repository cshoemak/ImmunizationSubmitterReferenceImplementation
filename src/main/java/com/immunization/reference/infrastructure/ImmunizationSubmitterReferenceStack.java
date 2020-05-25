package com.immunization.reference.infrastructure;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Duration;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;
import software.amazon.awscdk.services.apigateway.IResource;
import software.amazon.awscdk.services.apigateway.Integration;
import software.amazon.awscdk.services.apigateway.JsonSchema;
import software.amazon.awscdk.services.apigateway.LambdaIntegration;
import software.amazon.awscdk.services.apigateway.ModelOptions;
import software.amazon.awscdk.services.apigateway.RestApi;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Runtime;
import software.amazon.awscdk.services.s3.Bucket;

public class ImmunizationSubmitterReferenceStack extends Stack {

    public ImmunizationSubmitterReferenceStack(final Construct scope, final String id) {

        this(scope, id, null);
    }

    public ImmunizationSubmitterReferenceStack(final Construct scope, final String id, final StackProps props) {

        super(scope, id, props);

        RestApi api = RestApi.Builder.create(this, "immunization-submitter-api")
                .restApiName("Immunization submitter")
                .description("This API will receive patient information and post it to IIS")
                .build();

        Function lambdaFunction =
                Function.Builder.create(this, "ImmunizationSubmitterHandler")
                        .code(Code.fromAsset("./target/ImmunizationSubmitterReferenceImplementation-1.0-SNAPSHOT.jar"))
                        .handler("com.immunization.reference.handler.ImmunizationSubmitterHandler")
                        .timeout(Duration.seconds(300))
                        .runtime(Runtime.JAVA_8)
                        .build();

        IResource items = api.getRoot().addResource("request");

        Integration lambdaIntegration = new LambdaIntegration(lambdaFunction);
        items.addMethod("POST", lambdaIntegration);
    }
}