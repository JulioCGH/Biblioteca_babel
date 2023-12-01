package com.babel.Biblioteca.services.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inventory")
public class ViewController {

    @GetMapping("/index")
    public String getIndex(){
        return "index.html";
    }
}
