package com.immunization.reference.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.isA;

import com.amazonaws.services.lambda.runtime.Context;
import com.immunization.reference.config.HandlerDependencies;
import com.immunization.reference.manager.IISManager;
import com.immunization.reference.model.ConnectionInfo;
import com.immunization.reference.model.GatewayResponse;
import com.immunization.reference.model.PostHL7RequestBody;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;

public class PostHL7HandlerTest {

    @Mock
    private Context mockContext;

    @Mock
    private HandlerDependencies mockDependencies;

    @Mock
    private IISManager mockIisManager;

    private PostHL7Handler handler;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        handler = new PostHL7Handler(mockDependencies);
    }
    
    @Test
    public void handler_success() {

        when(mockDependencies.getIisManager()).thenReturn(mockIisManager);
        when(mockIisManager.submitMessage(isA(String.class), isA(String.class), isA(String.class), isA(String.class), isA(String.class)))
            .thenReturn("SUCCESS");
        final GatewayResponse response = handler.handleRequest(PostHL7RequestBody.builder()
                .connectionInfo(ConnectionInfo.builder()
                        .facility("ISRI_UnitTests")
                        .iisUrl("http://florence.immregistries.org/iis-sandbox/soap")
                        .userId("isri_unitTestUser")
                        .password("blah")
                        .build())
                .hl7Payload("MSH|^~\\&|ISRI^0.1^ISO|AWS_ISRI^0.1^ISO|US WHO Collab LabSys^2.16.840.1.114222.4.3.3.7^ISO|CDC-EPI Surv Branch^2.16.840.1.114222.4.1.10416^ISO|20205903135935-0700||VXU^V04^VXU_V04|1312-2|T|2.5.1|||ER|AL|||||Z22^CDCPHINVS\n" + 
                        "PID|1||NotMyMRN212^^^MRNAUTH.435^MR||Flintstone^Fred^Brick^^^^L|Chandler^^^^^^M|20010503|M||2028-9^Asian^CDCREC|^^Mesa^AZ^85209^USA^P||^PRN^PH^^^602^8675309||||||||||\n" + 
                        "NK1|1|Blakely^Martha^^^^^L|MTH^Mother^HL70063|94 Macomb Ln^^Kalamazoo^MI^49005^USA^P|^PRN^PH^^^269^5521655\n" + 
                        "ORC|RE||9999^AIRA\n" + 
                        "RXA|0|1|20200503||998^No Vaccination Administered^CVX|999||||||||||||||NA\n" + 
                        "OBX|1|CE|94763-0^SARS-CoV-2 XXX Ql Cult^LN|1|260373001^Detected^SCT||||||F|||20200503||||||||||\n" + 
                        "")
                .build(), mockContext);

        assertEquals("SUCCESS", response.getBody());
    }
}