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
 *
 * @author Adam Kowalewski
 */
public class ObwodowaDtoPkw {

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
    private String c1teryt, c2nazwa, c3powiat, c4wojewodztwo, c5obwod, c6typObwodu, c7ulice;
    private String c8korespondencyjny, c9kraj, c10miasto, c11kodPocztowy, c12miasto;
    private String c13ulica, c14nrDomu, c15empty, c16nazwa, c17uprawnionych;
    
}
