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
package com.adamkowalewski.opw.view.controller.csv;

import com.adamkowalewski.opw.view.dto.UserCsvDto;
import static com.google.common.collect.Lists.newArrayList;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Adam Kowalewski
 */
public class UserCsvDtoParserNGTest {

    private static String[] case1csv;

    private static UserCsvDto case1dto;

    public UserCsvDtoParserNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        case1csv = new String[]{"Jakub", "Arak", "jk@local.pl", "O", "146513-577,146513-578,146513-579"};
        case1dto = new UserCsvDto("Jakub", "Arak", "jk@local.pl", "O", newArrayList("146513-577", "146513-578", "146513-579"));

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of parseEntry method, of class UserCsvDtoParser.
     */
    @Test
    public void testParseEntry() {
        System.out.println("parseEntry");

        UserCsvDtoParser instance = new UserCsvDtoParser();
        UserCsvDto expResult = case1dto;
        UserCsvDto result = instance.parseEntry(case1csv);
        System.out.println("res" + result);
        assertNotNull(result);
        assertEquals(result, expResult);

    }

}
