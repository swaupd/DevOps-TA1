package com.example.ta1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewController {

    @GetMapping("/{page}")
    public String servePage(@PathVariable String page) {
        return page.toLowerCase(); // Serves templates/{page}.html
    }
}

