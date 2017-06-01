package com.pbs.controller;

import java.util.*;

import com.pbs.model.Investigation;
import com.pbs.model.NoAction;
import com.pbs.model.Report;

class ReportStub {

    private static Map<Integer, Report> reportMap = new HashMap<Integer, Report>();

    private static Integer idIndex = 5;

    //populate initial STUB for mocked reports
    static {
        // NoAction Reports
        NoAction a = new NoAction(1, "First Report", "02/06/2016", 200, "arse-on", "Frank Duffy", "Oof", "It Wasn't me", "It was him", "Yes");
        reportMap.put(1, a);
        NoAction b = new NoAction(2, "Second Report", "01/02/2013", 80, "murder", "Michael Collins", "Thud", "I'll Kill Again", "He's got a knife!", "No");
        reportMap.put(2, b);
        NoAction c = new NoAction(3, "Third Report", "11/03/2007", 50, "robbery", "James Johnson", "Tiny", "I would've gotten away with it if it wasn't for you pesky kids!", "No scooby snacks", "Yes");
        reportMap.put(3, c);

        // Investigation Reports
        Investigation d = new Investigation(4, "Invest 1", "02/02/02", 201, "Stabbing", "Mr_Stab", "My Mum", "Captain Greg", "That's not a knife",
                "Yes it is", "03/03/03", "Yes");
        reportMap.put(4, d);
        Investigation e = new Investigation(5, "Invest 2", "12/04/14", 69, "Public Exposure", "Mr_Fondle", "My Mum", "Rep. Pressed", "That's not a knife",
                "It wasn't a knife", "06/09/12", "No");
        reportMap.put(5, e);
    }

    static List<Report> list(String searchData) {
        String[] searchCriteria = searchData.split(";");
        // Giving Search criteria default values so that they do not throw a NullPointerException
        int reportId = -1;
        String reportDate = "";
        int officerId = -1;
        String reportName = "";
        try {
            if (searchCriteria[0] != null && !searchCriteria[0].equals("undefined")) {
                reportId = Integer.parseInt(searchCriteria[0]);
            }
            reportDate = searchCriteria[1];
            if (searchCriteria[2] != null && !searchCriteria[2].equals("undefined")) {
                officerId = Integer.parseInt(searchCriteria[2]);
            }
            reportName = searchCriteria[3];
        } catch (NumberFormatException e) {
            // An exception has occurred when trying to parse the search information (I will now detail this message to the console)
            System.out.println("Error:> " + e.getMessage());
        }


        List<Report> reports = new ArrayList<Report>();
        reports.addAll(reportMap.values());
        List<Report> selectedReports = new ArrayList<Report>();
        for (Report report : reports) {
            if (report.getId() == reportId) {
                selectedReports.add(report);
            }
            if (report.getReportDate().equals(reportDate)) {
                selectedReports.add(report);
            }
            if (report.getOfficerId().equals(officerId)) {
                selectedReports.add(report);
            }
            if (report.getReportName().equals(reportName)) {
                selectedReports.add(report);
            }
        }
        return new ArrayList<Report>(selectedReports);
    }

    static Report createReport(Report report) {
        idIndex = idIndex + 1;
        report.setId(idIndex);
        reportMap.put(idIndex, report);
        return report;
    }

    static Report getReport(Integer id) {
        return reportMap.get(id);
    }

    static Report updateReport(Integer id, Report report) {
        reportMap.put(id, report);
        return report;
    }

    static Report deleteReport(Integer id) {
        return reportMap.remove(id);
    }
}
