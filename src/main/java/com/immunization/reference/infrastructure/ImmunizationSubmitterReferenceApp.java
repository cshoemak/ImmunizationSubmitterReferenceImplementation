package com.immunization.reference.infrastructure;

import software.amazon.awscdk.core.App;

public class ImmunizationSubmitterReferenceApp {
    public static void main(final String[] args) {
        App app = new App();

        new ImmunizationSubmitterReferenceStack(app, "ImmunizationSubmitterReferenceStack");

        app.synth();
    }
}