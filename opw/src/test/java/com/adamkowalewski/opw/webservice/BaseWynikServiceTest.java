package com.adamkowalewski.opw.webservice;

import com.adamkowalewski.opw.view.controller.KandydatController;
import com.adamkowalewski.opw.view.controller.OkregowaController;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg;
import org.mockito.Mockito;

import javax.ws.rs.core.Application;

public abstract class BaseWynikServiceTest extends JerseyTestNg.ContainerPerMethodTest {

    protected static WynikService wynikService = new WynikService();
    protected static KandydatController kandydatController = Mockito.mock(KandydatController.class);
    protected static OkregowaController okregowaController = Mockito.mock(OkregowaController.class);

//    protected static class MockWynikServiceFactory implements Factory<WynikService> {
//        @Override
//        public WynikService provide() {
//            wynikService.kandydatController = kandydatController;
//            wynikService.okregowaController = okregowaController;
//            return wynikService;
//        }
//
//        @Override
//        public void dispose(WynikService wynikService) {
//            /* Nothing to do here */
//        }
//    }
//
//    @Override
//    public Application configure() {
//        AbstractBinder binder = new AbstractBinder() {
//            @Override
//            protected void configure() {
//                bindFactory(MockWynikServiceFactory.class)
//                        .to(WynikService.class);
//            }
//        };
//        ResourceConfig config = new ResourceConfig(WynikService.class);
//        config.register(binder);
//        return config;
//    }
}
