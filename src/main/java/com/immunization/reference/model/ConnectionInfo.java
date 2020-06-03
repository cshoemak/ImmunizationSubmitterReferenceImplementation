package com.immunization.reference.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class ConnectionInfo {

  private final String userId;

  private final String password;

  private final String facility;

  private final String iisUrl;

}
