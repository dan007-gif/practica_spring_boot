package com.ejemplo.festivos.service;

import com.ejemplo.festivos.model.Festivo;
import com.ejemplo.festivos.repository.FestivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Service
public class FestivoService {

    @Autowired
    private FestivoRepository festivoRepository;

    public boolean esFestivo(int anio, int mes, int dia) {
        LocalDate fecha = null;
        try {
            fecha = LocalDate.of(anio, mes, dia);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        List<Festivo> festivos = festivoRepository.findAll();

        for (Festivo festivo : festivos) {
            int tipo = festivo.getTipo().getId();

            if (tipo == 1) {
                if (festivo.getDia() == dia && festivo.getMes() == mes) {
                    return true;
                }
            }

            if (tipo == 2) {
                LocalDate festivoFecha = LocalDate.of(anio, festivo.getMes(), festivo.getDia());
                LocalDate lunes = siguienteLunes(festivoFecha);
                if (fecha.equals(lunes)) {
                    return true;
                }
            }

            if (tipo == 3) {
                LocalDate pascua = getDomingoPascua(anio);
                LocalDate festivoFecha = pascua.plusDays(festivo.getDiasPascua());
                if (fecha.equals(festivoFecha)) {
                    return true;
                }
            }

            if (tipo == 4) {
                LocalDate pascua = getDomingoPascua(anio);
                LocalDate festivoFecha = pascua.plusDays(festivo.getDiasPascua());
                LocalDate lunes = siguienteLunes(festivoFecha);
                if (fecha.equals(lunes)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static LocalDate getDomingoPascua(int año) {
        int a = año % 19;
        int b = año % 4;
        int c = año % 7;
        int d = (19 * a + 24) % 30;
        int dias = d + (2 * b + 4 * c + 6 * d + 5) % 7;
        int dia = 15 + dias;
        int mes = 3;
        if (dia > 31) {
            dia -= 31;
            mes = 4;
        }
        return LocalDate.of(año, mes, dia);
    }

    public static LocalDate siguienteLunes(LocalDate fecha) {
        if (fecha.getDayOfWeek() != DayOfWeek.MONDAY) {
            int diasParaLunes = 8 - fecha.getDayOfWeek().getValue();
            return fecha.plusDays(diasParaLunes);
        }
        return fecha;
    }
}