package com.jj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoogleCharts {

    @RequestMapping("/piechart")
    public String showPieChart()
    {
        return "piechart";
    }
    @RequestMapping("/barchart")
    public String showBarChart()
    {
        return "barchart";
    }
}
