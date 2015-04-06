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
import com.adamkowalewski.opw.session.controller.KandydatController;
import com.adamkowalewski.opw.webservice.dto.DashboardDto;
import com.adamkowalewski.opw.webservice.dto.KandydatDto;
import java.util.List;

import java.util.Random;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    
    @GET
    @Path("/complete")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response wynik() {

        DashboardDto result = new DashboardDto(24500, new Random().nextInt(20000));
        
        List<OpwKandydat> kandydatList = kandydatController.findAll();
        
        for (OpwKandydat kandydat : kandydatList) {
            KandydatDto k = new KandydatDto(kandydat.getPkwId(), kandydat.getName());           
            k.setGlosow(new Random().nextInt(1000));                        
            result.getKandydatList().add(k);
        }

        return Response.ok().entity(result).build();
    }

}
