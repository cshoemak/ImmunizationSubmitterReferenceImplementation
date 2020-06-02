package com.immunization.reference.model;

public class GenerateHL7RequestBody {

  private PatientDetails patientDetails;
  private ConnectionInfo connectionInfo;
  private String testResult;

  public PatientDetails getPatientDetails() {
    return patientDetails;
  }

  public void setPatientDetails(PatientDetails patientDetails) {
    this.patientDetails = patientDetails;
  }

  public ConnectionInfo getConnectionInfo() {
    return connectionInfo;
  }

  public void setConnectionInfo(ConnectionInfo connectionInfo) {
    this.connectionInfo = connectionInfo;
  }

  public String getTestResult() {
    return testResult;
  }

  public void setTestResult(String testResult) {
    this.testResult = testResult;
  }
}
