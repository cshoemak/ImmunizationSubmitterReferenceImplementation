package com.immunization.reference.model;

public class TestHl7RequestBody {

  private String hl7Payload;
  private ConnectionInfo connectionInfo;

  public String getHl7Payload() {
    return hl7Payload;
  }

  public void setHl7Payload(String hl7Payload) {
    this.hl7Payload = hl7Payload;
  }

  public ConnectionInfo getConnectionInfo() {
    return connectionInfo;
  }

  public void setConnectionInfo(ConnectionInfo connectionInfo) {
    this.connectionInfo = connectionInfo;
  }
}
