package com.adamkowalewski.opw.view.controller.csv;

import com.adamkowalewski.opw.view.dto.UserCsvDto;
import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.reader.CSVEntryParser;

public class UserCsvDtoReader extends AbstractCSVReader<UserCsvDto> {

    public static UserCsvDtoReader userCsvDtoReader() {
        return new UserCsvDtoReader(DEFAULT_STRATEGY);
    }

    public UserCsvDtoReader(CSVStrategy csvStrategy) {
        super(csvStrategy);
    }

    @Override
    protected CSVEntryParser<UserCsvDto> getCsvEntryParser() {
        return new UserCsvDtoParser();
    }
}
