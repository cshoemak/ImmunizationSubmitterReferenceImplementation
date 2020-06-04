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



        final Integration generateHL7LambdaIntegration = LambdaIntegration.Builder.create(generateHL7Lambda).integrationResponses(getIntegrationResponse()).build();
        final IResource generateHL7Resource = api.getRoot().addResource("generateHL7");
        generateHL7Resource.addMethod("POST", generateHL7LambdaIntegration, getMethodOptions());
        addCorsOptions(generateHL7Resource);


        final Integration postHL7LambdaIntegration = LambdaIntegration.Builder.create(postHL7Lambda).integrationResponses(getIntegrationResponse()).build();
        final IResource postHL7Resource = api.getRoot().addResource("postHL7");
        postHL7Resource.addMethod("POST", postHL7LambdaIntegration, getMethodOptions());
        addCorsOptions(postHL7Resource);
    }

    private void addCorsOptions(IResource item) {
        final Map<String, String> requestTemplate = new HashMap<>();
        requestTemplate.put("application/json","{\"statusCode\": 200}");

        final Integration methodIntegration = MockIntegration.Builder.create()
                .integrationResponses(getIntegrationResponse())
                .passthroughBehavior(PassthroughBehavior.NEVER)
                .requestTemplates(requestTemplate)
                .build();

        item.addMethod("OPTIONS", methodIntegration, getMethodOptions());
    }

    private MethodOptions getMethodOptions() {

        final List<MethodResponse> methodResponses = new ArrayList<>();
        final Map<String, Boolean> responseParameters = new HashMap<>();
        responseParameters.put("method.response.header.Access-Control-Allow-Headers", Boolean.TRUE);
        responseParameters.put("method.response.header.Access-Control-Allow-Methods", Boolean.TRUE);
        responseParameters.put("method.response.header.Access-Control-Allow-Credentials", Boolean.TRUE);
        responseParameters.put("method.response.header.Access-Control-Allow-Origin", Boolean.TRUE);
        methodResponses.add(MethodResponse.builder()
                .responseParameters(responseParameters)
                .statusCode("200")
                .build());
        final MethodOptions methodOptions = MethodOptions.builder()
                .methodResponses(methodResponses)
                .build();
        return methodOptions;
    }

    private List<IntegrationResponse> getIntegrationResponse() {
        final List<IntegrationResponse> integrationResponses = new ArrayList<>();

        final Map<String, String> integrationResponseParameters = new HashMap<>();
        integrationResponseParameters.put("method.response.header.Access-Control-Allow-Headers","'Content-Type,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token,X-Amz-User-Agent'");
        integrationResponseParameters.put("method.response.header.Access-Control-Allow-Origin","'*'");
        integrationResponseParameters.put("method.response.header.Access-Control-Allow-Credentials","'false'");
        integrationResponseParameters.put("method.response.header.Access-Control-Allow-Methods","'OPTIONS,GET,PUT,POST,DELETE'");
        integrationResponses.add(IntegrationResponse.builder()
                .responseParameters(integrationResponseParameters)
                .statusCode("200")
                .build());

        return integrationResponses;
    }

}