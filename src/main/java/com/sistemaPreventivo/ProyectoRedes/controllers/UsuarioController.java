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
        // Ingresa algo diferente a un numero telef??nico para buscar
        return "consulta";

    }


    @RequestMapping(value = "/reporte", method = RequestMethod.POST)
    public String makeReport(@Valid @ModelAttribute("reporte") ReporteDto reporteDto, BindingResult result, Model model){
        if (!result.hasErrors()){

            try {
                // Existe un reporte con ese numero telef??nico
                Reporte reporte = reporteService.consultarReporte(Long.parseLong(reporteDto.getNumeroTelefonico()));
                model.addAttribute("mensajeError", "Ya existe un reporte con el n??mero telef??nico: " + reporteDto.getNumeroTelefonico()
                + " Por favor, dir??jase a la secci??n de realizar comentario y escr??belo all??");
                return "reporte";
            }catch (ReporteDoesntExists e){
                reporteService.saveReporte(reporteDto);
                model.addAttribute("mensajeSuccess", "Se ha realizado correctamente el reporte");
                return "reporte";
            }


        }
        return "reporte";

    }

    @RequestMapping(value = "/comentario", method = RequestMethod.POST)
    public String makeComment(@Valid @ModelAttribute("comentario") ComentarioDto comentarioDto, BindingResult result, Model model){
        if (!result.hasErrors()){

            try {
                // Existe un reporte con ese numero telef??nico
                Reporte reporte = reporteService.consultarReporte(Long.parseLong(comentarioDto.getNumeroTelefonico()));
                usuarioService.makeComment(reporte, comentarioDto);
                model.addAttribute("mensajeSuccess", "El comentario se ha realizado correctamente sobre" +
                        " el n??mero telef??nico: " + comentarioDto.getNumeroTelefonico());
                return "comentario";
            }catch (ReporteDoesntExists e){
                model.addAttribute("mensajeError", "No existe un reporte con el n??mero telef??nico: "
                + comentarioDto.getNumeroTelefonico() + " .Por favor, realiza el reporte de este n??mero");
                return "comentario";
            }


        }
        return "comentario";

    }



}
