package com.immunization.reference.manager;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HL7MessageManagerTest {

    private HL7MessageManager manager;

    @BeforeEach
    public void setup() {
        manager = new HL7MessageManager();
    }
    
    @Test
    public void can_generate_message() {
        assertNotNull(manager.generateTestMessage());
    }
}