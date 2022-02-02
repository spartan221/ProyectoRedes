package com.sistemaPreventivo.ProyectoRedes.controllers;


import com.sistemaPreventivo.ProyectoRedes.models.Comentario;
import com.sistemaPreventivo.ProyectoRedes.models.ComentarioDto;
import com.sistemaPreventivo.ProyectoRedes.models.QueryReporteDto;
import com.sistemaPreventivo.ProyectoRedes.models.ReporteDto;
import com.sistemaPreventivo.ProyectoRedes.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UrlController {

    @Autowired
    ComentarioService comentarioService;


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

    @RequestMapping(value = "/getestadisticas1", method = RequestMethod.GET)
    @ResponseBody
    public List<Object[]> getEstadisticas1(){
        // Cada posicion de la lista, tiene una sublista. Cada sublista es sublista[0] -> numeroTelefonico(id_reporte) y sublista[1] numero de comentarios
        List<Object[]> result = comentarioService.getTop5NumerosReportadosByNumberOfComments();
        return result;
    }

    @RequestMapping(value = "/getestadisticas2", method = RequestMethod.GET)
    @ResponseBody
    public List<Comentario> getEstadisticas2(){
        List<Comentario> comentarios = comentarioService.getTop5NumerosReportadosRecent();
        return comentarios;
    }


    @RequestMapping(value = "/estadisticas", method = RequestMethod.GET)
    public String goToEstadisticas(Model model){
        model.addAttribute("comentarios", getEstadisticas2());
        return "estadisticas";
    }
}
