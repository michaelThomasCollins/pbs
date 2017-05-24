package com.pbs.controller;

import com.pbs.model.Investigation;
import com.pbs.model.NoAction;
import com.pbs.model.Report;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Michael on 27/04/2017.
 * A controller to
 */

@RestController
@RequestMapping("api/v1/")
public class ReportController {

    /*
        Return a list of all the reports within the system
     */
    @RequestMapping(value = "search/{searchData}", method = RequestMethod.GET)
    public List<Report> list(@PathVariable String searchData) {
        return ReportStub.list(searchData);
    }

    /*
        Create a Report and save into the system
     */
    @RequestMapping(value = "reports", method = RequestMethod.POST)
    public NoAction create(@RequestBody NoAction report) {
        return ReportStub.createNoAction(report);
    }

    @RequestMapping(value = "reports/{id}", method = RequestMethod.GET)
    public Report get(@PathVariable Integer id) {
        return ReportStub.getReport(id);
    }

//    /*
//
//     */
//    @RequestMapping(value = "reports/{id}", method = RequestMethod.GET)
//    public Investigation getInvestigation(@PathVariable Integer id) {
//        return ReportStub.getInvestigation(id);
//    }

//    @RequestMapping(value = "reports/{id}", method = RequestMethod.GET)
//    public NoAction getNoAction(@PathVariable Integer id) {
//        return ReportStub.getNoAction(id);
//    }

    @RequestMapping(value = "reports/{id}", method = RequestMethod.PUT)
    public NoAction update(@PathVariable Integer id, @RequestBody NoAction report) {
        return ReportStub.updateNoAction(id, report);
    }

    @RequestMapping(value = "reports/{id}", method = RequestMethod.DELETE)
    public Report delete(@PathVariable Integer id) {
        return ReportStub.deleteNoAction(id);
    }


}
