package com.pbs.model;

import com.pbs.Constants.Constants;

/**
 * Created by Michael on 09/05/2017.
 */
public class Intervention extends Report {

    String suspectedCrimes;
    String suspects;
    String witnesses;
    String officers;
    String statement;
    String details;
    String dateOccurred;
    String event;
    String victims;
    String involvement;
    String reportType = "intervention";

    // This constructor has to be implemented due to weird Spring configuration
    public Intervention() {
    }

    public Intervention(Integer id, String reportName, String reportDate, Integer officerId,
                        String isVerified, String reportType, String suspectedCrimes, String suspects,
                        String witnesses, String officers, String statement, String details, String dateOccurred,
                        String event, String victims, String involvement) {
        super(id, reportName, reportDate, officerId, isVerified, reportType);
        this.suspectedCrimes = suspectedCrimes;
        this.suspects = suspects;
        this.witnesses = witnesses;
        this.officers = officers;
        this.statement = statement;
        this.details = details;
        this.dateOccurred = dateOccurred;
        this.event = event;
        this.victims = victims;
        this.involvement = involvement;
    }

    @Override
    void populateFurtherDetails() {
        furtherDetails.put(Constants.SUSPECTED_CRIMES, suspectedCrimes);
        furtherDetails.put(Constants.DATE_OCCURRED, dateOccurred);
        furtherDetails.put(Constants.DETAILS, details);
        furtherDetails.put(Constants.OFFICERS, officers);
        furtherDetails.put(Constants.REPORT_TYPE, reportType);
        furtherDetails.put(Constants.STATEMENT, statement);
        furtherDetails.put(Constants.SUSPECTS, suspects);
        furtherDetails.put(Constants.WITNESSES, witnesses);
        furtherDetails.put(Constants.INVOLVEMENT, involvement);
        furtherDetails.put(Constants.EVENT, event);
        furtherDetails.put(Constants.VICTIMS, victims);
    }

    public String getSuspectedCrimes() {
        return suspectedCrimes;
    }

    public void setSuspectedCrimes(String suspectedCrimes) {
        this.suspectedCrimes = suspectedCrimes;
    }

    public String getSuspects() {
        return suspects;
    }

    public void setSuspects(String suspects) {
        this.suspects = suspects;
    }

    public String getOfficers() {
        return officers;
    }

    public void setOfficers(String longitude) {
        this.officers = longitude;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getReportType() {
        return reportType;
    }

    public String getWitnesses() {
        return witnesses;
    }

    public void setWitnesses(String witnesses) {
        this.witnesses = witnesses;
    }

    public String getDateOccurred() {
        return dateOccurred;
    }

    public void setDateOccurred(String dateOccurred) {
        this.dateOccurred = dateOccurred;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getVictims() {
        return victims;
    }

    public void setVictims(String victims) {
        this.victims = victims;
    }

    public String getInvolvement() {
        return involvement;
    }

    public void setInvolvement(String involvement) {
        this.involvement = involvement;
    }
}
