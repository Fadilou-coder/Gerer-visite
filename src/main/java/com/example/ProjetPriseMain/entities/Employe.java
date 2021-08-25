package com.example.ProjetPriseMain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Employe extends Personne {

    @Column(unique = true)
    private String email;
    private String telephone;
    private String service;

    public Employe(Long id, String prenom, String nom, String email, String telephone, String service) {
        super(id, prenom, nom);
        this.email = email;
        this.telephone = telephone;
        this.service = service;
    }
}
