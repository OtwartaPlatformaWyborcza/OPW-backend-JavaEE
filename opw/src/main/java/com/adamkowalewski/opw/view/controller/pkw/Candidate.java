
package com.adamkowalewski.opw.view.controller.pkw;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Candidate {

    @Expose
    private Integer id;
    @Expose
    private String imiona;
    @Expose
    private String nazwisko;
    @Expose
    private Boolean notActive;
    @Expose
    private Integer validVotes;

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The imiona
     */
    public String getImiona() {
        return imiona;
    }

    /**
     * 
     * @param imiona
     *     The imiona
     */
    public void setImiona(String imiona) {
        this.imiona = imiona;
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
     *     The notActive
     */
    public Boolean getNotActive() {
        return notActive;
    }

    /**
     * 
     * @param notActive
     *     The notActive
     */
    public void setNotActive(Boolean notActive) {
        this.notActive = notActive;
    }

    /**
     * 
     * @return
     *     The validVotes
     */
    public Integer getValidVotes() {
        return validVotes;
    }

    /**
     * 
     * @param validVotes
     *     The validVotes
     */
    public void setValidVotes(Integer validVotes) {
        this.validVotes = validVotes;
    }

}
