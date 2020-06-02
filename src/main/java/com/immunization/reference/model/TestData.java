package com.immunization.reference.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class TestData {

  private String testType;

  private String testResult;

  private String testDate;

}
