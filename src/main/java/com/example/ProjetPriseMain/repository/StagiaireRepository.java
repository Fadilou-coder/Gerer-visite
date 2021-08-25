package com.example.ProjetPriseMain.repository;

import com.example.ProjetPriseMain.entities.Stagiaire;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StagiaireRepository extends PagingAndSortingRepository<Stagiaire, Long> {
    public Stagiaire findByCNI(String CNI);

}
