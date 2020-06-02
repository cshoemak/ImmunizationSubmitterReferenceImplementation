package com.immunization.reference.model;

import lombok.Getter;
import lombok.Setter;

public class GenerateHL7RequestBody {

  @Getter  @Setter
  private PatientDetails patientDetails;

  @Getter  @Setter
  private ConnectionInfo connectionInfo;

  @Getter  @Setter
  private TestData testData;
}
