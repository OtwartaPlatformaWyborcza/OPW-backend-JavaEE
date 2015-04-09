package com.adamkowalewski.opw.webservice;

import com.adamkowalewski.opw.webservice.dto.KandydatDto;
import com.adamkowalewski.opw.webservice.dto.KomisjaDto;
import com.adamkowalewski.opw.webservice.dto.OkregowaDto;
import com.adamkowalewski.opw.webservice.dto.UploadWynikDto;
import com.google.gson.Gson;
import org.mockito.Mockito;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;
import java.util.ArrayList;

import static com.cedarsoftware.util.DeepEquals.deepEquals;
import static com.google.common.collect.Lists.newArrayList;
import static java.lang.String.format;
import static javax.ws.rs.client.Entity.entity;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.eclipse.jetty.http.HttpStatus.NO_CONTENT_204;
import static org.eclipse.jetty.http.HttpStatus.OK_200;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class KomisjaServiceTest extends BaseKomisjaServiceTest {

    @AfterMethod
    public void resetMocks() {
        Mockito.reset(kandydatEjb);
    }

    @Test
    public void shouldLoadObwodowa() throws Exception {
        // given
        String pkwId = "1212-1";
        ArrayList<KandydatDto> expectedKandydatDtos = newArrayList(
                new KandydatDto(1, "Bolek"),
                new KandydatDto(2, "Lolek"),
                new KandydatDto(3, "Jacek"),
                new KandydatDto(4, "Placek")
        );
        KomisjaDto ecpectedKomisja = new KomisjaDto(
                pkwId,
                "Koisja obowdow 22",
                "szkola 11 Liswøł",
                new OkregowaDto(
                        "OKR-ABCD",
                        "Komisja Wawa",
                        "ul. wiejska 11"),
                expectedKandydatDtos
        );
        when(kandydatEjb.findAllDto())
                .thenReturn(expectedKandydatDtos);

        // when
        Response response = target(format("komisja/%s", pkwId)).request().get();
        KomisjaDto actualKomisja = response.readEntity(KomisjaDto.class);

        // then
        assertEquals(response.getStatus(), OK_200);
        assertTrue(deepEquals(actualKomisja, ecpectedKomisja));
    }

    @Test
    public void shouldNotLoadObwodowa() throws Exception {
        // given
        String pkwId = "unknown";
        when(kandydatEjb.findAllDto())
                .thenReturn(new ArrayList<KandydatDto>(0));

        // when
        Response response = target(format("komisja/%s", pkwId)).request().get();
        String content = response.readEntity(String.class);

        // then
        assertEquals(response.getStatus(), NO_CONTENT_204);
        assertTrue(content.isEmpty());
    }

    @Test
    public void shouldNotUploadWyniki() throws Exception {
        // given
        String pkwId = "unknown";
        UploadWynikDto uploadWynikDto = new UploadWynikDto();
        Gson gson = new Gson();
        String uploadWynikDtoJson = gson.toJson(uploadWynikDto);

        // when
        Response response = target(format("komisja/%s/protokol", pkwId))
                .request().post(entity(uploadWynikDtoJson, APPLICATION_JSON));

        // then
        assertEquals(response.getStatus(), NO_CONTENT_204);
    }

    @Test(enabled = false)
    public void shouldUploadWyniki() throws Exception {

    }
}