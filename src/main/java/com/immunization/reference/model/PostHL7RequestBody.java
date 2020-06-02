package com.immunization.reference.model;

import lombok.Getter;
import lombok.Setter;

public class PostHL7RequestBody {

  @Getter  @Setter
  private String hl7Payload;

  @Getter  @Setter
  private ConnectionInfo connectionInfo;

}
