package com.pbs.controller;

import java.util.*;

import com.pbs.model.NoAction;
import com.pbs.model.Report;

public class ReportStub {
    private static Map<Integer, NoAction> reports = new HashMap<Integer, NoAction>();
    private static Integer idIndex = 3;

    //populate initial reports
    static {
//			public Report(Integer id, String reportName, Date reportDate, String suspectedCrimes, Integer officerId, String persons, String officers, String statement, String details) {

        NoAction a = new NoAction(1, "First Report", "02/06/2016", 200, "arse-on", "Frank Duffy", "Oof", "It Wasn't me", "It was him", "Yes");
        reports.put(1, a);
        NoAction b = new NoAction(2, "Second Report", "01/02/2013", 80, "murder", "Michael Collins", "Thud", "I'll Kill Again", "He's got a knife!", "No");
        reports.put(2, b);
        NoAction c = new NoAction(3, "Third Report", "11/03/2007", 50, "robbery", "James Johnson", "Tiny", "I would've gotten away with it if it wasn't for you pesky kids!", "No scooby snacks", "Yes");
        reports.put(3, c);
    }

    public static List<NoAction> list() {
        return new ArrayList<NoAction>(reports.values());
    }

    public static NoAction create(NoAction report) {
        idIndex += idIndex;
        report.setId(idIndex);
        reports.put(idIndex, report);
        return report;
    }

    public static NoAction get(Integer id) {
        return reports.get(id);
    }

    public static NoAction update(Integer id, NoAction report) {
        reports.put(id, report);
        return report;
    }

    public static NoAction delete(Integer id) {
        return reports.remove(id);
    }
}
