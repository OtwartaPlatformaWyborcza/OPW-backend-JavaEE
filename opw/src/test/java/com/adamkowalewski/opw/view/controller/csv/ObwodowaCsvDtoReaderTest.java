package com.adamkowalewski.opw.view.controller.csv;

import com.adamkowalewski.opw.view.dto.ObwodowaCsvDto;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.testng.Assert.assertEquals;

public class ObwodowaCsvDtoReaderTest {

    @Test
    public void shouldReadAllEntries() throws Exception {
        // given
        InputStream inputStream = this.getClass().getResourceAsStream("/komisje_obwodowe_test.csv");
        List<ObwodowaCsvDto> expectedObwodowaCsvDtos = newArrayList(
                new ObwodowaCsvDto(14, "106101-1", 1, "Studio Consulting Sp. z o.o.", "ul. Romanowska 55E, 91-174 Łódź", "P", 1234),
                new ObwodowaCsvDto(15, "106101-2", 2, "Studio Consulting Sp. z o.o.", "ul. Romanowska 56E, 91-174 Łódź", "P", 5434),
                new ObwodowaCsvDto(16, "106101-3", 3, "Studio Consulting Sp. z o.o.", "ul. Romanowska 57E, 91-174 Łódź", "P", 3454)
        );

        // when
        List<ObwodowaCsvDto> actualObwodowaCsvDtos = ObwodowaCsvDtoReader.obwodowaCsvDtoReader().readAllFrom(inputStream);

        // then
        assertEquals(expectedObwodowaCsvDtos, actualObwodowaCsvDtos);
    }
}