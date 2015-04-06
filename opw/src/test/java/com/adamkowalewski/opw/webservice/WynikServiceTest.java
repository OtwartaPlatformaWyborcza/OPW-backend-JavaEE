package com.adamkowalewski.opw.webservice;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg;
import org.testng.annotations.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static com.adamkowalewski.opw.webservice.AbstractService.OPW_HEADER_LOGIN;
import static org.eclipse.jetty.http.HttpStatus.OK_200;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WynikServiceTest extends JerseyTestNg.ContainerPerMethodTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(WynikService.class);
    }

    @Test(enabled = false)
    public void shouldFetchWynik() {
        // given
        String login = "login";

        // when
        Response response = target("wynik").request()
                .header(OPW_HEADER_LOGIN, login)
                .get();
        String content = response.readEntity(String.class);

        // then
        assertEquals(response.getStatus(), OK_200);
        assertTrue(content.isEmpty());
    }

}