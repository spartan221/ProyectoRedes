package com.sistemaPreventivo.ProyectoRedes.controllers;

import com.sistemaPreventivo.ProyectoRedes.models.Usuario;
import com.sistemaPreventivo.ProyectoRedes.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    AuthService authService;


    @RequestMapping(value = "api/login" , method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        if (authService.estaRegistrado(usuario)){
            return "OK";
        }else{
            return "FAIL";
        }
    }


}
