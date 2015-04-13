package com.adamkowalewski.opw.view.controller.csv;

import com.adamkowalewski.opw.view.dto.UserCsvDto;
import com.google.common.base.Splitter;
import com.googlecode.jcsv.reader.CSVEntryParser;

import java.util.List;

/**
 * The UserCsvDtoParser receives a line of the csv file and converts it
 * to a UserCsvDto object.
 * <p/>
 * Given csv file format is:
 * Imie;Nazwisko;Email;Typ;komisjeObwodowe
 */
public class UserCsvDtoParser implements CSVEntryParser<UserCsvDto> {
    @Override
    public UserCsvDto parseEntry(String... data) {
        String firstname = data[0];
        String lastname = data[1];
        String email = data[2];
        String type = data[3];
        List<String> obwodowaList = Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .splitToList(data[4]);
        return new UserCsvDto(firstname, lastname, email, type, obwodowaList);
    }
}
