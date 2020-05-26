package com.immunization.reference.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.amazonaws.services.lambda.runtime.Context;
import com.immunization.reference.model.GatewayResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Collections;

public class ImmunizationSubmitterHandlerTest {

    private ImmunizationSubmitterHandler handler;

    @Mock
    private Context mockContext;

    @BeforeEach
    public void setup() {
        handler = new ImmunizationSubmitterHandler();
    }

    @Test
    public void hander_success() {
        GatewayResponse response = handler.handleRequest(Collections.emptyMap(), mockContext);
        assertEquals("Success", response.getBody());
    }
}