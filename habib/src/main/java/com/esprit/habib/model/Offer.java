package com.esprit.habib.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "offers")
public class Offer implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	//@NotNull
    @Size(max = 65)
    @Column(name = "type_offer")
    private String typeOffer;
    
  //@NotNull
    @Size(max = 150)
    @Column(name = "description")
    private String description;
	
	//@NotNull
    @Size(max = 65)
    @Column(name = "period_offer")
    private String periodOffer;
	
    
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "service_id", nullable = false)
    @JsonBackReference
    private Service service;


    public Offer() {
    	super();
	}
    
	


	public Offer(Long id, @Size(max = 65) String typeOffer, @Size(max = 150) String description,
			@Size(max = 65) String periodOffer, Service service) {
		super();
		this.id = id;
		this.typeOffer = typeOffer;
		this.description = description;
		this.periodOffer = periodOffer;
		this.service = service;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTypeOffer() {
		return typeOffer;
	}


	public void setTypeOffer(String typeOffer) {
		this.typeOffer = typeOffer;
	}


	public String getPeriodOffer() {
		return periodOffer;
	}


	public void setPeriodOffer(String periodOffer) {
		this.periodOffer = periodOffer;
	}


	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
	}
    
    

}
