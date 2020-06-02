package com.immunization.reference.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class Covid19TestingResults {

  private String testType;

  private String testResult;

  private String testDate;

}
