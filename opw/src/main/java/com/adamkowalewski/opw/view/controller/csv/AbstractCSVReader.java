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

    protected abstract CSVEntryParser<T> getCsvEntryParser();

    public List<T> readAllFrom(InputStream content) throws IOException {
        return readAllUsing(getCsvEntryParser(), content);
    }

    protected List<T> readAllUsing(CSVEntryParser<T> csvEntryParser, InputStream content) throws IOException {
        checkArgument(csvEntryParser != null, "Expected non-null csvEntryParser argument");
        checkArgument(content != null, "Expected non-null content argument");
        Reader reader = new InputStreamReader(content);
        CSVReader<T> csvReader = new CSVReaderBuilder<T>(reader)
                .strategy(csvStrategy)
                .entryParser(csvEntryParser)
                .build();
        return csvReader.readAll();
    }

    /**
     * @param csvStrategy {@link https://code.google.com/p/jcsv/wiki/CSVStrategy}
     */
    public AbstractCSVReader(CSVStrategy csvStrategy) {
        this.csvStrategy = csvStrategy;
    }
}
