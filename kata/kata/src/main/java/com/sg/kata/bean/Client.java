package com.sg.kata.bean;

public class Client {

	String referenceClient ;
	String nom ;
	String prenom ;
	// on peut rajouter adresse et autres mais pour l'exercice,on fait au plus simple
	
	
	public String getReferenceClient() {
		return referenceClient;
	}

	public void setReferenceClient(String referenceClient) {
		this.referenceClient = referenceClient;
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

	

	
	
}
