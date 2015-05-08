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

/**
 * PKW_CSV 
 * 
 * @author Adam Kowalewski
 */
public class ObwodowaDtoPkw {

    private final static String CSV_SEP = ";";
    private final static String SQL_SEP = " , ";
    private final static String PL = "Polska";

    //TERYT-Gminy|Nazwa gminy (m=Miasto)|Powiat|Wojewodztwo|Nr Obwodu w gminie|Typ obwodu|Obszar, ulice|Korespondencyjny + dla niepelnosprawnych|Kraj|Miasto (PLZ Miasto)|Kod pocztowy|Miasto|Ulica|Nr tylko dla polski||Nazwa lokalu|Uprawnionych 
//c1    TERYT-Gminy|
//c2    Nazwa gminy (m=Miasto)|
//c3    Powiat|
//c4    Wojewodztwo|
//c5    Nr Obwodu w gminie|
//c6    Typ obwodu|
//c7    Obszar, ulice|
//c8    Korespondencyjny + dla niepelnosprawnych|
//c9    Kraj|
//c10   Miasto (PLZ Miasto)|
//c11   Kod pocztowy|
//c12   Miasto|
//c13   Ulica|
//c14   Nr tylko dla polski|
//c15   |
//c16   Nazwa lokalu|
//c17   Uprawnionych 
    private String c1teryt, c2nazwa, c3powiat;
    private int c4wojewodztwo;
    private String c5obwod, c6typObwodu, c7ulice;
    private String c8korespondencyjny, c9kraj, c10miasto, c11kodPocztowy, c12miasto;
    private String c13ulica, c14nrDomu, c15empty, c16nazwa;
    private int c17uprawnionych;

    public ObwodowaDtoPkw() {
    }

    public ObwodowaDtoPkw(String line, String separator) {
        // 020102|gm. Bolesławiec|bolesławiecki|dolnośląskie|4|COMM|Brzeźnik|f|Polska|Brzeźnik|59-700|Bolesławiec||37||Dom Ludowy|661

        String[] record = line.split(separator);
        c1teryt = record[0];
        c2nazwa = trimString(record[1], 48);
        c3powiat = record[2];
        c4wojewodztwo = getAsNumber(record[3]);
        c5obwod = record[4];
        c6typObwodu = record[5];
        c7ulice = trimString(record[6], 48);
        c8korespondencyjny = record[7];
        c9kraj = record[8];
        c10miasto = record[9];
        c11kodPocztowy = record[10];
        c12miasto = trimString(record[11], 48);
        c13ulica = trimString(record[12], 48);
        c14nrDomu = record[13];
        c16nazwa = trimString(record[15], 48);
        try {
            c17uprawnionych = getAsNumber(record[16]);
        } catch (ArrayIndexOutOfBoundsException e) {
            c17uprawnionych = 0;
        }

    }

    private String getAddress() {
        if (c9kraj.equals(PL)) {
            return c13ulica + " " + c14nrDomu + ", " + c11kodPocztowy + " " + c10miasto;

        }
        return c13ulica + ", " + c11kodPocztowy + " " + c10miasto + ", " + c9kraj;

    }

    public String toStringSql() {
        // INSERT INTO opw.opw_obwodowa_komisja (pkwId, obwodNr, name, address, type, allowedToVote, status, opw_wojewodztwo_id) VALUES ('01-1', '1', 'name1', 'adr1213', 'ABC', '200', NULL, '2');

        return "INSERT INTO opw.opw_obwodowa_komisja (pkwId, obwodNr, name, address, type, allowedToVote, status, opw_wojewodztwo_id) VALUES ("
                + "'" + c1teryt + "-" + c5obwod + "', "
                + "'" + c5obwod + "', "
                + "'" + c16nazwa + "', "
                + "'" + getAddress() + "', "
                + "'" + c6typObwodu + "', "
                + "'" + c17uprawnionych + "', "
                + "NULL, "
                + "'" + c4wojewodztwo + "');";
    }

    public String toStringCsv() {
        // 1;020101-5;5;COMM;Miejski Zespół Szkół Nr 1;ul. Dolne Młyny 60 59-700 Bolesławiec Polska;1502

        String result = c4wojewodztwo + CSV_SEP
                + c1teryt + "-" + c5obwod + CSV_SEP
                + c5obwod + CSV_SEP
                + c6typObwodu + CSV_SEP
                + c16nazwa + CSV_SEP
                + getAddress() + CSV_SEP
                + c17uprawnionych;
        return result;
    }

    private String trimString(String text, int maxLength) {
        if (text.length() > maxLength) {
            return text.substring(0, maxLength);
        }
        return text;
    }

    private int getAsNumber(String part) {
        int result = 0;
        try {
            result = Integer.valueOf(part);
        } catch (NumberFormatException e) {
        }
        return result;
    }
}
