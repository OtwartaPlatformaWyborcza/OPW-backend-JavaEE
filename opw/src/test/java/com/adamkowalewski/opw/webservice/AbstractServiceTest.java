package com.adamkowalewski.opw.webservice;

import com.adamkowalewski.opw.entity.OpwUser;
import com.adamkowalewski.opw.webservice.dto.GResultDto;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;

import static com.cedarsoftware.util.DeepEquals.deepEquals;
import static javax.ws.rs.core.Response.Status.OK;
import static org.testng.Assert.assertTrue;


public class AbstractServiceTest {

    @Test
    public void shouldBuildResponse() {
        // given
        GResultDto result = GResultDto.result(OK);
        AbstractService service = new AbstractService() {};

        // when
        Response response = service.buildResponse(result);

        // then
        assertTrue(response.getStatus() == OK.getStatusCode());
    }

    @Test
    public void shouldBuildResponseWithSimpleEntity() {
        // given
        GResultDto result = GResultDto.result(OK, 1);
        AbstractService service = new AbstractService() {};

        // when
        Response response = service.buildResponse(result);

        // then
        assertTrue(response.getStatus() == OK.getStatusCode());
        assertTrue((Integer) response.getEntity() == 1);
    }

    @Test
    public void shouldBuildResponseWithObjectEntity() {
        // given
        GResultDto result = GResultDto.result(OK, new OpwUser());
        AbstractService service = new AbstractService() {};

        // when
        Response response = service.buildResponse(result);

        // then
        assertTrue(response.getStatus() == OK.getStatusCode());
        assertTrue(deepEquals(response.getEntity(), new OpwUser()));
    }
}