package com.immunization.reference.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.immunization.reference.iis.ClientService;
import com.immunization.reference.manager.HL7MessageManager;
import com.immunization.reference.manager.IISClientFactory;
import com.immunization.reference.manager.IISManager;
import lombok.Getter;

@Getter
public class HandlerDependencies {

    private final IISManager iisManager;
    private final HL7MessageManager hl7MessageManager;
    private final ObjectMapper mapper;

    public HandlerDependencies() {

        hl7MessageManager = new HL7MessageManager();
        iisManager = new IISManager(new ClientService());

        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}