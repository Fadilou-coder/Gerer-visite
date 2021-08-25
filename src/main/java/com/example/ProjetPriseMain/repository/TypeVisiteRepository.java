package com.example.ProjetPriseMain.repository;

import com.example.ProjetPriseMain.entities.TypeVisite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeVisiteRepository extends JpaRepository<TypeVisite, Long> {
    TypeVisite findByLibelle(String libelle);
}
