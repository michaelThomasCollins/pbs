package com.pbs.model;

import java.util.Date;

public abstract class Report {
	Integer id;
	String reportName;
	Date reportDate;
	Integer officerId;
    String isVerified;

	public Report() { }

	public Report(Integer id, String reportName, Date reportDate, Integer officerId, String isVerified) {
		this.id = id;
		this.reportName = reportName;
		this.reportDate = reportDate;
		this.officerId = officerId;
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

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public Integer getOfficerId() {
		return officerId;
	}

	public void setOfficerId(Integer officerId) {
		this.officerId = officerId;
	}

    public String getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(String verified) {
        isVerified = verified;
    }
}
