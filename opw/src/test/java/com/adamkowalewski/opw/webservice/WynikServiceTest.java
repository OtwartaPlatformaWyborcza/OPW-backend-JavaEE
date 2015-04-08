package com.adamkowalewski.opw.webservice;

import com.adamkowalewski.opw.entity.OpwKandydat;
import com.adamkowalewski.opw.entity.OpwOkregowaKomisja;
import com.adamkowalewski.opw.webservice.dto.DashboardDto;
import com.adamkowalewski.opw.webservice.dto.KandydatDto;
import com.adamkowalewski.opw.webservice.dto.WynikOkregowaDto;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;

import static com.adamkowalewski.opw.webservice.AbstractService.OPW_HEADER_LOGIN;
import static com.cedarsoftware.util.DeepEquals.deepEquals;
import static com.google.common.collect.Lists.newArrayList;
import static org.eclipse.jetty.http.HttpStatus.OK_200;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WynikServiceTest extends BaseWynikServiceTest {

//    @Test(enabled = false)
//    public void shouldFetchWynik() {
//        // given
//        String login = "login";
//        DashboardDto expectedContent = new DashboardDto(new Date(1428517345709l), 24500, 24500, 40000000, 20000000);
//        expectedContent.getKandydatList().add(new KandydatDto(1111, "John Doe", 1000));
//        expectedContent.getOkregowaList().add(new WynikOkregowaDto("Komisja 22", 154967, 750000, 157, 800));
//
//        ArrayList<OpwKandydat> opwKandydats = newArrayList(new OpwKandydat(1111, "John Doe"));
//        when(kandydatController.findAll())
//                .thenReturn(opwKandydats);
//        ArrayList<OpwOkregowaKomisja> opwOkregowaKomisjas = newArrayList(new OpwOkregowaKomisja(22, "Komisja 22"));
//        when(okregowaController.findAll())
//                .thenReturn(opwOkregowaKomisjas);
//
//        // when
//        Response response = target("wynik/complete").request()
//                .header(OPW_HEADER_LOGIN, login)
//                .get();
//        DashboardDto actualContent = response.readEntity(DashboardDto.class);
//
//        // then
//        assertEquals(response.getStatus(), OK_200);
//        assertTrue(deepEquals(expectedContent, actualContent));
//    }
}