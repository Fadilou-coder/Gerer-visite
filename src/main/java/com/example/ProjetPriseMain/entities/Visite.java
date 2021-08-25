package com.example.ProjetPriseMain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Visite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern="dd-MM-yyyy hh:MM")
    private Date dateEntree = new Date();
    @JsonFormat(pattern="dd-MM-yyyy hh:MM")
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
