package com.adamkowalewski.opw.view.controller;

import com.adamkowalewski.opw.view.controller.csv.OkregowaCsvDtoReader;
import com.adamkowalewski.opw.view.dto.OkregowaCsvDto;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.testng.Assert.assertEquals;

public class OkregowaCsvDtoReaderTest  {

    @Test
    public void shouldReadAllEntries() throws Exception {
        // given
        InputStream inputStream = OkregowaCsvDtoReaderTest.class.getResourceAsStream("/komisje_okregowe_test.csv");
        List<OkregowaCsvDto> expectedOkregowaCsvDtos = newArrayList(
                new OkregowaCsvDto(1,"Okręgowa Komisja Wyborcza Nr 1 we Wrocławiu", "milicki,oleśnicki,oławski,strzeliński,średzki,trzebnicki,wołowski,wrocławski", "Wrocław"),
                new OkregowaCsvDto(2,"Okręgowa Komisja Wyborcza Nr 2 w Jeleniej Górze", "bolesławiecki,jeleniogórski,kamiennogórski,lubański,lwówecki,zgorzelecki", "Jelenia Góra"),
                new OkregowaCsvDto(3,"Okręgowa Komisja Wyborcza Nr 3 w Legnicy", "głogowski,górowski,jaworski,legnicki,lubiński,polkowicki,złotoryjski", "Legnica"),
                new OkregowaCsvDto(4,"Okręgowa Komisja Wyborcza Nr 4 w Wałbrzychu", "dzierżoniowski,kłodzki,świdnicki,wałbrzyski,ząbkowicki", "Wałbrzych")
        );

        // when
        List<OkregowaCsvDto> actualOkregowaCsvDtos = OkregowaCsvDtoReader.okregowaCsvDtoReader().readAllFrom(inputStream);

        // then
        assertEquals(expectedOkregowaCsvDtos, actualOkregowaCsvDtos);
    }


}