package com.immunization.reference.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class Covid19TestingResults {

  private final String testType;

  private final String testResult;

  private final String testDate;

}
