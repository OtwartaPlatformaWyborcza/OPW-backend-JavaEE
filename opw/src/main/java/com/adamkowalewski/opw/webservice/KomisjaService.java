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

import com.adamkowalewski.opw.webservice.dto.KandydatDto;
import com.adamkowalewski.opw.webservice.dto.KomisjaDto;
import com.adamkowalewski.opw.webservice.dto.OkregowaDto;
import com.adamkowalewski.opw.webservice.dto.UploadWynikDto;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST SErvice represents komisja perspective.
 *
 * @author Adam Kowalewski
 */
@Path("/komisja")
public class KomisjaService extends AbstractService {

    @GET
    @Path("/{pkwId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response loadObwodowa(@PathParam("pkwId") String pkwId) {

        if (pkwId.equals("1212-1")) {
            List<KandydatDto> kandydatList = new ArrayList<>();
            kandydatList.add(new KandydatDto(1, "Bolek"));
            kandydatList.add(new KandydatDto(2, "Lolek"));
            kandydatList.add(new KandydatDto(3, "Jacek"));
            kandydatList.add(new KandydatDto(4, "Placek"));

            KomisjaDto komisja = new KomisjaDto("1212-1", "Koisja obowdow 22", "szkola 11 Liswøł", new OkregowaDto("OKR-ABCD", "Komisja Wawa", "ul. wiejska 11"), kandydatList);
            Response result = Response.ok().entity(komisja).build();
            
            return result;
        }
        Response result = Response.noContent().build();
        
        return result;

    }

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response uploadWyniki(UploadWynikDto wynik) {
//        UploadWynikResultDto
        return null;
    }

}
