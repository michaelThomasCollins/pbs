package com.pbs.model;

import java.util.Date;

/**
 * Created by Michael on 09/05/2017.
 */
public class NoAction extends Report {

    String suspectedCrimes;
    String persons;
    String officers;
    String statement;
    String details;

    public NoAction(Integer id, String reportName, Date reportDate, Integer officerId, String suspectedCrimes, String persons,String officers,String statement, String details) {
        super(id, reportName, reportDate, officerId);
        this.suspectedCrimes = suspectedCrimes;
        this.persons = persons;
        this.officers = officers;
        this.statement = statement;
        this.details = details;

    }


    public String getSuspectedCrimes() {
        return suspectedCrimes;
    }

    public void setSuspectedCrimes(String suspectedCrimes) {
        this.suspectedCrimes = suspectedCrimes;
    }

    public String getPersons() {
        return persons;
    }

    public void setPersons(String persons) {
        this.persons = persons;
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
}