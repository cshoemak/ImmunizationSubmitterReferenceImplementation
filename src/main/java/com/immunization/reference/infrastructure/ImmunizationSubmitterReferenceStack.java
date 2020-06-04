package com.immunization.reference.infrastructure;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Duration;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;
import software.amazon.awscdk.services.apigateway.IResource;
import software.amazon.awscdk.services.apigateway.Integration;
import software.amazon.awscdk.services.apigateway.IntegrationResponse;
import software.amazon.awscdk.services.apigateway.JsonSchema;
import software.amazon.awscdk.services.apigateway.LambdaIntegration;
import software.amazon.awscdk.services.apigateway.MethodOptions;
import software.amazon.awscdk.services.apigateway.MethodResponse;
import software.amazon.awscdk.services.apigateway.MockIntegration;
import software.amazon.awscdk.services.apigateway.ModelOptions;
import software.amazon.awscdk.services.apigateway.PassthroughBehavior;
import software.amazon.awscdk.services.apigateway.RestApi;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Runtime;
import software.amazon.awscdk.services.s3.Bucket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImmunizationSubmitterReferenceStack extends Stack {

    public ImmunizationSubmitterReferenceStack(final Construct scope, final String id) {

        this(scope, id, null);
    }

    public ImmunizationSubmitterReferenceStack(final Construct scope, final String id, final StackProps props) {

        super(scope, id, props);

        final RestApi api = RestApi.Builder.create(this, "immunization-submitter-api")
                .restApiName("Immunization submitter")
                .description("This API will receive patient information and post it to IIS")
                .build();

        final Function generateHL7Lambda =
                Function.Builder.create(this, "GenerateHL7Handler")
                        .code(Code.fromAsset("./target/ImmunizationSubmitterReferenceImplementation-1.0-SNAPSHOT-jar-with-dependencies.jar"))
                        .handler("com.immunization.reference.handler.GenerateHL7Handler")
                        .timeout(Duration.seconds(300))
                        .runtime(Runtime.JAVA_8)
                        .build();

        final Function postHL7Lambda =
                Function.Builder.create(this, "PostHL7Handler")
                        .code(Code.fromAsset("./target/ImmunizationSubmitterReferenceImplementation-1.0-SNAPSHOT-jar-with-dependencies.jar"))
                        .handler("com.immunization.reference.handler.PostHL7Handler")
                        .timeout(Duration.seconds(300))
                        .runtime(Runtime.JAVA_8)
                        .build();



        final Integration generateHL7LambdaIntegration = new LambdaIntegration(generateHL7Lambda);
        final IResource generateHL7Resource = api.getRoot().addResource("generateHL7");
        generateHL7Resource.addMethod("POST", generateHL7LambdaIntegration);

        final Integration postHL7LambdaIntegration = new LambdaIntegration(postHL7Lambda);
        final IResource postHL7Resource = api.getRoot().addResource("postHL7");
        postHL7Resource.addMethod("POST", postHL7LambdaIntegration);
    }
}