package com.adamkowalewski.opw.view.controller.csv;

import com.adamkowalewski.opw.view.dto.ObwodowaCsvDto;
import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.reader.CSVEntryParser;

public class ObwodowaCsvDtoReader extends AbstractCSVReader<ObwodowaCsvDto> {

    public static ObwodowaCsvDtoReader obwodowaCsvDtoReader() {
        return new ObwodowaCsvDtoReader(DEFAULT_STRATEGY);
    }

    public ObwodowaCsvDtoReader(CSVStrategy csvStrategy) {
        super(csvStrategy);
    }

    @Override
    protected CSVEntryParser<ObwodowaCsvDto> getCsvEntryParser() {
        return new ObwodowaCsvDtoParser();
    }
}
