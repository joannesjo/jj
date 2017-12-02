package com.jj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/greeting1")
    public void greeting() {
            System.out.println("this is controller");

    }
}
