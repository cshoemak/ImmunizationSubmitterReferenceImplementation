//package com.immunization.reference.handler;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Matchers.any;
//import static org.mockito.Matchers.eq;
//import static org.mockito.Mockito.when;
//import com.amazonaws.services.lambda.runtime.Context;
//import com.immunization.reference.config.HandlerDependencies;
//import com.immunization.reference.manager.HL7MessageManager;
//import com.immunization.reference.manager.IISManager;
//import com.immunization.reference.model.GatewayResponse;
//import com.immunization.reference.model.GenerateHL7RequestBody;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//public class GenerateHL7HandlerTest {
//
//    private static final String TEST_HL7_MESSAGE = "Test Message";
//    private static final String TEST_IIS_RESPONSE = "Test Response";
//
//    private GenerateHL7Handler handler;
//
//    @Mock
//    private Context mockContext;
//
//    @Mock
//    private IISManager mockIISManager;
//
//    @Mock
//    private HL7MessageManager mockHL7MessageManager;
//
//    @Mock
//    private HandlerDependencies mockDependencies;
//
//    @BeforeEach
//    public void setup() {
//
//        MockitoAnnotations.initMocks(this);
//
//        when(mockDependencies.getIisManager()).thenReturn(mockIISManager);
//        when(mockDependencies.getHl7MessageManager()).thenReturn(mockHL7MessageManager);
//
//        handler = new GenerateHL7Handler(mockDependencies);
//    }
//
//    @Test
//    public void hander_success() {
//
//        when(mockHL7MessageManager.generateTestMessage()).thenReturn(TEST_HL7_MESSAGE);
//        when(mockIISManager.submitMessage(any(), any(), any(), any(), eq(TEST_HL7_MESSAGE)))
//                .thenReturn(TEST_IIS_RESPONSE);
//
//        final GatewayResponse response = handler.handleRequest(GenerateHL7RequestBody.builder().build(), mockContext);
//
//        assertEquals(TEST_IIS_RESPONSE, response.getBody());
//
//    }
//
//    @Test
//    public void hander_iisManagerException_throwsException() {
//
//        when(mockHL7MessageManager.generateTestMessage()).thenReturn(TEST_HL7_MESSAGE);
//        when(mockIISManager.submitMessage(any(), any(), any(), any(), eq(TEST_HL7_MESSAGE)))
//                .thenThrow(new RuntimeException());
//        assertThrows(RuntimeException.class, () -> {
//            handler.handleRequest(GenerateHL7RequestBody.builder().build(), mockContext);
//        });
//    }
//}