package com.immunization.reference.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.immunization.reference.config.HandlerDependencies;
import com.immunization.reference.model.ConnectionInfo;
import com.immunization.reference.model.GatewayResponse;
import com.immunization.reference.model.PostHL7RequestBody;

import java.util.HashMap;
import java.util.Map;

public class PostHL7Handler implements RequestHandler<Map<String, Object>, GatewayResponse> {

    private final HandlerDependencies dependencies;

    // Required for API gateway
    public PostHL7Handler() {

        dependencies = new HandlerDependencies();
    }

    public PostHL7Handler(final HandlerDependencies dependencies) {

        this.dependencies = dependencies;
    }

    @Override public GatewayResponse handleRequest(Map<String, Object> input, Context context) {

        try {
            final String body = (String) input.get("body");
            final PostHL7RequestBody request = dependencies.getMapper().readValue(body, PostHL7RequestBody.class);
            final ConnectionInfo connectionInfo = request.getConnectionInfo();

            final String ack = dependencies.getIisManager().submitMessage(
                    connectionInfo.getIisUrl(),
                    connectionInfo.getUserId(),
                    connectionInfo.getPassword(),
                    connectionInfo.getFacility(),
                    request.getHl7Payload()
            );

            final Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            return new GatewayResponse(ack, headers, 200);
        } catch (final Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}