package dev.top.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import dev.top.entities.Action;
import dev.top.entities.Action.Avis;
import dev.top.entities.Collegue;
import dev.top.entities.CollegueForm;
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
    
    @PostMapping
    public Collegue addCollegue(@RequestBody CollegueForm form) {
    	RestTemplate rt = new RestTemplate();
    	Collegue[] result = rt.getForObject("http://collegues-api.cleverapps.io/collegues?matricule="+form.getMatricule(), Collegue[].class);
    	Collegue c = null;
    	
		if ( result.length > 0) {
			c = new Collegue();
			c.setAdresse(result[0].getAdresse());
			c.setPseudo(form.getPseudo());
			if(form.getUrlImage() == null)
				c.setPhoto(result[0].getPhoto());
			else
				c.setPhoto(form.getUrlImage());
			c.setScore(500);
			c.setNom(result[0].getNom());
			c.setPrenom(result[0].getPrenom());
			c.setEmail(result[0].getEmail());
			
			this.collegueRepo.save(c);
		}
    	
    	return c;
    }
}
