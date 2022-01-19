package com.sistemaPreventivo.ProyectoRedes.controllers;


import com.sistemaPreventivo.ProyectoRedes.models.Usuario;
import com.sistemaPreventivo.ProyectoRedes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public String registrarUsuario(@RequestBody Usuario usuario) {
        if(usuarioService.registrarUsuario(usuario)){
            return "OK";
        }else{
            return "FAIL";
        }
    }

}
