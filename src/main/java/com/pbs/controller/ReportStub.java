package com.pbs.controller;

import java.util.*;

import com.pbs.model.*;

/**
 * Created by Michael on 07/05/2017.
 * A stub class to mimic a database that stores Reports
 */
class ReportStub {

    private static Map<Integer, Report> reportMap = new HashMap<Integer, Report>();

    private static Integer idIndex = 7;

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

        //Intervention Report
        Intervention f = new Intervention(6,"Intervention 1", "06/12/98", 619,
                "No", "Robery", "Billy O'Neil",
                "No one", "Michael O'Neil", "I didn't do nuffin", "N/A", "01/02/03",
                "He walked up to the window and gave it a smash", "The window", "I caught him in the act");
        reportMap.put(6, f);

        //In Motion Report
        InMotion g = new InMotion(7, "In Motion 1", "12/12/12", 7,
                "Yes", "23/04/08", "Derek the Strangler",
                "Gluckk", "Mr Neck", "A shower on Hope Street", "11/11/11", "A bathroom on West Street",
                "Strangling", "I gave him a strangle", "Mark ThickNeck");
        reportMap.put(7, g);
    }

    /**
     * Finds the desired reports by looking through all reports and refining by search data
     * @param searchData
     * @return a list of all the reports that match the specified criteria
     */
    static List<Report> list(String searchData) throws NullPointerException{
        String[] searchCriteria = searchData.split(";");
        // Giving Search criteria default values so that they do not throw a NullPointerException
        int reportId = -1;
        String reportDate = "";
        int officerId = -1;
        String reportName = "";
        // Parse all Search Data
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

    /**
     * Creates a new report based on the reporting data specified
     * @param report
     * @return the newly created report by the user
     */
    static Report createReport(Report report){
        try {
            idIndex = idIndex + 1;
            report.setId(idIndex);
            reportMap.put(idIndex, report);
        } catch(NullPointerException e){
            // There is a chance that the user could somehow submit a null report or the reportMap could be null
            System.out.println("Error:> " + e.getMessage());
        }
        return report;
    }

    /**
     * Finds the desired report inside the reportMap by id
     * @param id
     * @return The users desired report
     */
    static Report getReport(Integer id) {
        return reportMap.get(id);
    }

    /**
     * Updates the selected report in the reportMap
     * @param id
     * @param report
     * @return the updated report
     */
    static Report updateReport(Integer id, Report report) {
        reportMap.put(id, report);
        return report;
    }

    /**
     * Deletes the report specified by the reports id
     * @param id
     * @return the report that has been deleted
     */
    static Report deleteReport(Integer id) {
        return reportMap.remove(id);
    }
}
