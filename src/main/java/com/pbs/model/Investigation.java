package com.pbs.model;

import com.pbs.Constants.Constants;

/**
 * Created by Michael on 09/05/2017.
 */
public class Investigation extends Report {

    private String suspectedCrimes;
    private String suspects;
    private String witnesses;
    private String officers;
    private String statement;
    private String details;
    private String dateOccurred;
    private String reportType = "investigation";

    // This constructor has to be implemented due to weird Spring configuration
    public Investigation() {
    }

    public Investigation(Integer id, String reportName, String reportDate, Integer officerId,
                         String suspectedCrimes, String suspects, String witnesses, String officers, String statement,
                         String details, String dateOccurred, String isVerified) {
        super(id, reportName, reportDate, officerId, isVerified, "investigation");
        this.suspectedCrimes = suspectedCrimes;
        this.suspects = suspects;
        this.witnesses = witnesses;
        this.officers = officers;
        this.statement = statement;
        this.details = details;
        this.dateOccurred = dateOccurred;
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
    }

    public String getSuspectedCrimes() {
        return suspectedCrimes;
    }

    public String getSuspects() {
        return suspects;
    }

    public String getWitnesses() {
        return witnesses;
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


    public String getDateOccurred() {
        return dateOccurred;
    }


    @Override
    public String getReportType() {
        return reportType;
    }

}
