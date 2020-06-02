/*
package com.immunization.reference.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.immunization.reference.config.HandlerDependencies;
import com.immunization.reference.manager.HL7MessageManager;
import com.immunization.reference.manager.IISManager;
import com.immunization.reference.model.ConnectionInfo;
import com.immunization.reference.model.GatewayResponse;
import com.immunization.reference.model.PostHL7RequestBody;
<<<<<<< Updated upstream
<<<<<<< HEAD
=======

>>>>>>> c663d47382d154215b7daa4997f7c0664a7a5082
=======
import org.junit.jupiter.api.BeforeEach;
>>>>>>> Stashed changes
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

public class PostHL7HandlerTest {

    @Mock
    private Context mockContext;

    @Mock
    private IISManager mockIISManager;

    @Mock
    private HL7MessageManager mockHL7MessageManager;

    @Mock
    private HandlerDependencies mockDependencies;

    private PostHL7Handler handler;

    ObjectMapper mapper;



    @BeforeEach
    public void setup() {

        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        MockitoAnnotations.initMocks(this);

        when(mockDependencies.getIisManager()).thenReturn(mockIISManager);
        when(mockDependencies.getHl7MessageManager()).thenReturn(mockHL7MessageManager);
        when(mockDependencies.getMapper()).thenReturn(mapper);

        handler = new PostHL7Handler(mockDependencies);
    }

    @Test
    public void hander_success() throws Exception {

        PostHL7RequestBody body = PostHL7RequestBody.builder().hl7Payload("test").connectionInfo(
                ConnectionInfo.builder().facility("test").iisUrl("test").password("test").userId("test").build()
        ).build();

        final PostHL7Handler handler = new PostHL7Handler();
        OutputStream stream = new ByteArrayOutputStream();

        ByteArrayInputStream input = new ByteArrayInputStream(mapper.writeValueAsBytes(body));

            handler.handleRequest(input, stream, mockContext);
    }
}*/
