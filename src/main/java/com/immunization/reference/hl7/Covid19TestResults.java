package com.immunization.reference.hl7;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class Covid19TestResults {
    private final String mrn;
    private final String mrnAuthority;
    private final String nameFirst;
    private final String nameMiddle;
    private final String nameLast;
    private final String nameType;
    private final String motherMaidenNameLast;
    private final String dateOfBirth;
    private final String sex;
    private final String race;
    private final String ethnicity;
    private final String phoneAreaCode;
    private final String phoneNumber;
    private final String addressLine1;
    private final String addressLine2;
    private final String addressCity;
    private final String addressState;
    private final String addressZip;
    private final String addressCountry;
    private final String guardianNameFirst;
    private final String guardianNameLast;
    private final String guardianRelationship;
    
    private final String observationCode;
    private final String observationCodeSet;
    private final String observationResult;
    private final String observationResultSet;
    private final String observationDate;
}
