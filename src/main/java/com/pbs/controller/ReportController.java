package com.pbs.controller;

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

    @RequestMapping(value = "reports", method = RequestMethod.GET)
    public List<NoAction> list() {
        return ReportStub.list();
    }

    @RequestMapping(value = "reports", method = RequestMethod.POST)
    public NoAction create(@RequestBody NoAction report) {
        return ReportStub.create(report);
    }

    @RequestMapping(value = "reports/{id}", method = RequestMethod.GET)
    public NoAction get(@PathVariable Integer id) {
        return ReportStub.get(id);
    }

    @RequestMapping(value = "reports/{id}", method = RequestMethod.PUT)
    public NoAction update(@PathVariable Integer id, @RequestBody NoAction report) {
        return ReportStub.update(id, report);
    }

    @RequestMapping(value = "reports/{id}", method = RequestMethod.DELETE)
    public NoAction delete(@PathVariable Integer id) {
        return ReportStub.delete(id);
    }


}
