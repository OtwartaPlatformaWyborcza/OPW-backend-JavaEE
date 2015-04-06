/*
 * The MIT License
 *
 * Copyright 2015 Adam Kowalewski.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.adamkowalewski.opw.session.controller;

import com.adamkowalewski.opw.entity.OpwOkregowaKomisja;
import com.adamkowalewski.opw.session.dto.ImportOkregowaCsvDto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Provides reusable logic for file import.
 *
 * @author Adam Kowalewski
 */
@Named
@RequestScoped
public class ImportController implements Serializable {

    private static final String DEFAULT_SEPARATOR = ";";
    private final String separator;

    @Inject
    OkregowaController okregowaController;

    public ImportController() {
        separator = DEFAULT_SEPARATOR;
    }

    public ImportController(String customSeparator) {
        separator = customSeparator;
    }

    public void performImport(List<ImportOkregowaCsvDto> okregowaList) {
        List<OpwOkregowaKomisja> resultList = new ArrayList<>();

        for (ImportOkregowaCsvDto csvDto : okregowaList) {
            OpwOkregowaKomisja single = new OpwOkregowaKomisja();
            single.setPkwId(csvDto.getPkwId());
            single.setName(csvDto.getName());
            resultList.add(single);
        }

        okregowaController.create(resultList);
    }

    /**
     * Converts CSV content into list of DTO instances.
     *
     * @param content stream as uploaded.
     * @return clean instances.
     * @throws IOException
     * @throws IndexOutOfBoundsException
     * @throws PatternSyntaxException
     * @throws NumberFormatException
     * @author Adam Kowalewski
     * @version 2015.04.06
     */
    public List<ImportOkregowaCsvDto> parseOkregowa(InputStream content)
            throws IOException, IndexOutOfBoundsException, NumberFormatException, PatternSyntaxException {
        List<ImportOkregowaCsvDto> result = new ArrayList<>();
        List<String> lines = contentToLines(content);

        lines.remove(0); // remove first line 

        for (String line : lines) {
            ImportOkregowaCsvDto dto = new ImportOkregowaCsvDto();
            dto.parseLine(line, separator);

            // check duplicates
            try {
                OpwOkregowaKomisja findByPkwId = okregowaController.findByPkwId(dto.getPkwId());
                dto.setDuplicate(true);
            } catch (Exception ex) {
                dto.setDuplicate(false);
            }
            result.add(dto);
        }
        return result;
    }

    /**
     * Converts content into list of String.
     *
     * @param content from a CSV file.
     * @return content as list of String.
     * @throws IOException
     * @author Adam Kowalewski
     * @version 2015.04.06
     */
    private List<String> contentToLines(InputStream content) throws IOException {
        List<String> result = new ArrayList<>();
        InputStreamReader isr = new InputStreamReader(content);
        BufferedReader bf = new BufferedReader(isr);
        String line;
        while (bf.ready()) {
            line = bf.readLine();
            result.add(line);
        }
        return result;
    }

}
