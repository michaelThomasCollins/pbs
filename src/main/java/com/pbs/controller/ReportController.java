package com.pbs.controller;

import com.pbs.model.Report;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
