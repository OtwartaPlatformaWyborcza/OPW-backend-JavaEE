package com.adamkowalewski.opw.view.controller;

import com.adamkowalewski.opw.view.dto.OkregowaCsvDto;
import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public class OkregowaCsvDtoReader {

    private static final CSVStrategy DEFAULT_STRATEGY = new CSVStrategy(';', '"', '#', true, true);

    private CSVStrategy csvStrategy;

    public static OkregowaCsvDtoReader okregowaCsvDtoReader() {
        return new OkregowaCsvDtoReader(DEFAULT_STRATEGY);
    }

    /**
     * Creates reader object
     * @param csvStrategy {@link https://code.google.com/p/jcsv/wiki/CSVStrategy}
     * @return reader object
     */
    public static OkregowaCsvDtoReader okregowaCsvDtoReader(CSVStrategy csvStrategy) {
        return new OkregowaCsvDtoReader(csvStrategy);
    }

    public List<OkregowaCsvDto> readAllFrom(InputStream content) throws IOException {
        checkArgument(content != null, "Expected non-null content argument");
        Reader reader = new InputStreamReader(content);
        CSVReader<OkregowaCsvDto> okregowaCsvReader = new CSVReaderBuilder<OkregowaCsvDto>(reader)
                .strategy(DEFAULT_STRATEGY)
                .entryParser(new OkregowaCsvDtoParser())
                .build();
        return okregowaCsvReader.readAll();
    }

    private OkregowaCsvDtoReader(CSVStrategy csvStrategy) {
        this.csvStrategy = csvStrategy;
    }
}
