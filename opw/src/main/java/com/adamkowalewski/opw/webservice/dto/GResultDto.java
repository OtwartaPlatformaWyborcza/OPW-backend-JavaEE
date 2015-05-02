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

import com.google.common.base.Optional;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * GDTO Generic Data Transfer Object for REST services.
 *
 * @param <T> entity
 * @author Adam Kowalewski
 * @version 2015.05.02
 */
public final class GResultDto<T> {

    private final Status status;
    private final Optional<T> entity;

    public static <T> GResultDto<T> result(Status status, T entity) {
        checkNotNull(status);
        checkNotNull(entity);
        return new GResultDto<>(status, Optional.of(entity));
    }

    public static <T> GResultDto<T> result(Status status) {
        checkNotNull(status);
        return new GResultDto<>(status, Optional.<T>absent());
    }

    private GResultDto(Status status, Optional<T> entity) {
        this.status = status;
        this.entity = entity;
    }

    public Status getStatus() {
        return status;
    }

    public Optional<T> getEntity() {
        return entity;
    }
}
