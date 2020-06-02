package com.immunization.reference.manager;

import com.immunization.reference.iis.ClientService;

import java.net.URL;

public class IISClientFactory {

    public ClientService getClient(final String endpoint) throws Exception {

        final URL url = new URL(endpoint);
        return new ClientService(url);
    }
}