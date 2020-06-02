package com.immunization.reference.model;

import lombok.Getter;
import lombok.Setter;

public class PatientDetails {

  @Getter  @Setter
  private String mrn;

  @Getter  @Setter
  private String mrnAuthority;

  @Getter  @Setter
  private String nameFirst;

  @Getter  @Setter
  private String nameMiddle;

  @Getter  @Setter
  private String nameLast;

  @Getter  @Setter
  private String nameType;

  @Getter  @Setter
  private String motherMaidenNameLast;

  @Getter  @Setter
  private String dateOfBirth;

  @Getter  @Setter
  private String sex;

  @Getter  @Setter
  private String raceCode;

  @Getter  @Setter
  private String raceDescription;

  @Getter  @Setter
  private String ethnicityCode;

  @Getter  @Setter
  private String ethnicityDescription;

  @Getter  @Setter
  private String phoneAreaCode;

  @Getter  @Setter
  private String phoneNumber;

  @Getter  @Setter
  private String addressLine1;

  @Getter  @Setter
  private String addressLine2;

  @Getter  @Setter
  private String addressCity;

  @Getter  @Setter
  private String addressState;

  @Getter  @Setter
  private String addressZip;

  @Getter  @Setter
  private String addressCountry;

  @Getter  @Setter
  private String guardianNameFirst;

  @Getter  @Setter
  private String guardianNameLast;

  @Getter  @Setter
  private String guardianRelationship;

}
