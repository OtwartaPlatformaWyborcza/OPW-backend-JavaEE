package com.adamkowalewski.opw.view.controller;

import com.adamkowalewski.opw.view.dto.OkregowaCsvDto;
import com.googlecode.jcsv.reader.CSVEntryParser;

/**
 * The OkregowaCsvDtoParser receives a line of the csv file and converts it
 * to a OkregowaCsvDto object.
 *
 * Given csv file format is:
 * pkwId;numer i siedziba;województwo;powiaty;Miasta na prawach powiatu
 */
public class OkregowaCsvDtoParser implements CSVEntryParser<OkregowaCsvDto> {

    /**
     * Converts a row of the csv file to a java object
     * @param values array of fields from a row of the csv file
     * @return object representing single entry
     */
    @Override
    public OkregowaCsvDto parseEntry(String... values) {
        int pkwId = Integer.parseInt(values[0]);
        String name = values[1];
        // We are currently not using values[2] (województwo)
        String powiaty = values[3];
        String miasta = values[4];
        return new OkregowaCsvDto(pkwId, name, powiaty, miasta);
    }
}
