package com.ejemplo.festivos.controller;

import com.ejemplo.festivos.service.FestivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @Autowired
    private FestivoService festivoService;

    @GetMapping("/")
    public String formulario() {
        return "consulta";
    }

    @PostMapping("/consultar")
    public String consultar(
            @RequestParam String fecha,
            Model model) {
        String[] partes = fecha.split("-");
        int anio = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int dia = Integer.parseInt(partes[2]);
        boolean esFestivo = festivoService.esFestivo(anio, mes, dia);
        model.addAttribute("esFestivo", esFestivo);
        model.addAttribute("anio", anio);
        model.addAttribute("mes", mes);
        model.addAttribute("dia", dia);
        return "consulta";
    }
}