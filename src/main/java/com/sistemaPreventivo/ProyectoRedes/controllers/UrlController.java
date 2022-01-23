package com.sistemaPreventivo.ProyectoRedes.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UrlController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String HomePage(){
        return "redirect:/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String goToIndex(){
        return "index.html";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String goToLogin(){
        return "login.html";
    }



}
