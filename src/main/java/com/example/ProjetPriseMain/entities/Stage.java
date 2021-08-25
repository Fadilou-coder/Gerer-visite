package com.example.ProjetPriseMain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stage {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String libelle;

    @ManyToMany(cascade = CascadeType.ALL)
    @RestResource(exported = false)
    private List<Stagiaire> stagiaires;
}
