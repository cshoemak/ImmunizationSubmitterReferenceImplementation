package com.immunization.reference.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class GenerateHL7RequestBody {

  private PatientDetails patientDetails;

  private ConnectionInfo connectionInfo;

  private TestData testData;
}
