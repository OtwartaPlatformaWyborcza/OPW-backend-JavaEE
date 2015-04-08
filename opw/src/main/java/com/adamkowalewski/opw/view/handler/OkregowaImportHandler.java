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
import com.adamkowalewski.opw.view.controller.MsgController;
import com.adamkowalewski.opw.view.dto.OkregowaCsvDto;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.UploadedFile;

/**
 * Handler for CSV import of Komisja Okregowa.
 *
 * @author Adam Kowalewski
 */
@Named
@SessionScoped
public class OkregowaImportHandler implements Serializable {

    private final String formatCsv = "CSV";
    private final String formatXml = "XML";

    private UploadedFile file;
    private List<OkregowaCsvDto> okregowaList;

    @Inject
    ImportController importController;   

    private String importFormat;

    public OkregowaImportHandler() {
        okregowaList = new ArrayList<>();
    }

    public void performImport() {
        if (okregowaList != null && !okregowaList.isEmpty()) {
            importController.performImport(okregowaList);
        }
    }

    public void upload() {
        if (file != null) {
            okregowaList = new ArrayList<>();
            try {
                InputStream is = file.getInputstream();
                okregowaList = importController.parseOkregowa(is);
                System.out.println("x");
            } catch (IOException | IndexOutOfBoundsException | NumberFormatException | PatternSyntaxException ex) {
                Logger.getLogger(OkregowaImportHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        MsgController.addErrorMessage("WiP");
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public List<OkregowaCsvDto> getOkregowaList() {
        return okregowaList;
    }

    public void setOkregowaList(List<OkregowaCsvDto> okregowaList) {
        this.okregowaList = okregowaList;
    }

}
