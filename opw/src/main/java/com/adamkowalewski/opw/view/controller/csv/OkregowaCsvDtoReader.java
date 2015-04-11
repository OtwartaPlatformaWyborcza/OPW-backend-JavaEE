package com.adamkowalewski.opw.view.controller.csv;

import com.adamkowalewski.opw.view.dto.OkregowaCsvDto;
import com.googlecode.jcsv.CSVStrategy;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OkregowaCsvDtoReader extends AbstractCSVReader<OkregowaCsvDto> {

    public static OkregowaCsvDtoReader okregowaCsvDtoReader() {
        return new OkregowaCsvDtoReader(DEFAULT_STRATEGY);
    }

    protected OkregowaCsvDtoReader(CSVStrategy csvStrategy) {
        super(csvStrategy);
    }

    public List<OkregowaCsvDto> readAllFrom(InputStream content) throws IOException {
        return readAllUsing(new OkregowaCsvDtoParser(), content);
    }
}
