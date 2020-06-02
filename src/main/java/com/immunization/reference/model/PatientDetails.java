package com.immunization.reference.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@RequiredArgsConstructor
public class PatientDetails {

  private String mrn;
  private String mrnAuthority;
  private String nameFirst;
  private String nameMiddle;
  private String nameLast;
  private String nameType;
  private String motherMaidenNameLast;
  private String dateOfBirth;
  private String sex;
  private String raceCode;
  private String raceDescription;
  private String ethnicityCode;
  private String ethnicityDescription;
  private String phoneAreaCode;
  private String phoneNumber;
  private String addressLine1;
  private String addressLine2;
  private String addressCity;
  private String addressState;
  private String addressZip;
  private String addressCountry;
  private String guardianNameFirst;
  private String guardianNameLast;
  private String guardianRelationship;

}
