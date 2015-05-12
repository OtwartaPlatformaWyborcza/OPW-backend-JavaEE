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
package com.adamkowalewski.opw.xxutil;

import com.adamkowalewski.opw.view.controller.pkw.Wynik;
import com.adamkowalewski.opw.bean.ObwodowaBean;
import com.adamkowalewski.opw.entity.OpwObwodowaKomisja;
import com.adamkowalewski.opw.webservice.dto.WynikDto;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.runner.Runner;

/**
 *
 * @author Adam Kowalewski
 */
public class PkwJsonImporter {

    public static void main(String[] args) {

        List<String> fileList = buildList();
        List<String> idList = getIdList();
        System.out.println(fileList.size());
        System.out.println(idList.size());
        
        int i = 0;
        for (String sfile : fileList) {

            Gson file = new Gson();
            WynikDto wynik = new WynikDto();

            List<String> x = readCsvFile(sfile);
            Wynik w = file.fromJson(x.get(0), Wynik.class);

            wynik.setGlosowNieWaznych(Short.valueOf(String.valueOf(w.getFilledData().getLGlosowNiewaznych())));
            wynik.setGlosowWaznych(Short.valueOf(String.valueOf(w.getFilledData().getLGlosowWaznych())));
            wynik.setGlosujacych(Short.valueOf(String.valueOf(w.getFilledData().getSum())));
            wynik.setKartWaznych(Short.valueOf(String.valueOf(w.getFilledData().getLKartWaznych())));
            wynik.setUprawnionych(Short.valueOf(String.valueOf(w.getFilledData().getLUprawnionych())));

            wynik.setK1(Short.valueOf(String.valueOf(w.getCandidates().get(0).getValidVotes())));
            wynik.setK2(Short.valueOf(String.valueOf(w.getCandidates().get(1).getValidVotes())));
            wynik.setK3(Short.valueOf(String.valueOf(w.getCandidates().get(2).getValidVotes())));
            wynik.setK4(Short.valueOf(String.valueOf(w.getCandidates().get(3).getValidVotes())));
            wynik.setK5(Short.valueOf(String.valueOf(w.getCandidates().get(4).getValidVotes())));
            wynik.setK6(Short.valueOf(String.valueOf(w.getCandidates().get(5).getValidVotes())));
            wynik.setK7(Short.valueOf(String.valueOf(w.getCandidates().get(6).getValidVotes())));
            wynik.setK8(Short.valueOf(String.valueOf(w.getCandidates().get(7).getValidVotes())));
            wynik.setK9(Short.valueOf(String.valueOf(w.getCandidates().get(8).getValidVotes())));
            wynik.setK10(Short.valueOf(String.valueOf(w.getCandidates().get(9).getValidVotes())));
            wynik.setK11(Short.valueOf(String.valueOf(w.getCandidates().get(10).getValidVotes())));            
            
            System.out.println(getAsSql(wynik, idList.get(i)));            
            i++;

        }

    }

    public static String getAsSql(WynikDto record, String id) {
        String result = "INSERT INTO "
                + "opw.opw_wynik "
                + "(active, cardsvalid, datecreated, fileoriginal, "
                + "k1, k10, k11, k2, k3, k4, k5, k6, k7, k8, k9, "
                + "ratednegativ, ratedpositiv, status, "
                + "votersamount, votersvalid, votesinvalid, votesvalid, "
                + "opw_obwodowa_komisja_id, "
                + "opw_user_id, parentid) "
                + "VALUES "
                + "(true, "
                + record.getKartWaznych() + ", '2015-05-12', NULL, "
                + record.getK1() + ", "
                + record.getK10() + ", "
                + record.getK11() + ", "
                + record.getK2() + ", "
                + record.getK3() + ", "
                + record.getK4() + ", "
                + record.getK5() + ", "
                + record.getK6() + ", "
                + record.getK7() + ", "
                + record.getK8() + ", "
                + record.getK9() + ", "
                + "0, 0, NULL, "
                + record.getGlosujacych() + ", "
                + record.getUprawnionych() + ", "
                + record.getGlosowNieWaznych() + ", "
                + record.getGlosowWaznych() + ", "
                + id +", 1, NULL);";
        return result;
    }

    private static List<String> readCsvFile(String filename) {
        List<String> result = new ArrayList<>();
        FileInputStream fis;
        try {
            fis = new FileInputStream(filename);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bf = new BufferedReader(isr);
            String line;
            while (bf.ready()) {
                line = bf.readLine();
                result.add(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static List<String> buildList() {
        List<String> fileList = new ArrayList<>();
        
        return fileList;
    }

    public static List<String> getIdList() {
        List<String> idList = new ArrayList<>();
        
        return idList;
    }
}
