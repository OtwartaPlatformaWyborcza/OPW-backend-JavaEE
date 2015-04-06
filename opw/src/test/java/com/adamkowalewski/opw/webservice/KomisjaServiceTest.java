package com.adamkowalewski.opw.webservice;

import com.adamkowalewski.opw.webservice.dto.KandydatDto;
import com.adamkowalewski.opw.webservice.dto.KomisjaDto;
import com.adamkowalewski.opw.webservice.dto.OkregowaDto;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg;
import org.testng.annotations.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import java.util.List;

import static com.cedarsoftware.util.DeepEquals.deepEquals;
import static com.google.common.collect.Lists.newArrayList;
import static java.lang.String.format;
import static org.eclipse.jetty.http.HttpStatus.OK_200;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class KomisjaServiceTest extends JerseyTestNg.ContainerPerMethodTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(KomisjaService.class);
    }

    @Test
    public void shouldLoadObwodowa() throws Exception {
        // given
        String pkwId = "1212-1";
        List<KandydatDto> ecpectedKandydatList = newArrayList(
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
                ecpectedKandydatList
        );

        // when
        Response response = target(format("komisja/%s", pkwId)).request().get();
        KomisjaDto actualKomisja = response.readEntity(KomisjaDto.class);

        // then
        assertEquals(response.getStatus(), OK_200);
        assertTrue(deepEquals(actualKomisja, ecpectedKomisja));
    }

    @Test(enabled = false)
    public void shouldUploadWyniki()  throws Exception {

    }
}