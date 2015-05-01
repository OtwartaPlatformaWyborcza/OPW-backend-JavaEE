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
package com.adamkowalewski.opw.webservice.security;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
public class SecurityHandlerNGTest {

    public SecurityHandlerNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
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
     * List userList is expected to be empty after refresh.
     */
    @Test
    public void testRefreshUserList() {
        System.out.println("refreshUserList");
        SecurityHandler instance = new SecurityHandler();
        instance.refreshUserList();
        assertEquals(instance.getUserList().size(), 0);
    }

    /**
     * Test of checkUser method, of class SecurityHandler.
     */
    @Test(enabled = false)
    public void testCheckUser_3args() {
        System.out.println("checkUser");
        int userId = 0;
        String login = "";
        String token = "";
        SecurityHandler instance = new SecurityHandler();
        boolean expResult = false;
        boolean result = instance.checkUser(userId, login, token);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUser method, of class SecurityHandler.
     */
    @Test(enabled = false)
    public void testCheckUser_String_String() {
        System.out.println("checkUser");
        String login = "";
        String token = "";
        SecurityHandler instance = new SecurityHandler();
        boolean expResult = false;
        boolean result = instance.checkUser(login, token);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkTimeout method, of class SecurityHandler.
     */
    @Test(enabled = false)
    public void testCheckTimeout() {
        System.out.println("checkTimeout");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        
        SecurityObject user = null;
        SecurityHandler instance = new SecurityHandler();
        boolean expResult = false;
        boolean result = instance.checkTimeout(user);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Map userMap is expected to be empty after clear.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        SecurityHandler instance = new SecurityHandler();
        instance.clear();
        assertEquals(instance.userMap.size(), 0);
    }

}
