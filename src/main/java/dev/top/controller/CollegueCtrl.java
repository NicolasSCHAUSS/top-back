package dev.top.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.top.entities.Action;
import dev.top.entities.Action.Avis;
import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;

@CrossOrigin
@RestController()
@RequestMapping("/collegues")
public class CollegueCtrl {

	@Autowired
    private CollegueRepo collegueRepo;

    @GetMapping
    public List<Collegue> findAll() {
        return this.collegueRepo.findAll();
    }
    
    @GetMapping("/{pseudo}")
    public Collegue findCollegue(@PathVariable String pseudo) {
    	Collegue cRequested = this.collegueRepo.findByPseudo(pseudo);
    	return cRequested;
    }
    
    @PatchMapping("/{pseudo}")
    public Collegue updateScore(@PathVariable String pseudo, @RequestBody Action a) {
    	Collegue cRequested = this.collegueRepo.findByPseudo(pseudo);
    	
    	if(a.getAction() == Avis.AIMER) {
    		cRequested.setScore(cRequested.getScore()+10);
    	}
    	else {
    		cRequested.setScore(cRequested.getScore()-5);
    	}
    	this.collegueRepo.save(cRequested);
    	
    	return cRequested;
    }
}
