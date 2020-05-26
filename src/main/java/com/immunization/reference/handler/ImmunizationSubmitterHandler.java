package com.immunization.reference.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.immunization.reference.model.GatewayResponse;

import java.util.HashMap;
import java.util.Map;

public class ImmunizationSubmitterHandler implements RequestHandler<Map<String, Object>, GatewayResponse> {

    @Override public GatewayResponse handleRequest(Map<String, Object> input, Context context) {

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        return new GatewayResponse("Success", headers, 200);
    }
}