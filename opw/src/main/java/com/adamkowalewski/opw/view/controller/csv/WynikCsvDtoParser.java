package com.adamkowalewski.opw.view.controller.csv;

import com.googlecode.jcsv.reader.CSVEntryParser;

import java.util.List;


class WynikCsvDtoParser implements CSVEntryParser<WynikCsvDto> {
    @Override
    public WynikCsvDto parseEntry(String... data) {
        String pkwId = data[0] + "-" + data[1];
                        
        WynikCsvDto w = new WynikCsvDto();
        w.setPkwId(pkwId);
        w.setUprawnionych(Short.valueOf(data[2]));
        w.setGlosujacych(Short.valueOf(data[3]));
        w.setKartWaznych(Short.valueOf(data[4]));
        w.setGlosowNieWaznych(Short.valueOf(data[5]));
        w.setGlosowWaznych(Short.valueOf(data[6]));
        w.setK1(Short.valueOf(data[7]));
        w.setK2(Short.valueOf(data[8]));
        
        return w;
    }

    private List<String> trimElements(List<String> elements) {
        for (int i = 1; i < elements.size(); ++i) {
            String element = elements.get(i).trim();
            if (element.isEmpty()) {
                elements.remove(i);
            } else {
                elements.set(i, element);
            }
        }
        return elements;
    }
}
