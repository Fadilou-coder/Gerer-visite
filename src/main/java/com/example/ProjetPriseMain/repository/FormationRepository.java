package com.example.ProjetPriseMain.repository;

import com.example.ProjetPriseMain.entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FormationRepository extends JpaRepository<Formation, Long> {
    public Formation findByLibelle(String libelle);
}
