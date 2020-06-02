package com.immunization.reference.infrastructure;

import software.amazon.awscdk.core.App;
import software.amazon.awscdk.core.Environment;
import software.amazon.awscdk.core.StackProps;

public class ImmunizationSubmitterReferenceApp {

    public static void main(final String[] args) {

        final App app = new App();

        final StackProps props = new StackProps.Builder().env(
                Environment.builder()
                        .region("us-east-1")
                        .account(System.getenv("CDK_DEFAULT_ACCOUNT"))
                        .build())
                .build();

        new ImmunizationSubmitterReferenceStack(app, "ImmunizationSubmitterReferenceStack");
        new ImmunizationSubmitterWebsiteStack(app, "ImmunizationSubmitterWebsiteStack", props);

        app.synth();
    }
}