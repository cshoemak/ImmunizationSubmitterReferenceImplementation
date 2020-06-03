package com.immunization.reference.hl7;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.immunization.reference.model.ConnectionInfo;
import com.immunization.reference.model.Covid19TestingResults;
import com.immunization.reference.model.PatientDetails;

public class VxuMessageUtils {

    public static String createHl7Message(final PatientDetails patient, final Covid19TestingResults testResults, final ConnectionInfo connectionInfo) {
        return constructMsh(connectionInfo) +
                constructPid(patient) +
                constructNk1(patient) +
                constructOrc() +
                constructRxa(testResults) +
                constructObx(testResults);
    }

    static String constructMsh(final ConnectionInfo connectionInfo) {
        return "MSH|"
        		+ "^~\\&"
        		+ "|ISRI^0.1^ISO"
                + "|AWS_ISRI^0.1^ISO"
                + "|US WHO Collab LabSys^2.16.840.1.114222.4.3.3.7^ISO"
                + "|CDC-EPI Surv Branch^2.16.840.1.114222.4.1.10416^ISO"
                + "|" + generateHl7DateTime(new Date())
                + "||VXU^V04^VXU_V04|1312-2"
                + "|T|2.5.1|||ER|AL|||||Z22^CDCPHINVS\n";
    }

    static String constructPid(final PatientDetails patient) {
        return "PID|1"
                + "|"
                + "|" + eIfN(patient.getMrn()) + "^^^" + eIfN(patient.getMrnAuthority()) + "^MR"
                + "|"
                + "|" + eIfN(patient.getNameLast()) + "^" + eIfN(patient.getNameFirst()) + "^" + eIfN(patient.getNameMiddle()) + "^^^^L"
                + "|" + eIfN(patient.getMotherMaidenNameLast()) + "^^^^^^M"
                + "|" + eIfN(patient.getDateOfBirth()) // PID-7
                + "|" + eIfN(patient.getSex()) // PID-8
                + "|"
                + "|" + eIfN(patient.getRace())
                + "|" + eIfN(patient.getAddressLine1()) + "^" + eIfN(patient.getAddressLine2()) + "^" + eIfN(patient.getAddressCity()) + "^" + eIfN(patient.getAddressState()) + "^" + eIfN(patient.getAddressZip()) + "^USA^P"
                + "|"
                + "|^PRN^PH^^^" + eIfN(patient.getPhoneAreaCode()) + "^" + eIfN(patient.getPhoneNumber())
                + "||||||||"
                + "|" + eIfN(patient.getEthnicity())
                + "|\n";
    }

    static String constructNk1(final PatientDetails patient) {
    	return "NK1|1"
    			+ "|" + patient.getGuardianNameLast() + "^^" + patient.getGuardianNameFirst() + "^^^^L"
    			+ "|" + patient.getGuardianRelationship()
    			+ "|94 Macomb Ln^^Kalamazoo^MI^49005^USA^P"
    			+ "|^PRN^PH^^^269^5521655";
    }

    static String constructOrc() {
        return "ORC|RE||9999^AIRA\n";
    }

    static String constructRxa(final Covid19TestingResults testResults) {
        return "RXA|0"
                + "|1"
                + "|" + eIfN(testResults.getTestDate())
                + "||998^No Vaccination Administered^CVX|999||||||||||||||NA\n";
    }

    /**
     * Example segment: OBX|1|CE|94309-2^SARS-CoV-2 RNA XXX NAA+probe-Imp^LN|1|260373001^Detected^SCT||||||F|||20190714
     * @param testResults
     * @return
     */
    static String constructObx(final Covid19TestingResults testResults) {
        return "OBX|1"
                + "|CE"
                + "|" + eIfN(testResults.getTestType())
                + "|"
                + "|" + eIfN(testResults.getTestResult())
                + "||||||F||"
                + "|201902281257-0500|||||201904020721-0500|||"
                + "|Public Health Laboratory^D^^^^CLIA&2.16.840.1.113883.19.4.6&ISO^XX^^^05D0897628"
                + "|3434 Industrial Loop^^Little Rock^AR^72205^USA^B\n";
    }

    /**
     * Empty if null. Every hl7 class has to have one of these, don't they?
     */
    static String eIfN(final String input) {
        return input == null ? "" : input;
    }

    /**
     * HL7 specific date generator 
     * @return a string in the format like 20190422132236-0500.
     */
    static String generateHl7DateTime(final Date datetime) {
    	return new SimpleDateFormat("yyyymmddHHmmss-ZZZZ").format(datetime);
    }
}
