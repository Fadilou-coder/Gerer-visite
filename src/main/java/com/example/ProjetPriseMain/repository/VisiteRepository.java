package com.example.ProjetPriseMain.repository;

import com.example.ProjetPriseMain.entities.Visite;
import com.example.ProjetPriseMain.entities.Visiteur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

public interface VisiteRepository extends PagingAndSortingRepository<Visite, Long> {
    Page<Visite> findByDateEntree(Date date, Pageable pageable);

    Page<Visite> findByVisiteur(Visiteur visiteur, Pageable pageable);
}
