package com.pbs.controller;

import java.util.*;

import com.pbs.model.NoAction;
import com.pbs.model.Report;

public class ReportStub {
    private static Map<Integer, Report> reports = new HashMap<Integer, Report>();
    private static Integer idIndex = 3;

    //populate initial reports
    static {
//			public Report(Integer id, String reportName, Date reportDate, String suspectedCrimes, Integer officerId, String persons, String officers, String statement, String details) {

        NoAction a = new NoAction(1, "First Report", new Date(), 200, "arse-on", "Frank Duffy", "Oof", "It Wasn't me", "It was him", "Yes");
        reports.put(1, a);
        NoAction b = new NoAction(2, "Second Report", new Date(), 80, "murder", "Michael Collins", "Thud", "I'll Kill Again", "He's got a knife!", "No");
        reports.put(2, b);
        NoAction c = new NoAction(3, "Third Report", new Date(), 50, "robbery", "James Johnson", "Tiny", "I would've gotten away with it if it wasn't for you pesky kids!", "No scooby snacks", "Yes");
        reports.put(3, c);
    }

    public static List<Report> list() {
        return new ArrayList<Report>(reports.values());
    }

    public static Report create(Report report) {
        idIndex += idIndex;
        report.setId(idIndex);
        reports.put(idIndex, report);
        return report;
    }

    public static Report get(Integer id) {
        return reports.get(id);
    }

    public static Report update(Integer id, Report report) {
        reports.put(id, report);
        return report;
    }

    public static Report delete(Integer id) {
        return reports.remove(id);
    }
}
