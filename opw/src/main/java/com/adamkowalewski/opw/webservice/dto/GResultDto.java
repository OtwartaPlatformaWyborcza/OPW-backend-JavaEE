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
package com.adamkowalewski.opw.webservice.dto;

/**
 * GDTO Generic Data Transfer Object for REST services.
 *
 * @author Adam Kowalewski
 * @version 2015.05.02
 * @param <T> entity
 */
public class GResultDto<T> {

    private int statusCode;
    private boolean valid;
    private boolean entityAttached;
    private T entity;

    public GResultDto() {
    }

    public GResultDto(int statusCode, boolean valid, T entity) {
        this.statusCode = statusCode;
        this.valid = valid;
        this.entity = entity;
    }

    public GResultDto(int statusCode, boolean valid, boolean entityAttached, T entity) {
        this.statusCode = statusCode;
        this.valid = valid;
        this.entityAttached = entityAttached;
        this.entity = entity;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Verifies if result is valid.
     *
     * @return for valid response <code>true</code>, otherwise
     * <code>false</code>.
     */
    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    /**
     * Shall this entity be attached as entity to <code>Response</code>.
     *
     * @return when to be attached <code>true</code>, otherwise
     * <code>false</code>.
     */
    public boolean isEntityAttached() {
        return entityAttached;
    }

    public void setEntityAttached(boolean entityAttached) {
        this.entityAttached = entityAttached;
    }

}
