package com.immunization.reference.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class GenerateHL7RequestBody {

  private PatientDetails patientDetails;

  private ConnectionInfo connectionInfo;

  private TestData testData;
}
