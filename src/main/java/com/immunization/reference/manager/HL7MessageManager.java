package com.immunization.reference.manager;

import com.immunization.reference.hl7.VxuMessageUtils;
import com.immunization.reference.model.GenerateHL7RequestBody;

public class HL7MessageManager {

    public String generateTestMessage() {
        return "MSH|^~\\&|||||20200528161807-0600||VXU^V04^VXU_V04|A55D7.21n|P|2.5.1|||ER|AL|||||Z22^CDCPHINVS|\n"
                + "PID|1||A55D7^^^AIRA-TEST^MR||Test_IISAIRA^SophieAIRA^Majida^^^^L|RossAIRA^SumiAIRA^^^^^M|20160529|F||2106-3^White^CDCREC|1310 Mtadskanaal Pl^^Rochester Hls^MI^48306^USA^P||^PRN^PH^^^248^8581090|||||||||2186-5^not Hispanic or Latino^CDCREC|\n"
                + "PD1|||||||||||02^Reminder/Recall - any method^HL70215|||||A|20200528|20200528|\n"
                + "NK1|1|AuglaizeAIRA^SumiAIRA^^^^^L|MTH^Mother^HL70063|1310 Mtadskanaal Pl^^Rochester Hls^MI^48306^USA^P|^PRN^PH^^^248^8581090|\n"
                + "ORC|RE||A55D7.3^AIRA|||||||I-23432^Burden^Donna^A^^^^^NIST-AA-1^^^^PRN||57422^RADON^NICHOLAS^^^^^^NIST-AA-1^L^^^PRN|\n"
                + "RXA|0|1|20200528||21^Varicella^CVX|0.5|mL^milliliters^UCUM||00^Administered^NIP001||||||N3783EO||MSD^Merck and Co^MVX|||CP|A|\n"
                + "RXR|C38299^^NCIT|RA^^HL70163|\n"
                + "OBX|1|CE|64994-7^Vaccine funding program eligibility category^LN|1|V03^VFC eligible - Uninsured^HL70064||||||F|||20200528|||VXC40^Eligibility captured at the immunization level^CDCPHINVS|\n"
                + "OBX|2|CE|30956-7^Vaccine Type^LN|2|21^Varicella^CVX||||||F|\n"
                + "OBX|3|TS|29768-9^Date vaccine information statement published^LN|2|20080313||||||F|\n"
                + "OBX|4|TS|29769-7^Date vaccine information statement presented^LN|2|20200528||||||F|";
    }

    public String generateVXUMessage(final GenerateHL7RequestBody requestBody) {
        return VxuMessageUtils.createHl7Message(requestBody.getPatientDetails(),
                requestBody.getCovid19TestingResults(),
                requestBody.getConnectionInfo());
    }
}