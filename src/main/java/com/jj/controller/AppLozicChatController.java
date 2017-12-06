package com.jj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppLozicChatController {
    @RequestMapping("/applozicchat")
    public String fbSignIn()
    {
        return "applozicchat";
    }
}
