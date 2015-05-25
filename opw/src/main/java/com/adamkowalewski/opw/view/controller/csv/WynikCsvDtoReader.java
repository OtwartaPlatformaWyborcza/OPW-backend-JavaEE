package com.adamkowalewski.opw.view.controller.csv;

import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.reader.CSVEntryParser;

public class WynikCsvDtoReader extends AbstractCSVReader<WynikCsvDto> {

    public static WynikCsvDtoReader wynikCsvDtoReader() {
        return new WynikCsvDtoReader(DEFAULT_STRATEGY);
    }

    public WynikCsvDtoReader(CSVStrategy csvStrategy) {
        super(csvStrategy);
    }

    @Override
    protected CSVEntryParser<WynikCsvDto> getCsvEntryParser() {
        return new WynikCsvDtoParser();
    }
}
