package com.adamkowalewski.opw.view.controller.csv;

import com.adamkowalewski.opw.view.dto.ObwodowaCsvDto;
import com.googlecode.jcsv.reader.CSVEntryParser;

/**
 * The ObwodowaCsvDtoParser receives a line of the csv file and converts it
 * to a ObwodowaCsvDto object.
 * <p/>
 * Given csv file format is:
 * okregowaId[1-51];obwodId;obwodNr;obwodTyp;obwodName;obwodAddress;allowedToVote
 */
class ObwodowaCsvDtoParser implements CSVEntryParser<ObwodowaCsvDto> {
    @Override
    public ObwodowaCsvDto parseEntry(String... data) {
        int okregowaPkwId = Integer.parseInt(data[0].trim());
        String pkwId = data[1].trim();
        int obwodNr = Integer.parseInt(data[2].trim());
        String type = data[3].trim();
        String name = data[4].trim();
        String address = data[5].trim();
        int allowedToVote = Integer.parseInt(data[6].trim());
        return new ObwodowaCsvDto(okregowaPkwId, pkwId, obwodNr, name, address, type, allowedToVote);
    }
}
