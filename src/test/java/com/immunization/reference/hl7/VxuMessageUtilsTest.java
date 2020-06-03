package com.immunization.reference.hl7;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.immunization.reference.model.ConnectionInfo;
import com.immunization.reference.model.Covid19TestingResults;
import com.immunization.reference.model.PatientDetails;

public class VxuMessageUtilsTest {
    private static final Covid19TestingResults TEST_RESULTS = Covid19TestingResults.builder()
            .testDate("20200503")
            .testResult("260373001^Detected^SCT")
            .testType("94763-0^SARS-CoV-2 XXX Ql Cult^LN")
            .build();
    private static final PatientDetails PATIENT = PatientDetails.builder()
            .mrn("NotMyMRN212")
            .mrnAuthority("MRNAUTH.435")
            .dateOfBirth("20010503")
            .addressCity("Mesa")
            .addressState("AZ")
            .addressZip("85209")
            .guardianNameFirst("Martha")
            .guardianNameLast("Blakely")
            .guardianRelationship("MTH^Mother^HL70063")
            .race("2028-9^Asian^CDCREC")
            .motherMaidenNameLast("Chandler")
            .sex("M")
            .nameFirst("Fred")
            .nameLast("Flintstone")
            .nameMiddle("Brick")
            .phoneAreaCode("602")
            .phoneNumber("8675309")
            // TODO: Set more test fields for later assertions
            .build();
    private static final ConnectionInfo CONNECTION = ConnectionInfo.builder()
            .facility("TEST_FACILITY")
            .iisUrl("https://www.example.com/iis")
            .userId("USER_ID_1")
            .password("PASSWORD_SECRET")
            .build();

    private static VxuMessageUtils messageUtils;

    @BeforeAll
    public static void setup() {
        messageUtils = new VxuMessageUtils();
    }

    @Test
    public void test_createHl7Message_success() {
        final String hl7Message = messageUtils.createHl7Message(PATIENT, TEST_RESULTS, CONNECTION);
        System.out.println(hl7Message);
        assertTrue(hl7Message.contains("MSH"));
        assertTrue(hl7Message.contains(PATIENT.getMrn()));
        // TODO: more assertions needed.
    }
    // TODO: individual segment tests needed.
}
