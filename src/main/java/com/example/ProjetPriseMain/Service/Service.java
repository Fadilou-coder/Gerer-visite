package com.example.ProjetPriseMain.Service;

import com.example.ProjetPriseMain.entities.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface Service {
    public AppUser saveUser(AppUser user);
    public Role saveRole(Role role);
    public void addRoleToUser(String username, String roleName);
    public AppUser findUserByUsername(String username);

    public Employe addEmp(Employe emp);

    public Apprenant addApp(Apprenant apprenant);

    public Stagiaire addStagiaire(Stagiaire stagiaire);

    public TypeVisite addTypeVisite(TypeVisite typeVisite);

    public Stage addStage(Stage stage);

    public Formation addFormation(Formation formation);



    public Visite addVisite(Visite visite, String emp, String v, String type, String comments, String obj) throws ParseException;
    public Visiteur addVisiteur(Visiteur visiteur);

    public Date date(String d) throws ParseException;

    List<Visite> findByDateVisite(String date);

    public void addForToApp(String formation, String apprenant);

    public void addStageToStagiaire(String stage, String stagiaire);
}
