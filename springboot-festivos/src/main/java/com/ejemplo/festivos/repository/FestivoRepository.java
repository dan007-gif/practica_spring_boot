package com.ejemplo.festivos.repository;

import com.ejemplo.festivos.model.Festivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FestivoRepository extends JpaRepository<Festivo, Integer> {
}
