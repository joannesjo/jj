package com.jj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FbSignInController {
    @RequestMapping("/fbsignin")
    public String fbSignIn()
    {
        return "fbsignin";
    }
}
