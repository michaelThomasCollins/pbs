package com.pbs.model;

import java.util.HashMap;
import java.util.Map;

public abstract class Report {
	private Integer id;
	private String reportName = "";
	private String reportDate= "";
	private Integer officerId;
	private String isVerified= "";
	private String reportType;
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

	/**
	 *
	 */
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

	public String getReportDate() {
		return reportDate;
	}

	public Integer getOfficerId() {
		return officerId;
	}

	public String getReportType() {
		return reportType;
	}

	public String getIsVerified() {
        return isVerified;
    }

}
