package com.adamkowalewski.opw.webservice;

import com.adamkowalewski.opw.webservice.controller.KomisjaServiceEjb;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg;
import org.mockito.Mockito;

import javax.ws.rs.core.Application;

public class BaseKomisjaServiceTest extends JerseyTestNg.ContainerPerMethodTest {

    protected static KomisjaService komisjaService = new KomisjaService();
    protected static KomisjaServiceEjb komisjaServiceEjb = Mockito.mock(KomisjaServiceEjb.class);

    protected static class MockKomisjaServiceFactory implements Factory<KomisjaService> {
        @Override
        public KomisjaService provide() {
            komisjaService.komisjaServiceEjb = komisjaServiceEjb;
            return komisjaService;
        }

        @Override
        public void dispose(KomisjaService wynikService) {
            /* Nothing to do here */
        }
    }

    @Override
    public Application configure() {
        AbstractBinder binder = new AbstractBinder() {
            @Override
            protected void configure() {
                bindFactory(MockKomisjaServiceFactory.class)
                        .to(KomisjaService.class);
            }
        };
        ResourceConfig config = new ResourceConfig(KomisjaService.class);
        config.register(binder);
        return config;
    }
}
