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

import com.adamkowalewski.opw.webservice.dto.KomisjaShortDto;
import com.adamkowalewski.opw.webservice.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Represents user perspective.
 *
 * @author Adam Kowalewski
 */
@Path("/user")
public class UserService extends AbstractService {

    @GET
    @Path("/{userId}/obwodowa")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response loadObwodowaShortList(@PathParam("userId") int userId) {

        List<KomisjaShortDto> resultList = new ArrayList<>();
        resultList.add(new KomisjaShortDto(1, "1212-01", "Komisja 1", "adres 1"));
        resultList.add(new KomisjaShortDto(2, "1212-02", "Komisja 2", "adres 2"));
        resultList.add(new KomisjaShortDto(3, "1212-03", "Komisja 3", "adres 3"));
        
        GenericEntity<List<KomisjaShortDto>> result = new GenericEntity<List<KomisjaShortDto>>(resultList) {
        };

        Response response = Response.ok()
                .entity(result)
                .build();

        response = addCorsHeaders(response);
        return response;
    }

    @GET
    @Path("/login")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response login(@NotNull @HeaderParam("login") String login,
            @NotNull @HeaderParam("password") String password) {

        if (login.equals("admin") && password.equals("admin")) {

            Response response = Response.ok()
                    .entity(new UserDto(1, "Mock admina", "token1234", true))
                    .build();

            response = addCorsHeaders(response);
            return response;
        }
        Response response = Response.status(Response.Status.UNAUTHORIZED)
                .build();

        response = addCorsHeaders(response);
        return response;
    }

    @GET
    @Path("/logout")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response logout(@NotNull @HeaderParam("login") String login,
            @NotNull @HeaderParam("token") String token) {

        Response response = Response.ok()
                .entity(new UserDto(false))
                .build();

        response = addCorsHeaders(response);
        return response;
    }
    
}
