package com.example.ProjetPriseMain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Visite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateEntree = new Date();
    private Date dateSortie;

    private String comments;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id")
    private Employe employe;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "visiteur_id")
    private Visiteur visiteur;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "typeVisite_id")
    private TypeVisite typeVisite;


}
