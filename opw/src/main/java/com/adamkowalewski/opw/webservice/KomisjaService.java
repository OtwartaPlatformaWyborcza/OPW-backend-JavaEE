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

import com.adamkowalewski.opw.webservice.controller.KomisjaServiceEjb;
import com.adamkowalewski.opw.webservice.dto.WynikDto;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST Service represents komisja perspective.
 *
 * @author Adam Kowalewski
 */
@Path("/komisja")
@RequestScoped
public class KomisjaService extends AbstractService {
    
    private final static Logger logger = LoggerFactory.getLogger(KomisjaService.class);

    @EJB
    KomisjaServiceEjb komisjaServiceEjb;

    @GET
    @Path("/{pkwId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response loadObwodowa(
            @NotNull @PathParam("pkwId") String pkwId,
            @NotNull @HeaderParam(OPW_HEADER_LOGIN) String login,
            @NotNull @HeaderParam(OPW_HEADER_TOKEN) String token,
            @HeaderParam(OPW_HEADER_DEBUG_ERROR500) String debug) {

        if (debug != null) {
            logger.debug(LOG_DBG_500);
            return mockServerError();
        }
        
        logger.trace("REST call Komisja {} Login {} ", pkwId, login);
        return komisjaServiceEjb.loadObwodowa(pkwId, login, token);
    }

    @POST
    @Path("/{pkwId}/protokol")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response uploadWynik(
            @NotNull @PathParam("pkwId") String pkwId,
            @NotNull @HeaderParam(OPW_HEADER_LOGIN) String login,
            @NotNull @HeaderParam(OPW_HEADER_TOKEN) String token,
            @HeaderParam(OPW_HEADER_DEBUG_ERROR500) String debug,
            WynikDto wynik) {

        if (debug != null) {
            logger.debug(LOG_DBG_500);
            return mockServerError();
        }
        logger.trace("REST call Komisja {} Login {} ", pkwId, login);
        return komisjaServiceEjb.uploadWynik(pkwId, login, token, wynik);
    }

}
