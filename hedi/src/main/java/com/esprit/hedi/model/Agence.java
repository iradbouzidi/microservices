package com.esprit.hedi.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;

@Entity
@Table(name = "agences")
public class Agence implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_agence;
	
	@Column(name = "nom_agence")
    private String nom_agence;
	
	@Column(name = "pays")
    private String pays;
	
	@Column(name = "region")
    private String region;
	
	@Column(name = "adresse")
    private String adresse;
	
	@Column(name = "nb_voitures")
    private int nb_voitures;
	
	@Column(name = "tel_agence")
    private int tel_agence;
	
	@Column(name = "description_agence")
    private String description_agence;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "type_agence")
    private String type_agence;
	
	

	public Long getId() {
		return id_agence;
	}

	public void setId(Long id) {
		this.id_agence = id;
	}

	public String getNom() {
		return nom_agence;
	}

	public void setNom(String nom) {
		this.nom_agence = nom;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getNb_voitures() {
		return nb_voitures;
	}

	public void setNb_voitures(int nb_voitures) {
		this.nb_voitures = nb_voitures;
	}

	public int getTel() {
		return tel_agence;
	}

	public void setTel(int tel) {
		this.tel_agence = tel;
	}

	public String getDescription() {
		return description_agence;
	}

	public void setDescription(String description) {
		this.description_agence = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type_agence;
	}

	public void setType(String type) {
		this.type_agence = type;
	}
	
	

}
