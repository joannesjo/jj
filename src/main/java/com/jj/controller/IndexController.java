package com.jj.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class IndexController {
    private String message = "Hello World";

    @RequestMapping("/index")
    public String welcome(Map<String, Object> model) {
        System.out.println("inside dddd");
        model.put("message", this.message);
        return "index";
    }
}
