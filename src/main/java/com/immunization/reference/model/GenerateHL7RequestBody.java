package com.immunization.reference.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
public class GenerateHL7RequestBody {

  private PatientDetails patientDetails;

  private ConnectionInfo connectionInfo;

  private Covid19TestingResults covid19TestingResults;

  private String hl7Format;
}
