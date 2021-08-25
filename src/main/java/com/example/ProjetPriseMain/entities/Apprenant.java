package com.example.ProjetPriseMain.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @NoArgsConstructor
public class Apprenant extends Visiteur{

    public Apprenant(Long id, String prenom, String nom, String CNI, Date dateDel, Date dateExp, String lieu) {
        super(id, prenom, nom, CNI, dateDel, dateExp, lieu);
    }
}
