package com.jj.restcontroller;

import com.jj.model.InstaMojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstaMojoRestController {

    @Autowired
    InstaMojo instaMojo;

    @RequestMapping("/createpayment")
    public String greeting() {
        return instaMojo.createPayment();
    }

    @RequestMapping("/testredirect")
    public String redirectstatus( @RequestParam("transaction_id") String tid) {
        return instaMojo.getPaymentStatus(tid);
    }
}
