package com.pbs.model;

import java.util.Date;

public class Report {
	Integer id;
	String reportName;
	Date reportDate;
	Integer officerId;
	String suspectedCrimes;
	String persons;
	String officers;
	String statement;
	String details;

	public Report() { }

	public Report(Integer id, String reportName, Date reportDate, String suspectedCrimes, Integer officerId, String persons, String officers, String statement, String details) {
		this.id = id;
		this.reportName = reportName;
		this.reportDate = reportDate;
		this.suspectedCrimes = suspectedCrimes;
		this.officerId = officerId;
		this.persons = persons;
		this.officers = officers;
		this.statement = statement;
		this.details = details;
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

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getSuspectedCrimes() {
		return suspectedCrimes;
	}

	public void setSuspectedCrimes(String suspectedCrimes) {
		this.suspectedCrimes = suspectedCrimes;
	}

	public Integer getOfficerId() {
		return officerId;
	}

	public void setOfficerId(Integer officerId) {
		this.officerId = officerId;
	}

	public String getPersons() {
		return persons;
	}

	public void setPersons(String persons) {
		this.persons = persons;
	}

	public String getIntegeritude() {
		return officers;
	}

	public void setIntegeritude(String longitude) {
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
