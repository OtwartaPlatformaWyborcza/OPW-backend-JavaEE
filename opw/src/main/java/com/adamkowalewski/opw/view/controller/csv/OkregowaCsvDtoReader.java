package com.adamkowalewski.opw.view.controller.csv;

import com.adamkowalewski.opw.view.dto.OkregowaCsvDto;
import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.reader.CSVEntryParser;

public class OkregowaCsvDtoReader extends AbstractCSVReader<OkregowaCsvDto> {

    public static OkregowaCsvDtoReader okregowaCsvDtoReader() {
        return new OkregowaCsvDtoReader(DEFAULT_STRATEGY);
    }

    public OkregowaCsvDtoReader(CSVStrategy csvStrategy) {
        super(csvStrategy);
    }

    @Override
    protected CSVEntryParser<OkregowaCsvDto> getCsvEntryParser() {
        return new OkregowaCsvDtoParser();
    }
}
