package com.immunization.reference.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
public class PostHL7RequestBody {

  private String hl7Payload;

  private ConnectionInfo connectionInfo;

}
