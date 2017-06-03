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
	 * This is an abstract method that is used by each child class
     * It allows child classes to populate the details specific to their type, and in a format that is readable
     * on the front end
	 */
	abstract void populateFurtherDetails();

	//This method is needed to load required data, it is used but is abstracted
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
