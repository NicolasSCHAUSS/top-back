package dev.top.entities;

public class Action {
	
	public enum Avis {
		AIMER,
		DETESTER
	}
	
	public Action() {
		
	}
	
	private Avis action;
	

	public Avis getAction() {
		return action;
	}

	public void setAction(Avis avis) {
		this.action = avis;
	}
	
}
