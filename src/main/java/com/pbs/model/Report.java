package com.pbs.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT, property = "@id")
//@JsonSubTypes({ @JsonSubTypes.Type(value = Investigation.class, name = "investigation"),            @JsonSubTypes.Type(value = Report.class, name = "reportType"),
//})
public abstract class Report {
	Integer id;
	String reportName = "";
	String reportDate= "";
	Integer officerId;
    String isVerified= "";
    String reportType;
    Map<String,String> furtherDetails = new HashMap<String, String>();

	public Report() { }

    public Report(Integer id, String reportName, String reportDate, Integer officerId, String isVerified, String reportType) {
        this.id = id;
        this.reportName = reportName;
        this.reportDate = reportDate;
        this.officerId = officerId;
        this.isVerified = isVerified;
        this.reportType = reportType;
    }

    abstract void populateFurtherDetails();

	public Map<String, String> getFurtherDetails() {
		return furtherDetails;
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

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(String verified) {
        isVerified = verified;
    }
}
