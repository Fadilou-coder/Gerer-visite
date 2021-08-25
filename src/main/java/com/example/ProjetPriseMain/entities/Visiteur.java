package com.example.ProjetPriseMain.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("visiteur")
public class Visiteur extends Personne {

    @Column(unique = true)
    private String CNI;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateDel;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateExp;
    private String Lieu;


    public Visiteur(Long id, String prenom, String nom, String CNI, Date dateDel, Date dateExp, String lieu) {
        super(id, prenom, nom);
        this.CNI = CNI;
        this.dateDel = dateDel;
        this.dateExp = dateExp;
        Lieu = lieu;
    }



}
