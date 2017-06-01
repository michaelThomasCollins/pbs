package com.pbs.model;

import com.pbs.Constants.Constants;

/**
 * Created by Michael on 09/05/2017.
 */
public class InMotion extends Report {

    private String courtDate;
    private String convicted;
    private String statement;
    private String victims;
    private String crimeLoc;
    private String dateOccurred;
    private String arrestLoc;
    private String charges;
    private String involvement;
    private String officers;
    private String reportType = "in_motion";

    // This constructor has to be implemented due to weird Spring configuration
    public InMotion() {
    }

    public InMotion(Integer id, String reportName, String reportDate, Integer officerId,
                    String isVerified, String reportType, String courtDate, String convicted,
                    String statement, String victims, String crimeLoc, String dateOccurred, String arrestLoc,
                    String charges, String involvement, String officers) {
        super(id, reportName, reportDate, officerId, isVerified, "in_motion");
        this.courtDate = courtDate;
        this.convicted = convicted;
        this.statement = statement;
        this.victims = victims;
        this.crimeLoc = crimeLoc;
        this.dateOccurred = dateOccurred;
        this.arrestLoc = arrestLoc;
        this.charges = charges;
        this.involvement = involvement;
        this.officers = officers;
    }

    @Override
    void populateFurtherDetails() {
        furtherDetails.put(Constants.COURT_DATE, courtDate);
        furtherDetails.put(Constants.CONVICTED_PERSONS, convicted);
        furtherDetails.put(Constants.STATEMENT, statement);
        furtherDetails.put(Constants.VICTIMS, victims);
        furtherDetails.put(Constants.CRIME_LOC, crimeLoc);
        furtherDetails.put(Constants.DATE_OCCURRED, dateOccurred);
        furtherDetails.put(Constants.ARREST_LOC, arrestLoc);
        furtherDetails.put(Constants.CHARGES, charges);
        furtherDetails.put(Constants.INVOLVEMENT, involvement);
        furtherDetails.put(Constants.OFFICERS, officers);
        furtherDetails.put(Constants.REPORT_TYPE, reportType);
    }

    public String getCourtDate() {
        return courtDate;
    }

    public void setCourtDate(String courtDate) {
        this.courtDate = courtDate;
    }

    public String getConvicted() {
        return convicted;
    }

    public void setConvicted(String convicted) {
        this.convicted = convicted;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getVictims() {
        return victims;
    }

    public void setVictims(String victims) {
        this.victims = victims;
    }

    public String getCrimeLoc() {
        return crimeLoc;
    }

    public void setCrimeLoc(String crimeLoc) {
        this.crimeLoc = crimeLoc;
    }

    public String getDateOccurred() {
        return dateOccurred;
    }

    public void setDateOccurred(String dateOccurred) {
        this.dateOccurred = dateOccurred;
    }

    public String getArrestLoc() {
        return arrestLoc;
    }

    public void setArrestLoc(String arrestLoc) {
        this.arrestLoc = arrestLoc;
    }

    public String getCharges() {
        return charges;
    }

    public void setCharges(String charges) {
        this.charges = charges;
    }

    public String getInvolvement() {
        return involvement;
    }

    public void setInvolvement(String involvement) {
        this.involvement = involvement;
    }

    public String getOfficers() {
        return officers;
    }

    public void setOfficers(String officers) {
        this.officers = officers;
    }

    @Override
    public String getReportType() {
        return reportType;
    }

    @Override
    public void setReportType(String reportType) {
        this.reportType = reportType;
    }
}
