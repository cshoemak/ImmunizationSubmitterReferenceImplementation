package com.immunization.reference.manager;

import com.immunization.reference.exception.IISException;
import com.immunization.reference.iis.ClientService;
import com.immunization.reference.iis.IISPortType;

public class IISManager {
    private final ClientService service;

    public IISManager(final ClientService service) {

        this.service = service;
    }

    public String submitMessage(final String username, final String password, final String facility,
            final String message) {

        final IISPortType port = service.getClientPortSoap12();
        try {
            return port.submitSingleMessage(username, password, facility, message);
        } catch (Exception ex) {
            throw new IISException(ex);
        }
    }
}