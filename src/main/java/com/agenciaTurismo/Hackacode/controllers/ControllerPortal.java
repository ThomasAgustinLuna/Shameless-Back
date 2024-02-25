package com.agenciaTurismo.Hackacode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ControllerPortal {

    @GetMapping("/")
    public String index() {

        return "redirect:http://localhost:5173/index.html";
    }
}
