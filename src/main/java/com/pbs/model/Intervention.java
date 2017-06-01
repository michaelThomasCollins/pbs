package com.pbs.model;

import com.pbs.Constants.Constants;

/**
 * Created by Michael on 09/05/2017.
 */
public class Intervention extends Report {

    private String suspectedCrimes;
    private String suspects;
    private String witnesses;
    private String officers;
    private String statement;
    private String details;
    private String dateOccurred;
    private String event;
    private String victims;
    private String involvement;
    private String reportType = "intervention";

    // This constructor has to be implemented due to weird Spring configuration
    public Intervention() {
    }

    public Intervention(Integer id, String reportName, String reportDate, Integer officerId,
                        String isVerified, String suspectedCrimes, String suspects,
                        String witnesses, String officers, String statement, String details, String dateOccurred,
                        String event, String victims, String involvement) {
        super(id, reportName, reportDate, officerId, isVerified, "intervention");
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

        populateFurtherDetails();
    }

    @Override
    void populateFurtherDetails() {
        furtherDetails.put(Constants.SUSPECTED_CRIMES, getSuspectedCrimes());
        furtherDetails.put(Constants.DATE_OCCURRED, getDateOccurred());
        furtherDetails.put(Constants.DETAILS, getDetails());
        furtherDetails.put(Constants.OFFICERS, getOfficers());
        furtherDetails.put(Constants.REPORT_TYPE, getReportType());
        furtherDetails.put(Constants.STATEMENT, getStatement());
        furtherDetails.put(Constants.SUSPECTS, getSuspects());
        furtherDetails.put(Constants.WITNESSES, getWitnesses());
        furtherDetails.put(Constants.INVOLVEMENT, getInvolvement());
        furtherDetails.put(Constants.EVENT, getEvent());
        furtherDetails.put(Constants.VICTIMS, getVictims());
    }

    public String getSuspectedCrimes() {
        return suspectedCrimes;
    }

    public String getSuspects() {
        return suspects;
    }

    public String getOfficers() {
        return officers;
    }

    public String getStatement() {
        return statement;
    }

    public String getDetails() {
        return details;
    }

    public String getReportType() {
        return reportType;
    }

    public String getWitnesses() {
        return witnesses;
    }

    public String getDateOccurred() {
        return dateOccurred;
    }

    public String getEvent() {
        return event;
    }

    public String getVictims() {
        return victims;
    }

    public String getInvolvement() {
        return involvement;
    }
}
