package com.jj.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedirectRestController {
    @RequestMapping("/testredirect")
    public String greeting() {
        System.out.println("inside redirect");
        return "WTddF";
    }
}
