package com.adamkowalewski.opw.view.controller.csv;

import com.adamkowalewski.opw.view.dto.UserCsvDto;
import com.googlecode.jcsv.reader.CSVEntryParser;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * The UserCsvDtoParser receives a line of the csv file and converts it
 * to a UserCsvDto object.
 * <p/>
 * Given csv file format is:
 * Imie;Nazwisko;Email;Typ;komisjeObwodowe
 */
class UserCsvDtoParser implements CSVEntryParser<UserCsvDto> {
    @Override
    public UserCsvDto parseEntry(String... data) {
        String firstname = data[0].trim();
        String lastname = data[1].trim();
        String email = data[2].trim();
        String type = data[3].trim();
        List<String> obwodowaList = newArrayList(data[4].trim().split(","));
        obwodowaList = trimElements(obwodowaList);

        return new UserCsvDto(firstname, lastname, email, type, obwodowaList);
    }

    private List<String> trimElements(List<String> elements) {
        for (int i = 1; i < elements.size(); ++i) {
            String element = elements.get(i).trim();
            if (element.isEmpty()) {
                elements.remove(i);
            } else {
                elements.set(i, element);
            }
        }
        return elements;
    }
}
