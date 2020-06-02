package com.immunization.reference.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.immunization.reference.config.HandlerDependencies;
import com.immunization.reference.model.GatewayResponse;

import com.immunization.reference.model.PostHL7RequestBody;
import java.util.HashMap;
import java.util.Map;

public class PostHL7Handler implements RequestHandler<PostHL7RequestBody, GatewayResponse> {

    private final HandlerDependencies dependencies;

    // Required for API gateway
    public PostHL7Handler() {

        dependencies = new HandlerDependencies();
    }

    public PostHL7Handler(final HandlerDependencies dependencies) {

        this.dependencies = dependencies;
    }

    @Override public GatewayResponse handleRequest(final PostHL7RequestBody input, final Context context) {

        final Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        return new GatewayResponse("Success", headers, 200);
    }
}