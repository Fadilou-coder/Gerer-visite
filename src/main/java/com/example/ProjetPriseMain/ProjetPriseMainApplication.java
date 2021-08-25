package com.example.ProjetPriseMain;

import com.example.ProjetPriseMain.Service.Service;
import com.example.ProjetPriseMain.entities.*;
import com.example.ProjetPriseMain.repository.EmployeRepository;
import com.example.ProjetPriseMain.repository.VisiteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication
public class ProjetPriseMainApplication implements CommandLineRunner {

	@Autowired
	private Service service;

	@Autowired
	VisiteurRepository visiteurRepository;

	@Autowired
	EmployeRepository employeRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetPriseMainApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Calendar c = Calendar.getInstance();
		Calendar c1 = Calendar.getInstance();
		c.set(2017, 06, 24);
		c1.set(2027, 06, 23);


		service.saveUser(new AppUser(null, "admin", "passer", null));
		service.saveUser(new AppUser(null, "user", "passer", null));
		service.saveRole(new Role(null, "ADMIN"));
		service.saveRole(new Role(null, "USER"));

		service.addRoleToUser("admin", "ADMIN");
		service.addRoleToUser("user", "user");

		service.addEmp(new Employe(null, "employe1", "employe1", "employe@gmail.com", "771521713", "Emploi et Formation"));
		service.addEmp(new Employe(null, "employe2", "employe2", "employe1@gmail.com", "771234567", "Emploi et Formation"));

		service.addFormation(new Formation(null, "Cohorte SA", null));
		service.addFormation(new Formation(null, "OSC", null));
		service.addFormation(new Formation(null, "Hacking", null));

		service.addStage(new Stage(null, "Stage Pédagogique", null));
		service.addStage(new Stage(null, "OSC", null));

		service.addApp(new Apprenant(null, "zeumb", "zeumb", "1234567890990", c.getTime(), c1.getTime(), "dakar"));
		service.addApp(new Apprenant(null, "apprenant", "apprenant", "1234577890990", c.getTime(), c1.getTime(), "dakar"));
		service.addStagiaire(new Stagiaire(null, "Omar", "Faye", "1234567890180", c.getTime(), c1.getTime(), "dakar"));

		service.addForToApp("Cohorte SA", "123456789099");
		service.addForToApp("Cohorte SA", "1234577890990");

		service.addStageToStagiaire("Stage Pédagogique", "1234567890180");

		service.addTypeVisite(new TypeVisite(null, "Formation"));
		service.addTypeVisite(new TypeVisite(null, "Stage"));
		service.addTypeVisite(new TypeVisite(null, "Visite Fab lab"));
		service.addTypeVisite(new TypeVisite(null, "Rencontre"));



		service.addVisiteur(new Visiteur(null, "visiteur", "nomVisiteur", "1234567891980", c.getTime(), c1.getTime(), "dakar"));
		service.addVisite(new Visite(), "employe@gmail.com", "1234567890180", "Stage", "commentaires", null);
		service.addVisite(new Visite(), null, "1234577890990", "Formation", "commentaires", null);
		service.addVisite(new Visite(), null, "1234567890990", "Formation", "commentaires", null);
		service.addVisite(new Visite(), "employe1@gmail.com", "1234567891980", "Visite Fab Lab", "commentaires", null);

	}

}
