package com.adamkowalewski.opw.webservice;

import com.adamkowalewski.opw.webservice.dto.KomisjaShortDto;
import com.adamkowalewski.opw.webservice.dto.UserDto;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg;
import org.testng.annotations.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static com.adamkowalewski.opw.webservice.AbstractService.*;
import static com.cedarsoftware.util.DeepEquals.deepEquals;
import static java.lang.String.format;
import static org.eclipse.jetty.http.HttpStatus.OK_200;
import static org.eclipse.jetty.http.HttpStatus.UNAUTHORIZED_401;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserServiceTest extends JerseyTestNg.ContainerPerMethodTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(UserService.class);
    }

    @Test
    public void shouldLoadObwodowaShortList() throws Exception {
        // given
        int userId = 1234;
        String login = "login";
        String token = "token1234";

        List<KomisjaShortDto> expectedResult = new ArrayList<>();
        for (int i = 1; i < 30; i++) {
            expectedResult.add(new KomisjaShortDto(i, "1212-" + i, "Komisja " + i, "adres " + i));
        }

        // when
        Response response = target(format("user/%s/obwodowa", userId)).request()
                .header(OPW_HEADER_LOGIN, login)
                .header(OPW_HEADER_TOKEN, token)
                .get();
        List<KomisjaShortDto> actualResult = response.readEntity(new GenericType<List<KomisjaShortDto>>() {});

        // then
        assertEquals(response.getStatus(), OK_200);
        assertTrue(deepEquals(expectedResult, actualResult));
    }

    @Test
    public void shouldLogin() throws Exception {
        // given
        String login = "admin";
        String password = "admin";
        UserDto expectedResponse = new UserDto(1, "Mock admina", "token1234", true);

        // when
        Response response = target("user/login").request()
                .header(OPW_HEADER_LOGIN, login)
                .header(OPW_HEADER_PASSWORD, password)
                .get();
        UserDto actualResponse = response.readEntity(UserDto.class);

        // then
        assertEquals(response.getStatus(), OK_200);
        assertTrue(deepEquals(expectedResponse, actualResponse));
    }

    @Test
    public void shouldNotLogin() throws Exception {
        // given
        String login = "unknown";
        String password = "incorrect";

        // when
        Response response = target("user/login").request()
                .header(OPW_HEADER_LOGIN, login)
                .header(OPW_HEADER_PASSWORD, password)
                .get();
        String content = response.readEntity(String.class);

        // then
        assertEquals(response.getStatus(), UNAUTHORIZED_401);
        assertTrue(content.isEmpty());
    }

    @Test
    public void shouldLogout() throws Exception {
        // given
        String login = "admin";
        String token = "token1234";
        UserDto expectedResponse = new UserDto(false);

        // when
        Response response = target("user/logout").request()
                .header(OPW_HEADER_LOGIN, login)
                .header(OPW_HEADER_TOKEN, token)
                .get();
        UserDto actualResponse = response.readEntity(UserDto.class);

        // then
        assertEquals(response.getStatus(), OK_200);
        assertTrue(deepEquals(expectedResponse, actualResponse));
    }
}