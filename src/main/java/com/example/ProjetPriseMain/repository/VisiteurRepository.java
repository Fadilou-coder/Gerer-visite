package com.example.ProjetPriseMain.repository;

import com.example.ProjetPriseMain.entities.Visiteur;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface VisiteurRepository extends JpaRepository<Visiteur, Long> {
    public Visiteur findByCNI(String CNI);
    @NotNull
    Optional<Visiteur> findById(@NotNull Long id);
}
