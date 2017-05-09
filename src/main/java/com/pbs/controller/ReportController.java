package com.pbs.controller;

import com.pbs.model.Report;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Michael on 27/04/2017.
 */

@RestController
@RequestMapping("api/v1/")
public class ReportController {

    @RequestMapping(value = "reports", method = RequestMethod.GET)
    public List<Report> list() {
        return ReportStub.list();
    }

    @RequestMapping(value = "reports", method = RequestMethod.POST)
    public Report create(@RequestBody Report report){
        return ReportStub.create(report);
    }

    @RequestMapping(value = "reports/{id}", method = RequestMethod.GET)
    public Report get(@PathVariable Integer id){
        return ReportStub.get(id);
    }

    @RequestMapping(value = "reports/{id}", method = RequestMethod.PUT)
    public Report update(@PathVariable Integer id,@RequestBody Report report){
        return ReportStub.update(id,report);
    }

    @RequestMapping(value = "reports/{id}", method = RequestMethod.DELETE)
    public Report delete(@PathVariable Integer id){
        return ReportStub.delete(id);
    }
}
