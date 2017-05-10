package com.pbs.model;

import java.util.Date;

public class Report {
	Integer id;
	String reportName = "";
	String reportDate= "";
	Integer officerId;
    String suspectedCrimes= "";
    String persons= "";
    String officers= "";
    String statement= "";
    String details= "";
    String isVerified= "";

	public Report() { }

    public Report(Integer id, String reportName, String reportDate, Integer officerId, String suspectedCrimes, String persons, String officers, String statement, String details, String isVerified) {
        this.id = id;
        this.reportName = reportName;
        this.reportDate = reportDate;
        this.officerId = officerId;
        this.suspectedCrimes = suspectedCrimes;
        this.persons = persons;
        this.officers = officers;
        this.statement = statement;
        this.details = details;
        this.isVerified = isVerified;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public Integer getOfficerId() {
		return officerId;
	}

	public void setOfficerId(Integer officerId) {
		this.officerId = officerId;
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

    public void setOfficers(String officers) {
        this.officers = officers;
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

    public String getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(String verified) {
        isVerified = verified;
    }
}
