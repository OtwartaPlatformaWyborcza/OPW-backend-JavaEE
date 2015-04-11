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

import com.adamkowalewski.opw.webservice.controller.KandydatEjb;
import com.adamkowalewski.opw.webservice.dto.KandydatDto;
import com.adamkowalewski.opw.webservice.dto.KomisjaDto;
import com.adamkowalewski.opw.webservice.dto.OkregowaDto;
import com.adamkowalewski.opw.webservice.dto.UploadWynikDto;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import javax.validation.constraints.NotNull;

/**
 * REST Service represents komisja perspective.
 *
 * @author Adam Kowalewski
 */
@Path("/komisja")
@RequestScoped
public class KomisjaService extends AbstractService {

    @EJB
    KandydatEjb kandydatEjb;

    @GET
    @Path("/{pkwId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response loadObwodowa(
            @NotNull @PathParam("pkwId") String pkwId,
            @NotNull @HeaderParam(OPW_HEADER_LOGIN) String login,
            @NotNull @HeaderParam(OPW_HEADER_TOKEN) String token,
            @HeaderParam(OPW_HEADER_DEBUG_ERROR500) String debug) {

        if (debug != null) {
            return mockServerError();
        }
        if (verifyAccess(login, token) == false) {
            Response response = Response.status(Response.Status.UNAUTHORIZED)
                    .build();
            return response;
        }

        if (pkwId.equals("1212-1")) {

            List<KandydatDto> kandydatList = kandydatEjb.findAllDto();

            KomisjaDto komisja = new KomisjaDto("1212-1", "Koisja obowdow 22", "szkola 11 Liswøł", new OkregowaDto("OKR-ABCD", "Komisja Wawa", "ul. wiejska 11"), kandydatList);
            Response result = Response.ok().entity(komisja).build();

            return result;
        }

        Response result = Response.noContent().build();
        return result;
    }

    @POST
    @Path("/{pkwId}/protokol")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response uploadWyniki(@PathParam("pkwId") String pkwId, UploadWynikDto wynik) {
//        UploadWynikResultDto
        return Response.noContent().build();
    }

}
