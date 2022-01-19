package com.sistemaPreventivo.ProyectoRedes.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UrlController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirectToLogin(){
        return "redirect:login";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String goToLogin(){
        return "login.html";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String goToRegister(){
        return "registro.html";
    }

}
