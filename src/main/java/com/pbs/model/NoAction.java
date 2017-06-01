package com.pbs.model;

import com.pbs.Constants.Constants;

import java.util.Date;

/**
 * Created by Michael on 09/05/2017.
 */
public class NoAction extends Report{

    private String suspectedCrimes;
    private String persons;
    private String officers;
    private String statement;
    private String details;
    private String reportType = "no_action";

    // This constructor has to be implemented due to weird Spring implementation
    public NoAction() { }

    public NoAction(Integer id, String reportName, String reportDate, Integer officerId, String suspectedCrimes, String persons, String officers, String statement, String details, String isVerified) {
        super(id, reportName, reportDate, officerId, isVerified,"no_action");
        this.suspectedCrimes = suspectedCrimes;
        this.persons = persons;
        this.officers = officers;
        this.statement = statement;
        this.details = details;

        populateFurtherDetails();
    }

    @Override
    void populateFurtherDetails() {
        furtherDetails.put(Constants.SUSPECTED_CRIMES, getSuspectedCrimes());
        furtherDetails.put(Constants.DETAILS, getPersons());
        furtherDetails.put(Constants.OFFICERS, getOfficers());
        furtherDetails.put(Constants.REPORT_TYPE, getReportType());
        furtherDetails.put(Constants.STATEMENT, getStatement());
    }

    public String getSuspectedCrimes() {
        return suspectedCrimes;
    }

    public String getPersons() {
        return persons;
    }

    public String getOfficers() {
        return officers;
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
}
