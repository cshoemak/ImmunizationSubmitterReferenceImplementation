package com.immunization.reference.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import com.immunization.reference.exception.IISException;
import com.immunization.reference.iis.ClientService;
import com.immunization.reference.iis.IISPortType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.imageio.IIOException;
import java.util.HashMap;

public class IISManagerTest {

    private static final String TEST_HL7_MESSAGE = "Test Message";
    private static final String TEST_IIS_RESPONSE = "Test Response";
    private static final String TEST_USERNAME = "Test Username";
    private static final String TEST_PASSWORD = "Test Password";
    private static final String TEST_FACILITY = "Test Facility";

    private IISManager manager;

    @Mock
    private ClientService mockService;

    @Mock
    private IISPortType mockPort;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        manager = new IISManager(mockService);
    }

    @Test
    public void manager_success() throws Exception {

        when(mockService.getClientPortSoap12()).thenReturn(mockPort);
        when(mockPort.submitSingleMessage(TEST_USERNAME, TEST_PASSWORD, TEST_FACILITY, TEST_HL7_MESSAGE))
                .thenReturn(TEST_IIS_RESPONSE);

        final String response = manager.submitMessage(TEST_USERNAME, TEST_PASSWORD, TEST_FACILITY, TEST_HL7_MESSAGE);
        assertEquals(TEST_IIS_RESPONSE, response);
    }

    @Test
    public void manager_iisError_throwsIISException() throws Exception {

        when(mockService.getClientPortSoap12()).thenReturn(mockPort);
        when(mockPort.submitSingleMessage(TEST_USERNAME, TEST_PASSWORD, TEST_FACILITY, TEST_HL7_MESSAGE))
                .thenThrow(new RuntimeException());

        assertThrows(IISException.class, () -> {
            manager.submitMessage(TEST_USERNAME, TEST_PASSWORD, TEST_FACILITY, TEST_HL7_MESSAGE);
        });
    }
}