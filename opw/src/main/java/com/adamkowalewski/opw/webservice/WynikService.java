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

import com.adamkowalewski.opw.bean.ConfigBean;
import com.adamkowalewski.opw.entity.OpwKandydat;
import com.adamkowalewski.opw.view.OpwConfigStatic;
import static com.adamkowalewski.opw.webservice.AbstractService.OPW_HEADER_DEBUG_ERROR500;
import com.adamkowalewski.opw.webservice.controller.WynikServiceEjb;
import com.adamkowalewski.opw.webservice.dto.DashboardDto;
import com.adamkowalewski.opw.webservice.dto.GResultDto;
import com.adamkowalewski.opw.webservice.dto.KandydatDto;
import com.adamkowalewski.opw.webservice.dto.LinkDto;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents wynik perspective. Main service for all OPW dashboard
 * applications.
 *
 * @author Adam Kowalewski
 */
@Path("/w")
@RequestScoped
public class WynikService extends AbstractService {

    private final static Logger logger = LoggerFactory.getLogger(WynikService.class);

    @EJB
    WynikServiceEjb wynikEjb;
    @EJB
    ConfigBean configBean;

    @GET
    @Path("/{wynikId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response loadWynikSingle(
            @HeaderParam(OPW_HEADER_DEBUG_ERROR500) String debug,
            @NotNull @HeaderParam(OPW_HEADER_LOGIN) String login,
            @NotNull @HeaderParam(OPW_HEADER_TOKEN) String token,
            @NotNull @PathParam("wynikId") int wynikId) {

        if (debug != null) {
            return mockServerError();
        }
        logger.trace("load wynik {}", wynikId);

        return buildResponse(wynikEjb.loadWynikSingle(wynikId, login, token));

    }

    @POST
    @Path("/{wynikId}/link")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response uploadLink(
            @NotNull @PathParam("wynikId") int wynikId,
            @NotNull @HeaderParam(OPW_HEADER_LOGIN) String login,
            @NotNull @HeaderParam(OPW_HEADER_TOKEN) String token,
            @HeaderParam(OPW_HEADER_DEBUG_ERROR500) String debug,
            LinkDto linkDto) {
        if (debug != null) {
            return mockServerError();
        }
        
        logger.trace("upload link to wynik {}", wynikId);
        return buildResponse(wynikEjb.uploadLink(wynikId, login, token, linkDto));
    }
    
    @DELETE
    @Path("/{wynikId}/link/{linkId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response disableLink(
            @NotNull @PathParam("wynikId") int wynikId,
            @NotNull @PathParam("linkId") int linkId,
            @HeaderParam(OPW_HEADER_DEBUG_ERROR500) String debug,
            @NotNull @HeaderParam(OPW_HEADER_LOGIN) String login,
            @NotNull @HeaderParam(OPW_HEADER_TOKEN) String token            
            ) {
        if (debug != null) {
            return mockServerError();
        }
        
        logger.trace("upload link to wynik {}", wynikId);
        return buildResponse(wynikEjb.disableLink(wynikId, linkId, login, token));
    }

    @GET
    @Path("/{wynikId}/positive")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response ratePositive(
            @HeaderParam(OPW_HEADER_DEBUG_ERROR500) String debug,
            @NotNull @PathParam("wynikId") int wynikId,
            @NotNull @HeaderParam(OPW_HEADER_LOGIN) String login,
            @NotNull @HeaderParam(OPW_HEADER_TOKEN) String token) {

        if (debug != null) {
            return mockServerError();
        }
        logger.trace("rate positive for wynik {}", wynikId);
        GResultDto<Integer> result = wynikEjb.ratePositive(wynikId);
        return Response.ok().build();
    }

    @GET
    @Path("/{wynikId}/negative")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response rateNegative(
            @HeaderParam(OPW_HEADER_DEBUG_ERROR500) String debug,
            @NotNull @PathParam("wynikId") int wynikId,
            @NotNull @HeaderParam(OPW_HEADER_LOGIN) String login,
            @NotNull @HeaderParam(OPW_HEADER_TOKEN) String token) {

        if (debug != null) {
            return mockServerError();
        }
        logger.trace("rate negative for wynik {}", wynikId);
        GResultDto<Integer> result = wynikEjb.rateNegative(wynikId);
        return Response.ok().build();
    }

    @GET
    @Path("/complete")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response wynik(
            @NotNull @HeaderParam(OPW_HEADER_API_TOKEN) String apiToken,
            @HeaderParam(OPW_HEADER_DEBUG_ERROR500) String debug) {

        if (debug != null) {
            return mockServerError();
        }

        // TODO refactoring konieczny 
        // aktualne liczby dostepne na http://prezydent2015.pkw.gov.pl/
        if (Boolean.valueOf(configBean.readConfigValue(OpwConfigStatic.CFG_KEY_CISZA_WYBORCZA))) {
            DashboardDto result = new DashboardDto(String.valueOf(new Date().getTime()), 27817, 0, 30768394, 0);

            List<OpwKandydat> kandydatList = wynikEjb.kandydatFindAll();

            for (OpwKandydat kandydat : kandydatList) {
                KandydatDto k = new KandydatDto(kandydat.getPkwId(), kandydat.getFirstname(), kandydat.getLastname());
                k.setGlosow(0);
                result.getKandydatList().add(k);
            }
            return Response.ok().entity(result).build();
        }

        return buildResponse(wynikEjb.wynik());
    }

}
