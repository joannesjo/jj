package com.jj.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {


    @RequestMapping("/greeting")
    public String greeting() {
return "WTF";
    }
}
