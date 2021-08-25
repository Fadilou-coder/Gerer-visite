package com.example.ProjetPriseMain.Service;

import com.example.ProjetPriseMain.entities.*;
import com.example.ProjetPriseMain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import javax.validation.constraints.Null;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class ServiceImpl implements Service {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ApprenantRepository apprenantRepository;

    @Autowired
    private StagiaireRepository stagiaireRepository;

    @Autowired
    private VisiteRepository visiteRepository;

    @Autowired
    private VisiteurRepository visiteurRepository;

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private FormationRepository formationRepository;

    @Autowired
    private StageRepository stageRepository;

    @Autowired
    private TypeVisiteRepository typeVisiteRepository;


    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");


    @Override
    public AppUser saveUser(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        Role role = roleRepository.findByRoleName(roleName);
        AppUser user = userRepository.findByUsername(username);
        user.getRoles().add(role);
    }

    @Override
    public Apprenant addApp(Apprenant app){ return apprenantRepository.save(app); }


    @Override
    public Stagiaire addStagiaire(Stagiaire stagiaire) {
        return stagiaireRepository.save(stagiaire);
    }

    @Override
    public TypeVisite addTypeVisite(TypeVisite typeVisite) {
        return typeVisiteRepository.save(typeVisite);
    }

    @Override
    public Stage addStage(Stage stage) {
        return stageRepository.save(stage);
    }

    @Override
    public Formation addFormation(Formation formation) {
        return formationRepository.save(formation);
    }


    @Override
    public Visite addVisite(Visite visite, String emp, String v, String type, String comments, String obj) throws ParseException {
        Visiteur visiteur = visiteurRepository.findByCNI(v);
        if (emp != null) {
            Employe employe = employeRepository.findByEmail(emp);
            visite.setEmploye(employe);
        }
        visite.setComments(comments);
        visite.setVisiteur(visiteur);

        visite.setTypeVisite(typeVisiteRepository.findByLibelle(type));
        if (obj != null){
            if (type == "Formation")
                addForToApp(obj, v);
            else if (type == "Stage")
                addStageToStagiaire(obj, v);
        }


        return visiteRepository.save(visite);
    }

    @Override
    public Visiteur addVisiteur(Visiteur visiteur) {
        return visiteurRepository.save(visiteur);
    }

    @Override
    public AppUser findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Employe addEmp(Employe emp) {
        return employeRepository.save(emp);
    }


    public Date date(String date) throws ParseException {
        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(date.substring(0, 4)), ( Integer.parseInt(date.substring(5, 7)) - 1), Integer.parseInt(date.substring(8, 10)));
        String dat = sdf.format(c.getTime());
        Date d = sdf.parse(dat);

        return d;
    }

    @Override
    public List<Visite> findByDateVisite(String date) {
        List<Visite> visites = (List<Visite>) visiteRepository.findAll();
        List<Visite> visitsByDate = new ArrayList<Visite>();
        for (Visite visite : visites) {
            if (date.equals(visite.getDateEntree().toString().substring(0, 10)))
                visitsByDate.add(visite);
        }
        return visitsByDate;
    }

    @Override
    public void addForToApp(String formation, String apprenant) {
        Apprenant app = apprenantRepository.findByCNI(apprenant);
        Formation form = formationRepository.findByLibelle(formation);
        form.getApprenants().add(app);
    }

    @Override
    public void addStageToStagiaire(String stage, String stagiaire) {
        Stage s = stageRepository.findByLibelle(stage);
        Stagiaire stagiaire1 = stagiaireRepository.findByCNI(stagiaire);
        s.getStagiaires().add(stagiaire1);
    }


}
