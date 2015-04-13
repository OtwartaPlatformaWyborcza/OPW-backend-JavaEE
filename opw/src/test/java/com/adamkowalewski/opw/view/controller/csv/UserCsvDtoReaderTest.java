package com.adamkowalewski.opw.view.controller.csv;

import com.adamkowalewski.opw.view.dto.UserCsvDto;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.testng.Assert.assertEquals;

public class UserCsvDtoReaderTest {

    @Test
    public void shouldReadAllEntries() throws Exception {
        // given
        InputStream inputStream = this.getClass().getResourceAsStream("/user_test.csv");
        List<UserCsvDto> expectedResult = newArrayList(
                new UserCsvDto("Jakub", "Arak", "jk@openpkw.pl", "O", newArrayList("146513-577", "146513-578", "146513-579", "146513-580")),
                new UserCsvDto("Marek", "Saganowski", "ms@openpkw.pl", "O", newArrayList("146513-510", "146513-511")),
                new UserCsvDto("Michał", "Kucharczyk", "mk@openpkw.pl", "M", newArrayList("146513-100", "146513-121", "146513-144"))
        );

        // when
        List<UserCsvDto> actualResult = UserCsvDtoReader.userCsvDtoReader().readAllFrom(inputStream);

        // then
        assertEquals(expectedResult, actualResult);
    }

}