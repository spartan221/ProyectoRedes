package com.sistemaPreventivo.ProyectoRedes.controllers;

import com.sistemaPreventivo.ProyectoRedes.models.Usuario;
import com.sistemaPreventivo.ProyectoRedes.models.UsuarioDto;
import com.sistemaPreventivo.ProyectoRedes.service.UsuarioService;
import com.sistemaPreventivo.ProyectoRedes.utils.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;


@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;



    @GetMapping("/register")
    public String showRegistrationForm(WebRequest request, Model model){
        UsuarioDto usuarioDto = new UsuarioDto();
        model.addAttribute("usuario", usuarioDto);
        return "registro";
    }

    @PostMapping("/register")
    public String registerUserAccount(@Valid @ModelAttribute("usuario") UsuarioDto usuarioDto,
            BindingResult result, Model model )  {

        System.out.println("result = " + result.hasErrors());

        if (!result.hasErrors()) {

            try {
                Usuario registered = usuarioService.registerNewUserAccount(usuarioDto);
                return "redirect:login";
            } catch (UserAlreadyExistException e) {
                model.addAttribute("mensaje", e.getMessage());
                return "registro";
            }

        }
        return "registro";
    }

}
