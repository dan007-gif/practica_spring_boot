package com.ejemplo.festivos.controller;

import com.ejemplo.festivos.service.FestivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/festivos")
public class FestivoController {

    @Autowired
    private FestivoService festivoService;

    @GetMapping("/verificar/{año}/{mes}/{dia}")
    public String verificarFestivo(@PathVariable int anio, @PathVariable int mes, @PathVariable int dia) {
        if (mes < 1 || mes > 12 || dia < 1 || dia > 31) {
            return "Fecha no valida";
        }
        boolean esFestivo = festivoService.esFestivo(anio, mes, dia);
        return esFestivo ? "Es festivo" : "No es festivo";
    }
}
