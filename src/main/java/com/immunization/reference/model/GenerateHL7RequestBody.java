package com.immunization.reference.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class GenerateHL7RequestBody {

  private PatientDetails patientDetails;

  private ConnectionInfo connectionInfo;

  private Covid19TestingResults covid19TestingResults;
}
