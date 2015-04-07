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
package com.adamkowalewski.opw.session.controller;

import com.adamkowalewski.opw.entity.OpwOkregowaKomisja;
import com.adamkowalewski.opw.bean.OkregowaBean;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

/**
 * Provides reusable logic around Komisja Okregowa.
 *
 * @author Adam Kowalewski
 */
@Named
@SessionScoped
public class OkregowaController implements Serializable {
    
    @EJB
    OkregowaBean bean;
    
    public void create(OpwOkregowaKomisja okregowa) {
        bean.create(okregowa);
    }
    
    public void edit(OpwOkregowaKomisja okregowa) {
        bean.edit(okregowa);
    }
    
    public List<OpwOkregowaKomisja> findAll() {
        return bean.findAll();
    }
    
    public OpwOkregowaKomisja find(int id) {
        return bean.find(id);
    }
    
    public OpwOkregowaKomisja findByPkwId(int pkwId) {
        return bean.findOkregowa(pkwId);
    }
    
    public void create(List<OpwOkregowaKomisja> okregowaList) {
        for (OpwOkregowaKomisja okregowa : okregowaList) {
            bean.create(okregowa);
        }
    }

    /**
     * Converter required for dynamic list selection within JSF.
     */
    @FacesConverter(forClass = OpwOkregowaKomisja.class)
    public static class OpwOkregowaKomisjaControllerConverter implements Converter {
        
        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            OkregowaController controller = (OkregowaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "okregowaController");
            return controller.find(getKey(value));
        }
        
        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }
        
        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }
        
        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof OpwOkregowaKomisja) {
                OpwOkregowaKomisja o = (OpwOkregowaKomisja) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + OpwOkregowaKomisja.class.getName());
            }
        }
        
    }
    
}
