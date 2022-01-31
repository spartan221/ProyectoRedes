package com.sistemaPreventivo.ProyectoRedes.controllers;


import com.sistemaPreventivo.ProyectoRedes.models.ComentarioDto;
import com.sistemaPreventivo.ProyectoRedes.models.QueryReporteDto;
import com.sistemaPreventivo.ProyectoRedes.models.ReporteDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String goToLogin(){
        return "login";
    }

    @RequestMapping(value = "/consulta", method = RequestMethod.GET)
    public String goToConsulta(Model model){
        model.addAttribute("query", new QueryReporteDto());
        return "consulta";
    }

    @RequestMapping(value = "/reporte", method = RequestMethod.GET)
    public String goToReporte(Model model){
        model.addAttribute("reporte", new ReporteDto());
        return "reporte";
    }

    @RequestMapping(value = "/comentario", method = RequestMethod.GET)
    public String goToComentario(Model model){
        model.addAttribute("comentario", new ComentarioDto());
        return "comentario";
    }

    @RequestMapping(value = "/login-error", method = RequestMethod.GET)
    public String goToLoginWithErrors(Model model){
        model.addAttribute("message", "Ha ocurrido un error, sus credenciales son incorrectas");
        return "login";
    }

}
