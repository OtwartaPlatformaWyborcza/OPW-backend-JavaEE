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
 * @param <T> entity
 * @author Adam Kowalewski
 * @version 2015.05.02
 */
public final class GResultDto<T> {

    private final int status;
    private final boolean valid;
    private final T entity;

    public static <T> GResultDto<T> validResult(int status) {
        return new GResultDto<>(status, true, null);
    }

    public static <T> GResultDto<T> validResult(int status, T entity) {
        return new GResultDto<>(status, true, entity);
    }

    public static <T> GResultDto<T> invalidResult(int status) {
        return new GResultDto<>(status, false, null);
    }

    private GResultDto(int status, boolean valid, T entity) {
        this.status = status;
        this.valid = valid;
        this.entity = entity;
    }

    public int getStatus() {
        return status;
    }

    public boolean isValid() {
        return valid;
    }

    public T getEntity() {
        return entity;
    }
}
