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

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

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
    public Response loadObwodowaShortList(
            @NotNull @PathParam("userId") int userId,
            @NotNull @HeaderParam(OPW_HEADER_LOGIN) String login,
            @NotNull @HeaderParam(OPW_HEADER_TOKEN) String token) {
        checkArgument(login != null, "Expected non-null login argument");
        checkArgument(token != null, "Expected non-null token argument");

        List<KomisjaShortDto> resultList = new ArrayList<>(29);

        for (int i = 1; i < 30; i++) {
            resultList.add(new KomisjaShortDto(i, "1212-" + i, "Komisja " + i, "adres " + i));
        }

        GenericEntity<List<KomisjaShortDto>> result = new GenericEntity<List<KomisjaShortDto>>(resultList) {};

        Response response = Response.ok()
                .entity(result)
                .build();

        return response;
    }

    @GET
    @Path("/login")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response login(
            @NotNull @HeaderParam(OPW_HEADER_LOGIN) String login,
            @NotNull @HeaderParam(OPW_HEADER_PASSWORD) String password) {
        checkArgument(login != null, "Expected non-null login argument");
        checkArgument(password != null, "Expected non-null password argument");

        if (login.equals("admin") && password.equals("admin")) {

            Response response = Response.ok()
                    .entity(new UserDto(1, "Mock admina", "token1234", true))
                    .build();

            return response;
        }
        Response response = Response.status(Response.Status.UNAUTHORIZED)
                .build();

        return response;
    }

    @GET
    @Path("/logout")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response logout(
            @NotNull @HeaderParam(OPW_HEADER_LOGIN) String login,
            @NotNull @HeaderParam(OPW_HEADER_TOKEN) String token) {
        checkArgument(login != null, "Expected non-null login argument");
        checkArgument(token != null, "Expected non-null token argument");

        Response response = Response.ok()
                .entity(new UserDto(false))
                .build();

        return response;
    }

}
