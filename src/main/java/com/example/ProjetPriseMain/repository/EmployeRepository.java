package com.example.ProjetPriseMain.repository;

import com.example.ProjetPriseMain.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
    public Employe findByEmail(String email);
}
