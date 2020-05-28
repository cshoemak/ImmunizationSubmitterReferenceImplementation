package com.immunization.reference.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.immunization.reference.config.HandlerDependencies;
import com.immunization.reference.model.GatewayResponse;

import java.util.HashMap;
import java.util.Map;

public class ImmunizationSubmitterHandler implements RequestHandler<Map<String, Object>, GatewayResponse> {

    private final HandlerDependencies dependencies;

    // Required for API gateway
    public  ImmunizationSubmitterHandler() {
        dependencies = new HandlerDependencies();
    }

    public ImmunizationSubmitterHandler(final HandlerDependencies dependencies) {

        this.dependencies = dependencies;
    }

    @Override public GatewayResponse handleRequest(final Map<String, Object> input, final Context context) {

        final Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        final String hl7Message = dependencies.getHl7MessageManager().generateTestMessage();
        final String response = dependencies.getIisManager().submitMessage(
                "test_iis_username", "test123", "test_iis_facility", hl7Message
        );

        return new GatewayResponse(response, headers, 200);
    }
}