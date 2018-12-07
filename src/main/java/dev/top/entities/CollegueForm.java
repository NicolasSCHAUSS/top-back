package dev.top.entities;

public class CollegueForm {

	private String matricule;
	private String pseudo;
	private String urlImage;
	
	public CollegueForm() {
		
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String imgURL) {
		this.urlImage = imgURL;
	}
}
