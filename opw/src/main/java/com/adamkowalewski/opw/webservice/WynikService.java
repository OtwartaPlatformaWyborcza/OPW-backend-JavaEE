/*
 * The MIT License
 *
 * Copyright 2015 Adam Kowalewski.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.adamkowalewski.opw.webservice;

import com.adamkowalewski.opw.entity.OpwKandydat;
import com.adamkowalewski.opw.entity.OpwOkregowaKomisja;
import com.adamkowalewski.opw.view.controller.KandydatController;
import com.adamkowalewski.opw.view.controller.OkregowaController;
import com.adamkowalewski.opw.webservice.dto.DashboardDto;
import com.adamkowalewski.opw.webservice.dto.KandydatDto;
import com.adamkowalewski.opw.webservice.dto.WynikOkregowaDto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

import static com.google.common.base.Preconditions.checkState;

/**
 * Represents wynik perspective. Main service for all OPW dashboard
 * applications.
 *
 * @author Adam Kowalewski
 */
@Path("/wynik")
@RequestScoped
public class WynikService extends AbstractService {

    @Inject
    KandydatController kandydatController;
    
    @Inject
    OkregowaController okregowaController;

    @GET
    @Path("/complete")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response wynik() {

        DashboardDto result = new DashboardDto(new Date(1428517345709l), 24500, 24500, 40000000, 20000000);

        List<OpwKandydat> kandydatList = kandydatController.findAll();

        for (int i = 0; i < kandydatList.size(); i++) {
            OpwKandydat kandydat = kandydatList.get(i);
            checkState(kandydat.getPkwId() != null, "Expected non-null pkwId field");
            checkState(kandydat.getName() != null, "Expected non-null name field");

            KandydatDto kandydatDto = new KandydatDto(kandydat.getPkwId(), kandydat.getName());
            kandydatDto.setGlosow(1000 - ((1000 % (i + 1)) * (1000 / (i + 1))));
            result.getKandydatList().add(kandydatDto);
        }
        
        List<OpwOkregowaKomisja> okregowaList = okregowaController.findAll();
        for (OpwOkregowaKomisja okregowa : okregowaList) {
            checkState(okregowa.getName() != null, "Expected non-null name field");

            WynikOkregowaDto wynikOkregowaDto = new WynikOkregowaDto(
                    okregowa.getName(),
                    154967,
                    750000,
                    157,
                    800
            );
            result.getOkregowaList().add(wynikOkregowaDto);
        }
        

        return Response.ok().entity(result).build();
    }

}
