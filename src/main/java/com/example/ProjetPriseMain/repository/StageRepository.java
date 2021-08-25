package com.example.ProjetPriseMain.repository;

import com.example.ProjetPriseMain.entities.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StageRepository extends JpaRepository<Stage, Long> {
    public Stage findByLibelle(String libelle);
}
