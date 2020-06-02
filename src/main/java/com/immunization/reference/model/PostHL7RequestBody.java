package com.immunization.reference.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostHL7RequestBody {

    private String hl7Payload;

    private ConnectionInfo connectionInfo;

}
