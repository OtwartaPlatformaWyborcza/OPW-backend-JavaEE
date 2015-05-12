
package com.adamkowalewski.opw.view.controller.pkw;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Commission {

    @Expose
    private List<Czlonkowie> czlonkowie = new ArrayList<Czlonkowie>();
    @Expose
    private String kodGminy;
    @Expose
    private Integer nrObwodu;
    @Expose
    private String siedziba;

    /**
     * 
     * @return
     *     The czlonkowie
     */
    public List<Czlonkowie> getCzlonkowie() {
        return czlonkowie;
    }

    /**
     * 
     * @param czlonkowie
     *     The czlonkowie
     */
    public void setCzlonkowie(List<Czlonkowie> czlonkowie) {
        this.czlonkowie = czlonkowie;
    }

    /**
     * 
     * @return
     *     The kodGminy
     */
    public String getKodGminy() {
        return kodGminy;
    }

    /**
     * 
     * @param kodGminy
     *     The kodGminy
     */
    public void setKodGminy(String kodGminy) {
        this.kodGminy = kodGminy;
    }

    /**
     * 
     * @return
     *     The nrObwodu
     */
    public Integer getNrObwodu() {
        return nrObwodu;
    }

    /**
     * 
     * @param nrObwodu
     *     The nrObwodu
     */
    public void setNrObwodu(Integer nrObwodu) {
        this.nrObwodu = nrObwodu;
    }

    /**
     * 
     * @return
     *     The siedziba
     */
    public String getSiedziba() {
        return siedziba;
    }

    /**
     * 
     * @param siedziba
     *     The siedziba
     */
    public void setSiedziba(String siedziba) {
        this.siedziba = siedziba;
    }

}
