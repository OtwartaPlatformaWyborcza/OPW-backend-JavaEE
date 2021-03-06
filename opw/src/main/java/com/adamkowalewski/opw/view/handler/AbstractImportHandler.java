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

import com.adamkowalewski.opw.view.controller.ImportController;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.model.UploadedFile;

/**
 * Provide common methods and attributes for all import handlers.
 *
 * @param <T> CSV DTO class to be used.
 * @author Adam Kowalewski
 * @version 2015.04.12
 */
public abstract class AbstractImportHandler<T> {

    UploadedFile file;
    List<T> uploadList;

    @Inject
    ImportController importController;

    public AbstractImportHandler() {
        uploadList = new ArrayList<>();
    }

    public void cleanUp() {
        uploadList = new ArrayList<>();
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public List<T> getUploadList() {
        return uploadList;
    }

    public void setUploadList(List<T> uploadList) {
        this.uploadList = uploadList;
    }

}
