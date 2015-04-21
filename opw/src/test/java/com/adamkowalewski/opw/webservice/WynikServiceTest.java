package com.adamkowalewski.opw.webservice;

import com.adamkowalewski.opw.entity.OpwKandydat;
import com.adamkowalewski.opw.entity.OpwOkregowaKomisja;
import com.adamkowalewski.opw.webservice.dto.DashboardDto;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;
import java.util.ArrayList;

import static com.adamkowalewski.opw.webservice.AbstractService.OPW_HEADER_API_TOKEN;
import static com.adamkowalewski.opw.webservice.AbstractService.mockAPITokenId;
import static com.google.common.collect.Lists.newArrayList;
import static org.eclipse.jetty.http.HttpStatus.OK_200;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WynikServiceTest extends BaseWynikServiceTest {

    @Test
    public void shouldFetchWynik() {
        // given
        String login = "login";
        OpwKandydat k = new OpwKandydat();
        k.setPkwId(1111);
        k.setFirstname("John");
        k.setLastname("Doe");
        ArrayList<OpwKandydat> opwKandydats = newArrayList(k);
        when(wynikEjb.kandydatFindAll())
                .thenReturn(opwKandydats);
        OpwOkregowaKomisja okr = new OpwOkregowaKomisja();
        okr.setName("Komisja 22");
        okr.setPkwId(22);
        ArrayList<OpwOkregowaKomisja> opwOkregowaKomisjas = newArrayList(okr);
        when(wynikEjb.obwodowaFindAll())
                .thenReturn(opwOkregowaKomisjas);

        // when
        Response response = target("wynik/complete").request()                
                .header(OPW_HEADER_API_TOKEN, mockAPITokenId)
                .get();
        DashboardDto actualContent = response.readEntity(DashboardDto.class);

        // then
        assertEquals(response.getStatus(), OK_200);
        assertTrue(actualContent != null);
    }
}