package com.example.ProjetPriseMain.repository;

import com.example.ProjetPriseMain.entities.Apprenant;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApprenantRepository extends PagingAndSortingRepository<Apprenant, Long> {
    public Apprenant findByCNI(String CNI);
}
