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
package com.adamkowalewski.opw.view.handler;

import com.adamkowalewski.opw.entity.OpwUser;
import com.adamkowalewski.opw.view.Identity;
import com.adamkowalewski.opw.view.controller.UserController;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * CRUD backing bean / handler for all CRUD related JSF sites.
 *
 * @author Adam Kowalewski
 */
@Named
@SessionScoped
public class UserHandler extends AbstractCrudHandler<OpwUser> implements Serializable {

    private List<OpwUser> userList;

    @Inject
    Identity identity;

    @Inject
    UserController userController;

    public UserHandler() {
        VIEW_ID = "user";
        VIEW_ID_EDIT = "userEdit";
        VIEW_ID_CREATE = "userCreate";
    }
    
    public String resetPassword() {
        userController.resetPassword(instance);        
        return VIEW_ID;
    }

    @Override
    public String create() {
        userController.create(instance);
        return VIEW_ID;
    }

    @Override
    public String edit() {
        userController.edit(instance);
        return VIEW_ID;
    }

    public String delete() {
        userController.delete(instance);
        return VIEW_ID;
    }

    @Override
    public void prepareList() {
        userList = userController.findAll();
    }

    @Override
    public void prepareCreate() {
        instance = new OpwUser();
    }

    public List<OpwUser> getUserList() {
        return userList;
    }

    public void setUserList(List<OpwUser> userList) {
        this.userList = userList;
    }

    @Override
    public void prepareView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
