package com.example.ProjetPriseMain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Formation {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String libelle;


    @ManyToMany(cascade = CascadeType.ALL)
    List<Apprenant> apprenants;

}
