package com.example.ProjetPriseMain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Employe extends Personne {

    @Column(unique = true)
    @NotNull
    private String email;
    @NotNull
    private String telephone;
    @NotNull
    private String service;

    public Employe(Long id, String prenom, String nom, @NotNull String email, @NotNull String telephone, @NotNull String service) {
        super(id, prenom, nom);
        this.email = email;
        this.telephone = telephone;
        this.service = service;
    }
}
