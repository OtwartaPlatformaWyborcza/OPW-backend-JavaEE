package com.adamkowalewski.opw.webservice;

import com.adamkowalewski.opw.webservice.controller.UserServiceEjb;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg;
import org.mockito.Mockito;

import javax.ws.rs.core.Application;

public class BaseUserServiceTest extends JerseyTestNg.ContainerPerClassTest {

    protected static UserService userService = new UserService();
    protected static UserServiceEjb userServiceEjb = Mockito.mock(UserServiceEjb.class);

    protected static class MockUserServiceFactory implements Factory<UserService> {
        @Override
        public UserService provide() {
            userService.userServiceEjb = userServiceEjb;
            return userService;
        }

        @Override
        public void dispose(UserService service) {
            /* Nothing to do here */
        }
    }

    @Override
    public Application configure() {
        AbstractBinder binder = new AbstractBinder() {
            @Override
            protected void configure() {
                bindFactory(MockUserServiceFactory.class)
                        .to(UserService.class);
            }
        };
        ResourceConfig config = new ResourceConfig(UserService.class);
        config.register(binder);
        return config;
    }
}
