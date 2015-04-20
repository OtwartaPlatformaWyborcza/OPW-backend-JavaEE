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

import com.adamkowalewski.opw.view.controller.MsgController;
import com.adamkowalewski.opw.view.dto.UserCsvDto;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Import handler for user accounts.
 *
 * @author Adam Kowalewski
 */
@Named
@SessionScoped
public class ImportUserHandler extends AbstractImportHandler<UserCsvDto> implements Serializable {
    
    private static final Logger logger = LoggerFactory.getLogger(ImportUserHandler.class);

    public void upload() {
        if (file != null) {
            uploadList = new ArrayList<>();

            InputStream is;
            try {
                is = file.getInputstream();
                uploadList = importController.parseUser(is);
            } catch (IOException ex) {
                logger.error("File upload",ex);                
                MsgController.addErrorMessage(MsgController.getLocalizedMessage("importFileParseError"));
            }
            MsgController.addSuccessMessage(MsgController.getLocalizedMessage("importFileParseSuccess"));
        }
    }

    public void performImport() {
        if (uploadList != null && !uploadList.isEmpty()) {
            importController.performImportUser(uploadList);
            cleanUp();
        }
        MsgController.addSuccessMessage(MsgController.getLocalizedMessage("importUserSuccess"));
    }

    @Override
    public List<UserCsvDto> getUploadList() {
        return uploadList;
    }
}
