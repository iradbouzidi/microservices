package com.esprit.habib.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "flights")
public class Flight implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotNull
    @Size(max = 65)
    @Column(name = "type_flight")
    private String typeFlight;
    
    //@NotNull
    @Size(max = 65)
    @Column(name = "Air_company")
    private String airCompany;
    
    //@NotNull
    @Size(max = 65)
    @Column(name = "depart")
    private String depart;
    
    //@NotNull
    @Size(max = 65)
    @Column(name = "destination")
    private String destination;
    
    //@NotNull
    @Column(name = "nb_passenger")
    private Long nbPassenger;
    
    //@NotNull
    @Column(name = "price")
    private Float price;
    
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "service_id", nullable = false)
    @JsonBackReference
    private Service service;

    public Flight() {
		super();
	}
    


	public Flight(Long id, @Size(max = 65) String typeFlight, @Size(max = 65) String airCompany,
			@Size(max = 65) String depart, @Size(max = 65) String destination, Long nbPassenger, Float price,
			Service service) {
		super();
		this.id = id;
		this.typeFlight = typeFlight;
		this.airCompany = airCompany;
		this.depart = depart;
		this.destination = destination;
		this.nbPassenger = nbPassenger;
		this.price = price;
		this.service = service;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getAirCompany() {
		return airCompany;
	}


	public void setAirCompany(String airCompany) {
		this.airCompany = airCompany;
	}

	public String getTypeFlight() {
		return typeFlight;
	}

	public void setTypeFlight(String typeFlight) {
		this.typeFlight = typeFlight;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Long getNbPassenger() {
		return nbPassenger;
	}

	public void setNbPassenger(Long nbPassenger) {
		this.nbPassenger = nbPassenger;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
    
    
}
