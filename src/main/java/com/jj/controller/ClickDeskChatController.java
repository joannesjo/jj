package com.jj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClickDeskChatController {
    @RequestMapping("/clickdeskchat")
    public String fbSignIn()
    {
        return "clickdeskchat";
    }
}
