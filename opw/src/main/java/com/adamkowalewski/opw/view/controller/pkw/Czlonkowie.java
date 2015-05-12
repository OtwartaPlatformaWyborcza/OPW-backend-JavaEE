
package com.adamkowalewski.opw.view.controller.pkw;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Czlonkowie {

    @Expose
    private String funkcja;
    @Expose
    private String imie1;
    @Expose
    private String imie2;
    @Expose
    private String nazwisko;
    @Expose
    private Boolean sign;

    /**
     * 
     * @return
     *     The funkcja
     */
    public String getFunkcja() {
        return funkcja;
    }

    /**
     * 
     * @param funkcja
     *     The funkcja
     */
    public void setFunkcja(String funkcja) {
        this.funkcja = funkcja;
    }

    /**
     * 
     * @return
     *     The imie1
     */
    public String getImie1() {
        return imie1;
    }

    /**
     * 
     * @param imie1
     *     The imie1
     */
    public void setImie1(String imie1) {
        this.imie1 = imie1;
    }

    /**
     * 
     * @return
     *     The imie2
     */
    public String getImie2() {
        return imie2;
    }

    /**
     * 
     * @param imie2
     *     The imie2
     */
    public void setImie2(String imie2) {
        this.imie2 = imie2;
    }

    /**
     * 
     * @return
     *     The nazwisko
     */
    public String getNazwisko() {
        return nazwisko;
    }

    /**
     * 
     * @param nazwisko
     *     The nazwisko
     */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    /**
     * 
     * @return
     *     The sign
     */
    public Boolean getSign() {
        return sign;
    }

    /**
     * 
     * @param sign
     *     The sign
     */
    public void setSign(Boolean sign) {
        this.sign = sign;
    }

}
