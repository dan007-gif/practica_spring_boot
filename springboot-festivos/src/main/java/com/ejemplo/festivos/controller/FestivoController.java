package com.ejemplo.festivos.controller;

import com.ejemplo.festivos.service.FestivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDate;

@RestController
@RequestMapping("/festivos")
@CrossOrigin(origins = "http://localhost:4200")
public class FestivoController {

    @Autowired
    private FestivoService festivoService;

    @GetMapping("/verificar/{año}/{mes}/{dia}")
    public String verificarFestivo(@PathVariable("año") int anio, @PathVariable int mes, @PathVariable int dia) {
        try {
            LocalDate.of(anio, mes, dia);
        } catch (Exception e) {
            return "Fecha no valida";
        }
        boolean esFestivo = festivoService.esFestivo(anio, mes, dia);
        return esFestivo ? "Es festivo" : "No es festivo";
    }
    @GetMapping("/obtener/{año}")
    public List<java.util.Map<String, String>> obtenerFestivos(@PathVariable("año") int anio) {
        return festivoService.obtenerFestivos(anio);
    }
}
