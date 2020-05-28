package com.immunization.reference.config;

import com.immunization.reference.iis.ClientService;
import com.immunization.reference.manager.HL7MessageManager;
import com.immunization.reference.manager.IISManager;

public class HandlerDependencies {

    private final IISManager iisManager;
    private final HL7MessageManager hl7MessageManager;

    public HandlerDependencies() {
        hl7MessageManager = new HL7MessageManager();
        iisManager = new IISManager(new ClientService());
    }

    public IISManager getIisManager() {
        return iisManager;
    }

    public HL7MessageManager getHl7MessageManager() {
        return hl7MessageManager;
    }
}