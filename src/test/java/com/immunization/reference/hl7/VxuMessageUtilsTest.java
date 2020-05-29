package com.immunization.reference.hl7;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class VxuMessageUtilsTest {
    private static final Covid19TestResults TEST_DATA = Covid19TestResults.builder()
            .mrn("NotMyMRN212")
            .mrnAuthority("MRNAUTH.435")
            .dateOfBirth("20010503")
            .addressCity("Mesa")
            .addressState("AZ")
            .addressZip("85209")
            // TODO: Set more test fields for later assertions
            .build();

    private static VxuMessageUtils messageUtils;

    @BeforeAll
    public static void setup() {
        messageUtils = new VxuMessageUtils();
    }

    @Test
    public void test_createHl7Message_success() {
        final String hl7Message = messageUtils.createHl7Message(TEST_DATA);
        System.out.println(hl7Message);
        assertTrue(hl7Message.contains("MSH"));
        assertTrue(hl7Message.contains(TEST_DATA.getMrn()));
        // TODO: more assertions needed.
    }
    // TODO: individual segment tests needed.
}
