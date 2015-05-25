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

import com.adamkowalewski.opw.entity.OpwWynik;
import com.adamkowalewski.opw.view.Identity;
import com.adamkowalewski.opw.view.controller.WynikController;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Adam Kowalewski
 */
@Named
@SessionScoped
public class WynikHandler extends AbstractCrudHandler<OpwWynik> implements Serializable {

    private String obwodowaPkwId;

    @Inject
    WynikController wynikController;
    @Inject
    Identity identity;

    public WynikHandler() {
        VIEW_ID = "wynik";
        VIEW_ID_EDIT = "wynikEdit";
        VIEW_ID_CREATE = "wynikCreate";
    }

    @Override
    public void prepareList() {
        instanceList = wynikController.findAll();
    }

    @Override
    public void prepareCreate() {
        instance = new OpwWynik();
    }

    @Override
    public String create() {               
        wynikController.create(instance, obwodowaPkwId, identity.getUserId());
        return VIEW_ID;
    }

    @Override
    public String edit() {
        wynikController.edit(instance);
        return VIEW_ID;
    }

    @Override
    public List<OpwWynik> getInstanceListFiltered() {
        return super.getInstanceListFiltered();
    }

    @Override
    public List<OpwWynik> getInstanceList() {
        return super.getInstanceList();
    }

    @Override
    public OpwWynik getInstance() {
        return super.getInstance();
    }

    public String getObwodowaPkwId() {
        return obwodowaPkwId;
    }

    public void setObwodowaPkwId(String obwodowaPkwId) {
        this.obwodowaPkwId = obwodowaPkwId;
    }

    @Override
    public void prepareView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
