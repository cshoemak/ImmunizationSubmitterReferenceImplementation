package com.immunization.reference.model;

import lombok.Getter;
import lombok.Setter;

public class ConnectionInfo {

  @Getter  @Setter
  private String userId;

  @Getter  @Setter
  private String password;

  @Getter  @Setter
  private String facility;

  @Getter  @Setter
  private String iisUrl;

}
