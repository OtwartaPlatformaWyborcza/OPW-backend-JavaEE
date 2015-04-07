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

import com.adamkowalewski.opw.view.controller.UserController;
import com.adamkowalewski.opw.view.controller.MailController;
import com.adamkowalewski.opw.entity.OpwUser;
import com.adamkowalewski.opw.bean.UserBean;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
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
@Test(enabled = false)
public class UserControllerNGTest {
    
    public UserControllerNGTest() {
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
     * Test of create method, of class UserController.
     */
    @Test(enabled = false)
    public void testCreate() {
        System.out.println("create");
        OpwUser user = null;
        UserController instance = new UserController();
        instance.create(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetPassword method, of class UserController.
     */
    @Test(enabled = false)
    public void testResetPassword() {
        System.out.println("resetPassword");
        OpwUser user = null;
        UserController instance = new UserController();
        instance.resetPassword(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generatePasswordSalted method, of class UserController.
     */
    @Test(enabled = false)
    public void testGeneratePasswordSalted() {
        System.out.println("generatePasswordSalted");
        String appSalt = "";
        String userSalt = "";
        String password = "";
        UserController instance = new UserController();
        String expResult = "";
        String result = instance.generatePasswordSalted(appSalt, userSalt, password);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generatePassword method, of class UserController.
     */
    @Test(enabled = false)
    public void testGeneratePassword_0args() {
        System.out.println("generatePassword");
        UserController instance = new UserController();
        String expResult = "";
        String result = instance.generatePassword();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generatePassword method, of class UserController.
     */
    @Test(enabled = false)
    public void testGeneratePassword_int() {
        System.out.println("generatePassword");
        int length = 0;
        UserController instance = new UserController();
        String expResult = "";
        String result = instance.generatePassword(length);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of encryptSHA method, of class UserController.
     */
    @Test(enabled = false)
    public void testEncryptSHA() {
        System.out.println("encryptSHA");
        String value = "";
        UserController instance = new UserController();
        String expResult = "";
        String result = instance.encryptSHA(value);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class UserController.
     */
    @Test(enabled = false)
    public void testDelete() {
        System.out.println("delete");
        OpwUser user = null;
        UserController instance = new UserController();
        instance.delete(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class UserController.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        OpwUser u = new OpwUser();
        u.setId(1);
        int id = 1;
        UserBean bean = mock(UserBean.class);
        when(bean.findUser(id)).thenReturn(u);
        
        UserController instance = new UserController(bean, new MailController());
        
        
        OpwUser expResult = null;
        OpwUser result = instance.find(id);
        assertEquals(result.getId(), u.getId());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class UserController.
     */
    @Test(enabled = false)
    public void testEdit() {
        System.out.println("edit");
        OpwUser user = null;
        UserController instance = new UserController();
        instance.edit(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class UserController.
     */
    @Test(enabled = false)
    public void testFindAll() {
        System.out.println("findAll");
        UserController instance = new UserController();
        List expResult = null;
        List result = instance.findAll();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
