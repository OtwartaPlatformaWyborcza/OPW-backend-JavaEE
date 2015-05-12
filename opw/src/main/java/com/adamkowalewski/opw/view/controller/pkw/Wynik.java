
package com.adamkowalewski.opw.view.controller.pkw;

import com.adamkowalewski.opw.view.controller.pkw.Commission;
import com.adamkowalewski.opw.view.controller.pkw.FilledData;
import com.adamkowalewski.opw.view.controller.pkw.Candidate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Wynik {

    @Expose
    private List<Candidate> candidates = new ArrayList<Candidate>();
    @Expose
    private Commission commission;
    @Expose
    private FilledData filledData;
    @Expose
    private List<String> warnings = new ArrayList<String>();

    /**
     * 
     * @return
     *     The candidates
     */
    public List<Candidate> getCandidates() {
        return candidates;
    }

    /**
     * 
     * @param candidates
     *     The candidates
     */
    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    /**
     * 
     * @return
     *     The commission
     */
    public Commission getCommission() {
        return commission;
    }

    /**
     * 
     * @param commission
     *     The commission
     */
    public void setCommission(Commission commission) {
        this.commission = commission;
    }

    /**
     * 
     * @return
     *     The filledData
     */
    public FilledData getFilledData() {
        return filledData;
    }

    /**
     * 
     * @param filledData
     *     The filledData
     */
    public void setFilledData(FilledData filledData) {
        this.filledData = filledData;
    }

    /**
     * 
     * @return
     *     The warnings
     */
    public List<String> getWarnings() {
        return warnings;
    }

    /**
     * 
     * @param warnings
     *     The warnings
     */
    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

}
