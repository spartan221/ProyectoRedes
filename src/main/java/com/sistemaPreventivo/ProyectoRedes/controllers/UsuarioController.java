package com.sistemaPreventivo.ProyectoRedes.controllers;

import com.sistemaPreventivo.ProyectoRedes.models.*;
import com.sistemaPreventivo.ProyectoRedes.service.ReporteService;
import com.sistemaPreventivo.ProyectoRedes.service.UsuarioService;
import com.sistemaPreventivo.ProyectoRedes.utils.ReporteDoesntExists;
import com.sistemaPreventivo.ProyectoRedes.utils.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;


@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ReporteService reporteService;



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

    @RequestMapping(value = "/consulta", method = RequestMethod.POST)
    public String consultaNumeroTelefonico(@Valid @ModelAttribute("query") QueryReporteDto queryReporteDto, BindingResult result, Model model){
        if (!result.hasErrors()){

            try {
                Reporte reporte = reporteService.consultarReporte(Long.parseLong(queryReporteDto.getNumeroTelefonico()));
                model.addAttribute("reporte", reporte);
                return "consulta";
            }catch (ReporteDoesntExists e){
                model.addAttribute("mensaje", e.getMessage());
                return "consulta";
            }


        }
        // Ingresa algo diferente a un numero telefónico para buscar
        return "consulta";

    }



}
