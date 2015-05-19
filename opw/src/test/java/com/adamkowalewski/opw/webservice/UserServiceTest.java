package com.adamkowalewski.opw.webservice;

import com.adamkowalewski.opw.webservice.dto.GResultDto;
import com.adamkowalewski.opw.webservice.dto.KomisjaShortDto;
import com.adamkowalewski.opw.webservice.dto.UserRegisterDto;
import com.google.gson.Gson;
import org.mockito.Mockito;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static com.adamkowalewski.opw.webservice.AbstractService.*;
import static com.cedarsoftware.util.DeepEquals.deepEquals;
import static java.lang.String.format;
import static javax.ws.rs.client.Entity.entity;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.eclipse.jetty.http.HttpStatus.OK_200;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;


public class UserServiceTest extends BaseUserServiceTest {

    @AfterMethod
    public void resetMocks() {
        Mockito.reset(userServiceEjb);
    }

    @Test(enabled = false)
    public void shouldLoadObwodowaShortList() throws Exception {
        // given
        int userId = 1234;
        String login = "login";
        String token = "token1234";

        List<KomisjaShortDto> expectedResult = new ArrayList<>();
        GenericEntity<List<KomisjaShortDto>> result = new GenericEntity<List<KomisjaShortDto>>(expectedResult) {
        };
        when(userServiceEjb.loadObwodowaShortList(anyInt(), anyString(), anyString()))
                .thenReturn(GResultDto.validResult(OK_200, result));

        // when
        Response response = target(format("user/%s/obwodowa", userId)).request()
                .header(OPW_HEADER_LOGIN, login)
                .header(OPW_HEADER_TOKEN, token)
                .get();

        // then
        assertEquals(response.getStatus(), OK_200);
        assertNotNull(response.getEntity());
        assertTrue(deepEquals(expectedResult, response.readEntity(new GenericType<List<KomisjaShortDto>>() {
        })));
    }


    @Test(enabled = false)
    public void shoulLogin() throws Exception {
        // given
        String login = "user";
        String password = "password";
        when(userServiceEjb.login(anyString(), anyString()))
                .thenReturn(GResultDto.validResult(OK_200));

        // when
        Response response = target("user/login").request()
                .header(OPW_HEADER_LOGIN, login)
                .header(OPW_HEADER_PASSWORD, password)
                .get();

        // then
        assertEquals(response.getStatus(), OK_200);
        assertTrue(response.readEntity(String.class).isEmpty());
    }

    @Test(enabled = false)
    public void shouldLogout() throws Exception {
        // given
        String login = "user";
        String token = "token1234";
        when(userServiceEjb.logout(anyString(), anyString()))
                .thenReturn(GResultDto.validResult(OK_200));

        // when
        Response response = target("user/logout").request()
                .header(OPW_HEADER_LOGIN, login)
                .header(OPW_HEADER_TOKEN, token)
                .get();

        // then
        assertEquals(response.getStatus(), OK_200);
    }

    @Test(enabled = false)
    public void shouldRegister() throws Exception {
        // given
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        Gson gson = new Gson();
        String userRegisterDtoJson = gson.toJson(userRegisterDto);
        when(userServiceEjb.register(anyString(), anyString(), Mockito.<UserRegisterDto>anyObject()))
                .thenReturn(GResultDto.validResult(OK_200));

        // when
        Response response = target("user/register").request()
                .header(OPW_HEADER_API_CLIENT, "apiClient")
                .header(OPW_HEADER_API_TOKEN, "apiToken1234")
                .post(entity(userRegisterDtoJson, APPLICATION_JSON));

        // then
        assertEquals(response.getStatus(), OK_200);
    }

    @Test(enabled = false)
    public void shouldCheckEmail() throws Exception {
        // given
        String email = "testuser@example.com";
        when(userServiceEjb.checkEmail(email))
                .thenReturn(GResultDto.validResult(OK_200));

        // when
        Response response = target(format("user/available/%s", email)).request().get();

        // then
        assertEquals(response.getStatus(), OK_200);
    }
}
