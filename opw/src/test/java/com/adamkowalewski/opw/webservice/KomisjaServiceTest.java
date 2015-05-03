package com.adamkowalewski.opw.webservice;

import com.adamkowalewski.opw.webservice.dto.*;
import com.google.gson.Gson;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static com.adamkowalewski.opw.webservice.AbstractService.OPW_HEADER_LOGIN;
import static com.adamkowalewski.opw.webservice.AbstractService.OPW_HEADER_TOKEN;
import static com.cedarsoftware.util.DeepEquals.deepEquals;
import static java.lang.String.format;
import static javax.ws.rs.client.Entity.entity;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.OK;
import static org.eclipse.jetty.http.HttpStatus.OK_200;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

public class KomisjaServiceTest extends BaseKomisjaServiceTest {

    @AfterMethod
    public void resetMocks() {
        Mockito.reset(komisjaServiceEjb);
    }

    @Test
    public void shouldLoadObwodowa() throws Exception {
        // given
        String pkwId = "1212-1";
        String login = "admin";
        String token = "token";
        KomisjaDto ecpectedKomisja = new KomisjaDto();
        when(komisjaServiceEjb.loadObwodowa(anyString(), anyString(), anyString()))
                .thenReturn(GResultDto.validResult(OK_200, ecpectedKomisja));

        // when
        Response response = target(format("komisja/%s", pkwId)).request()
                .header(OPW_HEADER_LOGIN, login)
                .header(OPW_HEADER_TOKEN, token)
                .get();

        // then
        assertEquals(response.getStatus(), OK_200);
        assertNotNull(response.getEntity());
        assertTrue(deepEquals(response.readEntity(KomisjaDto.class), ecpectedKomisja));
    }

    @Test
    public void shouldLoadWynik() throws Exception {
        // given
        String pkwId = "1212-1";
        String login = "admin";
        String token = "token";
        List<WynikShortDto> expectedWynikList = new ArrayList<>(0);
        GenericEntity<List<WynikShortDto>> expectedWynik = new GenericEntity<List<WynikShortDto>>(expectedWynikList) {
        };
        when(komisjaServiceEjb.loadWynik(anyString(), anyString(), anyString()))
                .thenReturn(GResultDto.validResult(OK.getStatusCode(), expectedWynik));

        // when
        Response response = target(format("komisja/%s/protokol", pkwId)).request()
                .header(OPW_HEADER_LOGIN, login)
                .header(OPW_HEADER_TOKEN, token)
                .get();

        // then
        assertEquals(response.getStatus(), OK_200);
        assertNotNull(response.getEntity());
        assertTrue(deepEquals(expectedWynikList, response.readEntity(new GenericType<List<WynikShortDto>>() {
        })));
    }

    @Test
    public void shouldUploadWynik() throws Exception {
        // given
        String pkwId = "1212-1";
        String login = "admin";
        String token = "token";
        WynikDto wynikDto = new WynikDto();
        Gson gson = new Gson();
        String wynikDtoJson = gson.toJson(wynikDto);
        when(komisjaServiceEjb.uploadWynik(anyString(), anyString(), anyString(), Matchers.<WynikDto>anyObject()))
                .thenReturn(GResultDto.validResult(OK.getStatusCode()));

        // when
        Response response = target(format("komisja/%s/protokol", pkwId)).request()
                .header(OPW_HEADER_LOGIN, login)
                .header(OPW_HEADER_TOKEN, token)
                .post(entity(wynikDtoJson, APPLICATION_JSON));

        // then
        assertEquals(response.getStatus(), OK_200);
    }
}