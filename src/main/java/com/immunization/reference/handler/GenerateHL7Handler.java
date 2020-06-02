package com.immunization.reference.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.immunization.reference.config.HandlerDependencies;
import com.immunization.reference.model.GatewayResponse;
import com.immunization.reference.model.GenerateHL7RequestBody;

import java.util.HashMap;
import java.util.Map;

public class GenerateHL7Handler implements RequestHandler<Map<String, Object>, GatewayResponse> {

    private final HandlerDependencies dependencies;

    // Required for API gateway
    public GenerateHL7Handler() {

        dependencies = new HandlerDependencies();
    }

    public GenerateHL7Handler(final HandlerDependencies dependencies) {

        this.dependencies = dependencies;
    }

    @Override public GatewayResponse handleRequest(Map<String, Object> input, Context context) {

        try {
            final String body = (String) input.get("body");
            final GenerateHL7RequestBody request = dependencies.getMapper()
                    .readValue(body, GenerateHL7RequestBody.class);

            final String hl7Message = dependencies.getHl7MessageManager().generateVXUMessage(request);

            final Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            return new GatewayResponse(hl7Message, headers, 200);
        } catch (final Exception ex) {
            throw new RuntimeException(ex);
        }

    }
}