package com.immunization.reference.manager;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.immunization.reference.iis.ClientService;
import org.junit.jupiter.api.Test;

public class IISClientFactoryTest {

    @Test
    public void invalid_url_throws_exception() throws Exception {

        final IISClientFactory factory = new IISClientFactory();

        assertThrows(Exception.class, () -> {
            final ClientService service = factory.getClient("abcd");
        });
    }
}