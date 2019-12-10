package com.esprit.hedi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "commande")
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_commande;
	
	@Column(name = "type_service")
	private String type_service;
	
	@Column(name = "nbr_personne")
	private int nbr_personne;
	
	@Column(name = "prix_personne")
	private float prix_personne;
	
	@Column(name = "totale")
	private float totale;
	
	
	public int getId_commande() {
		return id_commande;
	}
	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}
	public String getType_service() {
		return type_service;
	}
	public void setType_service(String type_service) {
		this.type_service = type_service;
	}
	public int getNbr_personne() {
		return nbr_personne;
	}
	public void setNbr_personne(int nbr_personne) {
		this.nbr_personne = nbr_personne;
	}
	public float getPrix_personne() {
		return prix_personne;
	}
	public void setPrix_personne(float prix_personne) {
		this.prix_personne = prix_personne;
	}
	public float getTotale() {
		return totale;
	}
	public void setTotale(float totale) {
		this.totale = totale;
	}
	
	public Commande() {
		super();
	}
	
	public Commande(String type_service, int nbr_personne, float prix_personne, float totale) {
		super();
		this.type_service = type_service;
		this.nbr_personne = nbr_personne;
		this.prix_personne = prix_personne;
		this.totale = totale;
	}
	
	public Commande(int id_commande, String type_service, int nbr_personne, float prix_personne, float totale) {
		super();
		this.id_commande = id_commande;
		this.type_service = type_service;
		this.nbr_personne = nbr_personne;
		this.prix_personne = prix_personne;
		this.totale = totale;
	}
	
	
}
