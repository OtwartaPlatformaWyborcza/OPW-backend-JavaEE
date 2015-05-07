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
package com.adamkowalewski.opw.view.controller;

import com.adamkowalewski.opw.OpwException;
import com.adamkowalewski.opw.entity.OpwObwodowaKomisja;
import com.adamkowalewski.opw.entity.OpwOkregowaKomisja;
import com.adamkowalewski.opw.entity.OpwUser;
import com.adamkowalewski.opw.view.dto.ObwodowaCsvDto;
import com.adamkowalewski.opw.view.dto.OkregowaCsvDto;
import com.adamkowalewski.opw.view.dto.UserCsvDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import static com.adamkowalewski.opw.view.controller.csv.ObwodowaCsvDtoReader.obwodowaCsvDtoReader;
import static com.adamkowalewski.opw.view.controller.csv.OkregowaCsvDtoReader.okregowaCsvDtoReader;
import static com.adamkowalewski.opw.view.controller.csv.UserCsvDtoReader.userCsvDtoReader;

/**
 * Provides reusable logic for file import.
 *
 * @author Adam Kowalewski
 */
@Named
@RequestScoped
public class ImportController implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(ImportController.class);

    @Inject
    OkregowaController okregowaController;
    @Inject
    ObwodowaController obwodowaController;
    @Inject
    UserController userController;
    @Inject
    WojewodztwoController wojewodztwoController;

    public void performImportOkregowa(List<OkregowaCsvDto> okregowaList) {
        List<OpwOkregowaKomisja> resultList = new ArrayList<>();

        for (OkregowaCsvDto csvDto : okregowaList) {
            // skip duplicates 
            if (csvDto.isDuplicate()) {
                continue;
            }
            OpwOkregowaKomisja single = new OpwOkregowaKomisja();
            single.setPkwId(csvDto.getPkwId());
            single.setName(csvDto.getName());
            single.setOpwWojewodztwoId(wojewodztwoController.find(csvDto.getWojewodztwoId()));
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
    public List<OkregowaCsvDto> parseOkregowa(InputStream content)
            throws IOException, IndexOutOfBoundsException, NumberFormatException, PatternSyntaxException {

        List<OkregowaCsvDto> okregowaList = okregowaCsvDtoReader().readAllFrom(content);

        for (OkregowaCsvDto okregowa : okregowaList) {
            okregowa.setDuplicate(okregowaController.isDuplicate(okregowa.getPkwId()));
        }
        logger.trace("Okregowa Import size {}.", okregowaList.size());

        return okregowaList;
    }

    public void performImportUser(List<UserCsvDto> userList) {

        List<OpwUser> userImportList = new ArrayList<>();

        for (UserCsvDto userDto : userList) {
            if (userDto.isDuplicate()) {
                MsgController.addWarningMessage("Skipped " + userDto.getEmail());
                continue;
            }
            OpwUser u = new OpwUser();
            u.setEmail(userDto.getEmail());
            u.setLastname(userDto.getLastname());
            u.setFirstname(userDto.getFirstname());
            u.setType(userDto.getType());

            userImportList.add(u);
        }
        logger.trace("User import start for {} records", userImportList.size());
        userController.create(userImportList);
    }

    public List<UserCsvDto> parseUser(InputStream content) throws IOException, OpwException {

        List<UserCsvDto> userDtoList = userCsvDtoReader().readAllFrom(content);

        for (UserCsvDto user : userDtoList) {
            user.setDuplicate(userController.isDuplicate(user.getEmail()));
        }
        logger.trace("User import size {}", userDtoList.size());
        return userDtoList;
    }

    public void performImportObwodowa(List<ObwodowaCsvDto> obwodowaList) {
        List<OpwObwodowaKomisja> resultList = new ArrayList<>();

        for (ObwodowaCsvDto csvDto : obwodowaList) {
            if (csvDto.isDuplicate()) {
                continue;
            }
            //14;106101-2;2;P;Studio Consulting Sp. z o.o.; ul. Romanowska 55E, 91-174 Łódź;1234
            OpwObwodowaKomisja single = new OpwObwodowaKomisja();
//            single.setOpwOkregowaKomisjaId(okregowaController.find(csvDto.getWojewodztwoId()));

            single.setOpwWojewodztwoId(wojewodztwoController.find(csvDto.getWojewodztwoId()));
            single.setPkwId(csvDto.getPkwId());
            single.setObwodNr(csvDto.getObwodNr());
            single.setType(csvDto.getType());
            single.setName(csvDto.getName());
            single.setAddress(csvDto.getAddress());
            single.setAllowedToVote(csvDto.getAllowedToVote());
            resultList.add(single);
        }
        obwodowaController.create(resultList);
    }

    public List<ObwodowaCsvDto> parseObwodowa(InputStream content) throws IOException {

        List<ObwodowaCsvDto> obwodowaList = obwodowaCsvDtoReader().readAllFrom(content);

        for (ObwodowaCsvDto obwodowa : obwodowaList) {
            obwodowa.setDuplicate(obwodowaController.isDuplicate(obwodowa.getPkwId()));
        }
        return obwodowaList;
    }
}
