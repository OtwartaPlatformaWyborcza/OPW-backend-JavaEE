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

import java.util.Random;



/**
 *
 * @author Adam Kowalewski
 */
public class ObwodowaGenerator {

//Kody TERYT dla Łodzi    
//Łódź              (1061)
//Łódź              (1061011)
//Łódź-Bałuty       (1061029)
//Łódź-Górna        (1061039)
//Łódź-Polesie      (1061049)
//Łódź-Śródmieście  (1061059)
//Łódź-Widzew       (1061069)


    
//okregowaId[1-51];obwodId;obwodNr;obwodTyp;obwodName;obwodAddress;allowedToVote
//14;106101-1;1;P;Studio Consulting Sp. z o.o.; ul. Romanowska 55E, 91-174 Łódź;1234
//14;106101-2;2;P;Studio Consulting Sp. z o.o.; ul. Romanowska 55E, 91-174 Łódź;1234
    public static void main(String[] args) {
        for (int i = 1; i < 555; i++) {
            System.out.println("14;106102-" + i + ";" + i + ";P;Lokal wyborczy Bałuty Nr. " + i + ";ul. Romanowska 1-" + i + " 91-174 Łódź-Bałuty;" + new Random().nextInt(3000));
        }
    }
}
