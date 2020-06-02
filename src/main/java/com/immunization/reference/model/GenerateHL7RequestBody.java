package com.immunization.reference.model;

public class GenerateHL7RequestBody {

  private PatientDetails patient;
  private ConnectionInfo connection;
  private String testResult;

  public PatientDetails getPatient() {
    return patient;
  }

  public void setPatient(PatientDetails patient) {
    this.patient = patient;
  }

  public ConnectionInfo getConnection() {
    return connection;
  }

  public void setConnection(ConnectionInfo connection) {
    this.connection = connection;
  }

  public String getTestResult() {
    return testResult;
  }

  public void setTestResult(String testResult) {
    this.testResult = testResult;
  }
}
