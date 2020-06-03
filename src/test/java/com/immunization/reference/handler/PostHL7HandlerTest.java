package com.immunization.reference.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.amazonaws.services.lambda.runtime.Context;
import com.immunization.reference.model.GatewayResponse;
import com.immunization.reference.model.PostHL7RequestBody;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.HashMap;

public class PostHL7HandlerTest {

    @Mock
    private Context mockContext;

    @Test
    public void hander_success() {

        final PostHL7Handler handler = new PostHL7Handler();

        final GatewayResponse response = handler.handleRequest(PostHL7RequestBody.builder().build(), mockContext);

        assertEquals("Success", response.getBody());

    }
}