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

package com.adamkowalewski.opw.view.controller;

import java.util.List;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Generic controller for handling JSF Messages.
 *
 * @author Adam Kowalewski
 */
public class MsgController {
    
  private static final String BUNDLE_DEFAULT = "messages";

    /**
     * Attach default operation completed message to messages.
     *
     * @author Adam Kowalewski
     * @version 2015.03.16
     */
    public static void operationCompleted() {
        MsgController.addSuccessMessage(MsgController.getLocalizedMessage("formResultOk"));
    }

    /**
     * Attach default operation failed message to messages.
     *
     * @author Adam Kowalewski
     * @version 2015.03.16
     */
    public static void operationFailed() {
        MsgController.addSuccessMessage(MsgController.getLocalizedMessage("formResultFailed"));
    }

    /**
     * Returns localized property from "messages" ressource by given ID.
     *
     * @param messageId id of the property.
     * @return value of the property.
     * @author Adam Kowalewski
     * @version 2015.03.16
     */
    public static String getLocalizedMessage(String messageId) {
        try {           
            return getBundleDefault().getString(messageId);
        } catch (NullPointerException ex) {        
            return getNotDefined(messageId);
        }        
    }

    public static String getLocalizedMessage(String messageId, String param1) {
//        try {
//            MessageFormat mf = new MessageFormat(getBundleDefault().getString(messageId));            
//            return mf.format(mf.parse(param1), new StringBuffer(), null).toString();
//        } catch (Exception ex) {
            return "Output DISABLED ";
//        }
    }

    private static String getNotDefined(String messageId) {
        return "Missing properties entry for ID: " + messageId;
    }

    private static ResourceBundle getBundleDefault() throws NullPointerException {
        return getBundle(BUNDLE_DEFAULT);
    }

    private static ResourceBundle getBundle(String bundleName) throws NullPointerException {
        FacesContext ctx = FacesContext.getCurrentInstance();
        return ctx.getApplication().getResourceBundle(ctx, bundleName);
    }

    public static void addErrorMessage(Exception ex, String defaultMsg) {
        String msg = ex.getLocalizedMessage();
        if (msg != null && msg.length() > 0) {
            addErrorMessage(msg);
        } else {
            addErrorMessage(defaultMsg);
        }
    }

    public static void addErrorMessages(List<String> messages) {
        for (String message : messages) {
            addErrorMessage(message);
        }
    }

    /**
     * Attach a warning message to messages.
     *
     * @param msg message to be attached as error.
     *
     * @author Adam Kowalewski
     * @version 2015.03.16
     */
    public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    /**
     * Attach a success message to messages.
     *
     * @param msg message to be attached as success.
     *
     * @author Adam Kowalewski
     * @version 2015.03.16
     */
    public static void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }

    /**
     * Attach a warning message to messages.
     *
     * @param msg message to be attached as warning.
     *
     * @author Adam Kowalewski
     * @version 2015.03.16
     */
    public static void addWarningMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }
}
