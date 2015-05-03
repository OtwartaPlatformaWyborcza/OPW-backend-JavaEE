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

import com.adamkowalewski.opw.bean.ConfigBean;
import com.adamkowalewski.opw.view.OpwConfigStatic;
import com.adamkowalewski.opw.view.dto.ConfigMailDto;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unified configuration. TODO load from database TODO load from properties
 *
 * @author Adam Kowalewski
 */
@Named
@SessionScoped
public class ConfigController implements Serializable {
    
    private static final Logger logger = LoggerFactory.getLogger(ConfigController.class);

    private String applicationSalt;    

    private ConfigMailDto configMail;

    private boolean configMailOutboundActive;

    private boolean configImportDuplicatesAllowed;

    private boolean listKandydatOpen;
    private boolean listOkregowaOpen;
    
    @EJB
    ConfigBean configBean;

    public ConfigController() {

    }

    @PostConstruct
    public void initConfigController() {
        
        configMail = new ConfigMailDto("Otwarta Platforma Wyborcza", "opw@adamkowalewski.com", 
                configBean.readConfigValue(OpwConfigStatic.CFG_KEY_BASE_URL));                
        configMailOutboundActive = Boolean.valueOf(configBean.readConfigValue(OpwConfigStatic.CFG_KEY_EMAIL_OUTBOUND));
        configImportDuplicatesAllowed = false;
        listKandydatOpen = false;
        listOkregowaOpen = false;
        applicationSalt = OpwConfigStatic.APP_SALT;
    }

    public String getApplicationSalt() {
        return applicationSalt;
    }

    public ConfigMailDto getConfigMail() {
        return configMail;
    }

    public void setConfigMail(ConfigMailDto configMail) {
        this.configMail = configMail;
    }

    public boolean isConfigMailOutboundActive() {
        return configMailOutboundActive;
    }

    public void setConfigMailOutboundActive(boolean configMailOutboundActive) {
        this.configMailOutboundActive = configMailOutboundActive;
    }

    public boolean isConfigImportDuplicatesAllowed() {
        return configImportDuplicatesAllowed;
    }

    public void setConfigImportDuplicatesAllowed(boolean configImportDuplicatesAllowed) {
        this.configImportDuplicatesAllowed = configImportDuplicatesAllowed;
    }

    public boolean isListKandydatOpen() {
        return listKandydatOpen;
    }

    public void setListKandydatOpen(boolean listKandydatOpen) {
        this.listKandydatOpen = listKandydatOpen;
    }

    public boolean isListOkregowaOpen() {
        return listOkregowaOpen;
    }

    public void setListOkregowaOpen(boolean listOkregowaOpen) {
        this.listOkregowaOpen = listOkregowaOpen;
    }

}
