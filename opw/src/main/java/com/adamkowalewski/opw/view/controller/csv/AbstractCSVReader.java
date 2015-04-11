package com.adamkowalewski.opw.view.controller.csv;

import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.reader.CSVEntryParser;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public abstract class AbstractCSVReader<T> {

    protected static final CSVStrategy DEFAULT_STRATEGY = new CSVStrategy(';', '"', '#', true, true);

    private CSVStrategy csvStrategy;

    protected List<T> readAllUsing(CSVEntryParser<T> csvEntryParser, InputStream content) throws IOException {
        checkArgument(csvEntryParser != null, "Expected non-null csvEntryParser argument");
        checkArgument(content != null, "Expected non-null content argument");
        Reader reader = new InputStreamReader(content);
        CSVReader<T> okregowaCsvReader = new CSVReaderBuilder<T>(reader)
                .strategy(csvStrategy)
                .entryParser(csvEntryParser)
                .build();
        return okregowaCsvReader.readAll();
    }

    /**
     * @param csvStrategy {@link https://code.google.com/p/jcsv/wiki/CSVStrategy}
     */
    protected AbstractCSVReader(CSVStrategy csvStrategy) {
        this.csvStrategy = csvStrategy;
    }
}
