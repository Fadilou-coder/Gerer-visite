package com.example.ProjetPriseMain.repository;

import com.example.ProjetPriseMain.entities.Personne;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonneRepository extends PagingAndSortingRepository<Personne, Long> {

}
