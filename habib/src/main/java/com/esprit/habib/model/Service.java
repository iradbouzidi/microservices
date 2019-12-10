package com.esprit.habib.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "services")
@EntityListeners(AuditingEntityListener.class)
public class Service implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Size(max = 150)
    @Column(name = "description")
    private String description;
	
	@Temporal(TemporalType.DATE)
    @Column(name = "dos")
    private Date dateOfStart;
	
	@Temporal(TemporalType.DATE)
    @Column(name = "doe")
    private Date dateOfEnd;
	
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "service")
    private Flight flight;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "service")
    private Hotel hotel;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "service")
    private Offer offer;

	public Service() {

	}

	public Service(Long id, @Size(max = 150) String description, Date dateOfStart, Date dateOfEnd, Flight flight,
			Hotel hotel, Offer offer) {
		super();
		this.id = id;
		this.description = description;
		this.dateOfStart = dateOfStart;
		this.dateOfEnd = dateOfEnd;
		this.flight = flight;
		this.hotel = hotel;
		this.offer = offer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateOfStart() {
		return dateOfStart;
	}

	public void setDateOfStart(Date dateOfStart) {
		this.dateOfStart = dateOfStart;
	}

	public Date getDateOfEnd() {
		return dateOfEnd;
	}

	public void setDateOfEnd(Date dateOfEnd) {
		this.dateOfEnd = dateOfEnd;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

}
