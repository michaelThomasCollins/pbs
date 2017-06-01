package com.pbs.model;

import com.pbs.Constants.Constants;

import java.util.Date;

/**
 * Created by Michael on 09/05/2017.
 */
public class NoAction extends Report{

    private String suspectedCrimes;
    private String suspects;
    private String officers;
    private String statement;
    private String details;
    private String reportType = "no_action";

    // This constructor has to be implemented due to weird Spring implementation
    public NoAction() { }

    public NoAction(Integer id, String reportName, String reportDate, Integer officerId, String suspectedCrimes, String suspects, String officers, String statement, String details, String isVerified) {
        super(id, reportName, reportDate, officerId, isVerified,"no_action");
        this.suspectedCrimes = suspectedCrimes;
        this.suspects = suspects;
        this.officers = officers;
        this.statement = statement;
        this.details = details;

        populateFurtherDetails();
    }

    @Override
    void populateFurtherDetails() {
        furtherDetails.put(Constants.SUSPECTED_CRIMES, getSuspectedCrimes());
        furtherDetails.put(Constants.DETAILS, getDetails());
        furtherDetails.put(Constants.SUSPECTS, getSuspects());
        furtherDetails.put(Constants.OFFICERS, getOfficers());
        furtherDetails.put(Constants.REPORT_TYPE, getReportType());
        furtherDetails.put(Constants.STATEMENT, getStatement());
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
}
