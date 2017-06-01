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
                    String isVerified, String courtDate, String convicted,
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

        populateFurtherDetails();
    }

    @Override
    void populateFurtherDetails() {
        furtherDetails.put(Constants.COURT_DATE, getCourtDate());
        furtherDetails.put(Constants.CONVICTED_PERSONS, getConvicted());
        furtherDetails.put(Constants.STATEMENT, getStatement());
        furtherDetails.put(Constants.VICTIMS, getVictims());
        furtherDetails.put(Constants.CRIME_LOC, getCrimeLoc());
        furtherDetails.put(Constants.DATE_OCCURRED, getDateOccurred());
        furtherDetails.put(Constants.ARREST_LOC, getArrestLoc());
        furtherDetails.put(Constants.CHARGES, getCharges());
        furtherDetails.put(Constants.INVOLVEMENT, getInvolvement());
        furtherDetails.put(Constants.OFFICERS, getOfficers());
        furtherDetails.put(Constants.REPORT_TYPE, getReportType());
    }

    public String getCourtDate() {
        return courtDate;
    }

    public String getConvicted() {
        return convicted;
    }

    public String getStatement() {
        return statement;
    }

    public String getVictims() {
        return victims;
    }

    public String getCrimeLoc() {
        return crimeLoc;
    }

    public String getDateOccurred() {
        return dateOccurred;
    }

    public String getArrestLoc() {
        return arrestLoc;
    }

    public String getCharges() {
        return charges;
    }

    public String getInvolvement() {
        return involvement;
    }

    public String getOfficers() {
        return officers;
    }

    @Override
    public String getReportType() {
        return reportType;
    }

}
