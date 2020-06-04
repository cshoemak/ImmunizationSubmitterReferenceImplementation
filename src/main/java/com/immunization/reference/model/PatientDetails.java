package com.immunization.reference.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
  private String race;
  private String ethnicity;
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
