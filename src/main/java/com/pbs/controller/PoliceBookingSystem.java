package com.pbs.controller;

import com.pbs.model.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Michael Collins on 27/04/2017.
 * The main class within the system. It is concerned with connect all of the other classes together, and ensuring
 * that they have the ability to contact each other when required. It allows the front end to "talk to" the back end
 */

@RestController
@RequestMapping("api/v1/")
public class PoliceBookingSystem {


    /**
     * Return a list the reports within the system that match given criteria
     * @param searchData
     * @return a list of reports based on search criteria
     */
    @RequestMapping(value = "search/{searchData}", method = RequestMethod.GET)
    public List<Report> list(@PathVariable String searchData) {
        return ReportStub.list(searchData);
    }

    /**
     * This method returns a report based on the report ID.
     * @param id
     * @return
     */
    @RequestMapping(value = "reports/{id}", method = RequestMethod.GET)
    public Report get(@PathVariable Integer id) {
        return ReportStub.getReport(id);
    }

    /**
        These methods are the update methods for the system When a user has edited a currently existing report,
         it is passed back to the ReportController, which then executes the updateReport method in ReportStub.
         The reason that there are four different update links being supplied is due to the fact that each method
         passes back a different type of report, this lets us get all of the individual details that are specific to
         that report, rather than saving it as a generic Report and losing all of the attributes specific to that report
         type.
     */
    @RequestMapping(value = "reports/{id}/no_action", method = RequestMethod.PUT)
    public Report update(@PathVariable Integer id, @RequestBody NoAction report) {
        return ReportStub.updateReport(id, report);
    }
    @RequestMapping(value = "reports/{id}/investigation", method = RequestMethod.PUT)
    public Report update(@PathVariable Integer id, @RequestBody Investigation report) {
        return ReportStub.updateReport(id, report);
    }
    @RequestMapping(value = "reports/{id}/intervention", method = RequestMethod.PUT)
    public Report update(@PathVariable Integer id, @RequestBody Intervention report) {
        return ReportStub.updateReport(id, report);
    }
    @RequestMapping(value = "reports/{id}/in_motion", method = RequestMethod.PUT)
    public Report update(@PathVariable Integer id, @RequestBody InMotion report) {
        return ReportStub.updateReport(id, report);
    }

    /**
       These methods are the Create methods for my system. They are simlar to update in that we have to save different
       details depending on the report. These methods are accessed by the front end, they pass in the new report with
       the new details. It then calls the createReport method in ReportStub.
     */

    /**
     * @param report
     * @return Newly created NoAction Report
     */
    @RequestMapping(value = "reports/no_action", method = RequestMethod.POST)
    public Report create(@RequestBody NoAction report) {
        return ReportStub.createReport(report);
    }

    /**
     * @param report
     * @return Newly created Investigation Report
     */
    @RequestMapping(value = "reports/investigation", method = RequestMethod.POST)
    public Report create(@RequestBody Investigation report) {
        return ReportStub.createReport(report);
    }

    /**
     * @param report
     * @return Newly created Intervention Report
     */
    @RequestMapping(value = "reports/intervention", method = RequestMethod.POST)
    public Report create(@RequestBody Intervention report) {
        return ReportStub.createReport(report);
    }

    /**
     * @param report
     * @return Newly created InMotion Report
     */
    @RequestMapping(value = "reports/in_motion", method = RequestMethod.POST)
    public Report create(@RequestBody InMotion report) {
        return ReportStub.createReport(report);
    }

    /**
     * This method removes a report from the data location. It finds this report based on the reports ID.
     * @param id
     * @return deleted report
     */
    @RequestMapping(value = "reports/{id}", method = RequestMethod.DELETE)
    public Report delete(@PathVariable Integer id) {
        return ReportStub.deleteReport(id);
    }

    /**
     * This method gets the desired user from the Stubbed database.
     * If the user isn't there, nothing is returned.
     * @param userName
     * @return Requested user
     */
    @RequestMapping(value = "users/{userName}", method = RequestMethod.GET)
    public User get(@PathVariable String userName) {
        return UserStub.get(userName);
    }
}
