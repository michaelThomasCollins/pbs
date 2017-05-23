package com.pbs.model;

/**
 * Created by Michael on 09/05/2017.
 */
public class Investigation extends Report {

    String suspectedCrimes;
    String suspects;
    String witnesses;
    String officers;
    String statement;
    String details;
    String dateOccurred;
    String reportType = "investigation";

    // This constructor has to be implemented due to weird Spring configuration
    public Investigation() {
    }

    public Investigation(Integer id, String reportName, String reportDate, Integer officerId,
                         String suspectedCrimes, String suspects, String witnesses,String officers, String statement,
                         String details, String dateOccurred, String isVerified) {
        super(id, reportName, reportDate, officerId, isVerified, "investigation");
        this.suspectedCrimes = suspectedCrimes;
        this.suspects = suspects;
        this.witnesses = witnesses;
        this.officers = officers;
        this.statement = statement;
        this.details = details;
        this.dateOccurred = dateOccurred;
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
}
