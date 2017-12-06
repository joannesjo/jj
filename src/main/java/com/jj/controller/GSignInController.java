package com.jj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GSignInController {

    @RequestMapping("/gsignin")
    public String showPieChart()
    {
        return "gsignin";
    }
}
