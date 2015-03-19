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
package com.adamkowalewski.opw.session.handler;

/**
 *
 * @author Adam Kowalewski
 * @param <T>
 */
public abstract class AbstractCrudHandler<T> implements CrudHandler {

    private boolean viewMode = true;
    private Class<T> instance;
    
    private String view_id;
    private String view_id_edit;
    
    
    /**
     * TODO
     * 
     * @param r instance of an entity to view. 
     * @return TODO
     * @author Adam Kowalewski
     * @version 2015.03.19
     */
    public String prepareView(Class<T> r){
        instance = r;
        viewMode = true;
        return view_id_edit;
    }
    
    @Override
    public String cancel(){
        viewMode = true;
        return view_id;
    }

    public boolean isViewMode() {
        return viewMode;
    }

    public void setViewMode(boolean viewMode) {
        this.viewMode = viewMode;
    }

    public Class<T> getInstance() {
        return instance;
    }

    public void setInstance(Class<T> instance) {
        this.instance = instance;
    }

}
