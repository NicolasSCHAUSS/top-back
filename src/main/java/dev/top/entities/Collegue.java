package dev.top.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Collegue {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String pseudo;
    
    private String avatar;
    
    private Integer score;
    
    private String nom;
    
    private String prenom;
    
    private String email;
    
    private String adresse;

    public Collegue() {
    }

    public Collegue(String pseudo, String avatar, String nom, String prenom, String adresse) {
        this.pseudo = pseudo;
        this.avatar = avatar;
        this.score = 500;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = nom+"."+prenom+"@collegue.com";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String name) {
        this.pseudo = name;
    }

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
}
