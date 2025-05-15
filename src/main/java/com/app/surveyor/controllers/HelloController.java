package com.app.surveyor.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class HelloController {
    @GetMapping("/heartbeat")
    public String heartBeat() {
        return "Heart is beating...";
    }
}
