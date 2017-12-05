package com.jj.restcontroller;

import com.jj.model.InstaMojo;
import com.jj.model.Quickstart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GMailRestController {
    @Autowired
    Quickstart quickstart;

    @RequestMapping("/sendmail")
    public String greeting() {
        return quickstart.sendMail();
    }
}
