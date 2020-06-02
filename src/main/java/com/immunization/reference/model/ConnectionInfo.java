package com.immunization.reference.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class ConnectionInfo {

  private String userId;

  private String password;

  private String facility;

  private String iisUrl;

}
