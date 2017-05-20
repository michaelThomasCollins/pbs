package com.pbs.controller;

import java.util.*;

import com.pbs.model.Investigation;
import com.pbs.model.NoAction;
import com.pbs.model.Report;

public class ReportStub {
    private static Map<Integer, NoAction> noActionReports = new HashMap<Integer, NoAction>();
    private static Map<Integer, Investigation> investigationReports = new HashMap<Integer, Investigation>();
//    private static Map<Integer, NoAction> noActionReports = new HashMap<Integer, NoAction>();
//    private static Map<Integer, NoAction> noActionReports = new HashMap<Integer, NoAction>();

    private static Integer idIndex = 5;

    //populate initial STUB noActionReports
    static {
//        NoAction Reports
        NoAction a = new NoAction(1, "First Report", "02/06/2016", 200, "arse-on", "Frank Duffy", "Oof", "It Wasn't me", "It was him", "Yes");
        noActionReports.put(1, a);
        NoAction b = new NoAction(2, "Second Report", "01/02/2013", 80, "murder", "Michael Collins", "Thud", "I'll Kill Again", "He's got a knife!", "No");
        noActionReports.put(2, b);
        NoAction c = new NoAction(3, "Third Report", "11/03/2007", 50, "robbery", "James Johnson", "Tiny", "I would've gotten away with it if it wasn't for you pesky kids!", "No scooby snacks", "Yes");
        noActionReports.put(3, c);

//        Investigation Reports
        Investigation d = new Investigation(1, "Invest 1", "02/02/02", 201, "Stabbing", "Mr_Stab", "My Mum", "Captain Greg", "That's not a knife",
                "Yes it is", "03/03/03", "Yes");
        investigationReports.put(4, d);
        Investigation e = new Investigation(2, "Invest 2", "12/04/14", 69, "Public Exposure", "Mr_Fondle", "My Mum", "Rep. Pressed", "That's not a knife",
                "It wasn't a knife", "06/09/12", "No");
        investigationReports.put(5, e);
    }

    public static List<Report> list(String searchData) {
        // TODO Merge all lists into one, in order to return the correct values
        // TODO Also only return the queried values
        String[] searchCriteria = searchData.split(";");
        int reportId = 1;
        String reportDate = "";
        int officerId = 1;
        String reportName = "";
        try {
            if (searchCriteria[0] != null) {
                reportId = Integer.parseInt(searchCriteria[0]);
            }
            reportDate = searchCriteria[1];
            if (searchCriteria[2] != null) {
                officerId = Integer.parseInt(searchCriteria[2]);
            }
            reportName = searchCriteria[3];
        } catch (NumberFormatException e) {
            // Do not
        }


        List<Report> reports = new ArrayList<Report>();
        reports.addAll(noActionReports.values());
        reports.addAll(investigationReports.values());
        List<Report> selectedReports = new ArrayList<Report>();
        for (Report report : reports) {
            if (report.getId() == reportId) {
                selectedReports.add(report);
            }
            if(report.getReportDate().equals(reportDate)){
                selectedReports.add(report);
            }
            if(report.getOfficerId().equals(officerId)){
                selectedReports.add(report);
            }
            if(report.getReportName().equals(reportName)){
                selectedReports.add(report);
            }
        }
        return new ArrayList<Report>(selectedReports);
    }

    public static NoAction createNoAction(NoAction report) {
        idIndex = idIndex + 1;
        report.setId(idIndex);
        noActionReports.put(idIndex, report);
        return report;
    }

    public static NoAction getNoAction(Integer id) {
        return noActionReports.get(id);
    }

    public static NoAction updateNoAction(Integer id, NoAction report) {
        noActionReports.put(id, report);
        return report;
    }

    public static Report deleteNoAction(Integer id) {
        return noActionReports.remove(id);
    }
}
