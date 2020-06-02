package com.immunization.reference.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class PostHL7RequestBody {

  private String hl7Payload;

  private ConnectionInfo connectionInfo;

}
