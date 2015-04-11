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
package com.adamkowalewski.opw.webservice;

import com.google.common.annotations.VisibleForTesting;
import javax.ws.rs.core.Response;

/**
 * Common logic for REST services.
 *
 * @author Adam Kowalewski
 */
public abstract class AbstractService {

    @VisibleForTesting
    static final String OPW_HEADER_LOGIN = "X-OPW-login";
    @VisibleForTesting
    static final String OPW_HEADER_PASSWORD = "X-OPW-password";
    @VisibleForTesting
    static final String OPW_HEADER_TOKEN = "X-OPW-token";
    @VisibleForTesting
    static final String OPW_HEADER_API_TOKEN = "X-OPW-API-token";
    @VisibleForTesting
    static final String OPW_HEADER_DEBUG_ERROR500 = "X-OPW-debug-500";

    // TODO delete when auth implemented
    static final String mockTokenId = "9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08";
    static final String mockAPITokenId = "d171794c5c1f7a50aeb8f7056ab84a4fbcd6fbd594b1999bddaefdd03efc0591";

    /**
     * MOCK
     *
     * @param login
     * @param token
     * @return
     */
    boolean verifyAccess(String login, String token) {
        return login.equals("admin") || token.equals(mockTokenId);
    }

    /**
     * MOCK 
     * @param apiToken
     * @return 
     */
    boolean verifyAccess(String apiToken) {
        return apiToken.equals(mockAPITokenId);
    }

    Response mockServerError() {
        return Response.serverError().build();
    }

}
