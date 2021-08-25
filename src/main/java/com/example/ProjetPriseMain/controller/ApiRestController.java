package com.example.ProjetPriseMain.controller;

import com.example.ProjetPriseMain.Service.Service;
import com.example.ProjetPriseMain.entities.*;
import com.example.ProjetPriseMain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

@RestController
public class ApiRestController {
    @Autowired
    private Service service;

    @Autowired
    private VisiteRepository visiteRepository;

    @Autowired
    private VisiteurRepository visiteurRepository;

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private TypeVisiteRepository typeVisiteRepository;

    @Autowired
    private StageRepository stageRepository;

    @Autowired
    private FormationRepository formationRepository;


    @GetMapping("/employes")
    public List<Employe> employe(){ return employeRepository.findAll(); }

    @GetMapping("/stages")
    public List<Stage> stages(){ return stageRepository.findAll(); }

    @GetMapping("/formations")
    public List<Formation> formations(){ return formationRepository.findAll(); }

    @GetMapping("/typeVisites")
    public List<TypeVisite> typeVisites(){ return typeVisiteRepository.findAll(); }

    // recuperer un visiteur
    @GetMapping("/visiteurs/{cni}")
    public Visiteur visiteur(@PathVariable("cni") String cni) { return visiteurRepository.findByCNI(cni); }

    // les visites d'une date donnée
    @GetMapping("/visite/{date}")
    public List<Visite> visiteByDate(@PathVariable("date") String date
    ) throws ParseException {
        return service.findByDateVisite(date);
    }

    @GetMapping("/visites")
    public Page<Visite> visite(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<String> sortBy){
        return visiteRepository.findAll(PageRequest.of(
                page.orElse(0),
                2,
                Sort.Direction.ASC, sortBy.orElse("id")
        ));
    }

    // Ajouter une visite
    @PostMapping("/visite")
    public Visite visite(
            HttpServletResponse response,
            @RequestParam("cni") String cni,
            @RequestParam("prenom") String prenom,
            @RequestParam("nom") String nom,
            @RequestParam("dateDel") String del,
            @RequestParam("dateExp") String exp,
            @RequestParam("lieu") String lieu,
            @RequestParam(required = false, name = "stage") String stage,
            @RequestParam(required = false, name = "formation") String formation,
            @RequestParam(required = false, name = "email") String email,
            @RequestParam(required = false, name = "type") String type,
            @RequestParam(required = false, name = "comments") String comments

            ) throws IOException, ParseException {
        Visiteur visiteur = visiteurRepository.findByCNI(cni);
        if (visiteur == null){
            if (service.date(del).getTime() >= new Date().getTime() || ((service.date(exp).getTime() - service.date(del).getTime())/1000 != (10*365*24*3600 + 24*3600) && ((service.date(exp).getTime() - service.date(del).getTime())/1000 != 10*365*24*3600))) {
                response.getOutputStream().print("Verifier les Dates de delivrance et d'expiration");
                response.setStatus(400);
                return null;
            }
            if (stage != null){
                return service.addVisite(new Visite(), null, service.addStagiaire(new Stagiaire(null, prenom, nom, cni, service.date(del), service.date(exp), lieu)).getCNI(), type, comments, stage);
            }
            if (formation != null){
                return service.addVisite(new Visite(), null, service.addApp(new Apprenant(null, prenom, nom, cni, service.date(del), service.date(exp), lieu)).getCNI(), type, comments, formation);
            }
            return service.addVisite(new Visite(), email, service.addVisiteur(new Visiteur(null, prenom, nom, cni, service.date(del), service.date(exp), lieu)).getCNI(), type, comments, null);
        }
        return service.addVisite(new Visite(), email, cni, type, comments, null);
    }

    //Lister les visites d'un visiteur
    @GetMapping("/visiteur/{cni}/visites")
    public Page<Visite> visiteByvisiteur(@PathVariable("cni") String cni,
                                         @RequestParam Optional<Integer> page,
                                         @RequestParam Optional<String> sortBy){
        return visiteRepository.findByVisiteur(visiteurRepository.findByCNI(cni), PageRequest.of(
                        page.orElse(0),
                        2,
                        Sort.Direction.ASC, sortBy.orElse("id")
                )
        );
    }

    // Date de Sortie
    @PutMapping("/visite/{id}")
    public Optional<Visite> sortir(@PathVariable("id") Long id){
        Optional<Visite> v = visiteRepository.findById(id);
        v.get().setDateSortie(new Date());
        return v;
    }




}
