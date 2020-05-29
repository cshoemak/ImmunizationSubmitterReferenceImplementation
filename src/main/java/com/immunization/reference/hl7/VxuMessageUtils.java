package com.immunization.reference.hl7;

public class VxuMessageUtils {

    public static String createHl7Message(final Covid19TestResults testResults) {
        return constructMsh(testResults) +
                constructPid(testResults) +
                constructOrc(testResults) +
                constructRxa(testResults) +
                constructObx(testResults);
    }

    static String constructMsh(final Covid19TestResults testResults) {
        return "MSH|^~\\&|STARLIMS.AR.STAG^2.16.840.1.114222.4.3.3.2.5.2^ISO"
                + "|AR.LittleRock.SPHL^2.16.840.1.114222.4.1.20083^ISO|US WHO Collab LabSys^2.16.840.1.114222.4.3.3.7^ISO"
                + "|CDC-EPI Surv Branch^2.16.840.1.114222.4.1.10416^ISO|20190422132236-0500||VXU^V04^VXU_V04|1312-2"
                + "|T|2.5.1|||ER|AL|||||Z22^CDCPHINVS\n";
    }

    static String constructPid(final Covid19TestResults testResults) {
        return "PID|1"
                + "|"
                + "|" + eIfN(testResults.getMrn()) + "^^^AIRA-TEST^MR"
                + "|"
                + "|MarionAIRA^ColemanAIRA^Seamus^^^^L"
                + "|JohnsonAIRA^EllieAIRA^^^^^M"
                + "|" + eIfN(testResults.getDateOfBirth()) // PID-7
                + "|" + eIfN(testResults.getSex()) // PID-8
                + "|"
                + "|" + eIfN(testResults.getRace()) + "^^CDCREC"
                + "|1329 Rerneuzen Ln^^Raisinvl Township^MI^48161^USA^P"
                + "|"
                + "|^PRN^PH^^^" + eIfN(testResults.getPhoneAreaCode()) + "^" + eIfN(testResults.getPhoneNumber())
                + "||||||||"
                + "|" + eIfN(testResults.getEthnicity()) + "^^CDCREC"
                + "|\n";
    }

    static String constructOrc(final Covid19TestResults testResults) {
        return "ORC|RE||9999^IIS\n";
    }

    static String constructRxa(final Covid19TestResults testResults) {
        return "RXA|0"
                + "|1"
                + "|" + eIfN(testResults.getObservationDate())
                + "||998^No Vaccination Administered^CVX|999||||||||||||||NA\n";
    }

    static String constructObx(final Covid19TestResults testResults) {
        return "OBX|1"
                + "|CWE"
                + "|" + eIfN(testResults.getObservationCode()) + "^^" + eIfN(testResults.getObservationCodeSet()) + ""
                + "|"
                + "|" + eIfN(testResults.getObservationResult()) + "^^" + eIfN(testResults.getObservationResultSet())
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
}
