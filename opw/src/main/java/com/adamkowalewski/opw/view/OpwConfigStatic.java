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
package com.adamkowalewski.opw.view;

/**
 * Configuration settings which may not be changed.
 *
 * @author Adam Kowalewski
 * @version 2015.03.15
 */
public final class OpwConfigStatic {

    /**
     * Persistance unit name.
     */
    public static final String PU_OPW = "opwPU";

    /**
     * User ID for root access.
     */
    public static final int ROOT_ID = 1;

    /**
     * Application salt may not be changed and is therefore hardcoded.
     */
    public static final String APP_SALT = "Søägüąź.29";

    // const for config in database     
    public static final String CFG_KEY_BASE_URL = "OPW_BASE_URL";
    public static final String CFG_KEY_EMAIL_OUTBOUND = "EMAIL_OUTBOUND";
    public static final String CFG_KEY_CLIENT_REGISTRATION = "CLIENT_REGISTRATION";
    public static final String REST_SESSION_TIMEOUT_IN_SECONDS = "REST_SESSION_TIMEOUT";

    private OpwConfigStatic() {
        throw new UnsupportedOperationException();
    }
}
