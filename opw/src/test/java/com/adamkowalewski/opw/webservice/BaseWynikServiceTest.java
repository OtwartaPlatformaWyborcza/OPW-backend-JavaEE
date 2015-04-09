package com.adamkowalewski.opw.webservice;

import com.adamkowalewski.opw.webservice.controller.WynikEjb;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg;
import org.mockito.Mockito;

import javax.ws.rs.core.Application;

public abstract class BaseWynikServiceTest extends JerseyTestNg.ContainerPerMethodTest {

    protected static WynikService wynikService = new WynikService();
    protected static WynikEjb wynikEjb = Mockito.mock(WynikEjb.class);

    protected static class MockWynikServiceFactory implements Factory<WynikService> {
        @Override
        public WynikService provide() {
            wynikService.wynikEjb = wynikEjb;
            return wynikService;
        }

        @Override
        public void dispose(WynikService wynikService) {
            /* Nothing to do here */
        }
    }

    @Override
    public Application configure() {
        AbstractBinder binder = new AbstractBinder() {
            @Override
            protected void configure() {
                bindFactory(MockWynikServiceFactory.class)
                        .to(WynikService.class);
            }
        };
        ResourceConfig config = new ResourceConfig(WynikService.class);
        config.register(binder);
        return config;
    }
}
