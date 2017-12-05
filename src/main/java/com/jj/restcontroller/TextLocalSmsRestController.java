package com.jj.restcontroller;

import com.jj.model.TextLocalSendSMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextLocalSmsRestController {

    @Autowired
    TextLocalSendSMS textLocalSendSMS;
    @RequestMapping("/textlocalsendsms")
    public String greeting() {
        try {
            return textLocalSendSMS.sendSms();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return "somethig went wrong";
    }
}
