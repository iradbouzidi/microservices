package com.esprit.habib.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "hotels")
public class Hotel implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotNull
    @Size(max = 65)
    @Column(name = "type_hotel")
    private String typeHotel;
    
  //@NotNull
    @Size(max = 150)
    @Column(name = "description")
    private String description;
    
    // @NotNull
    @Column(name = "nb_Star")
    private Long nbStars;
    
    //@NotNull
    @Size(max = 100)
    @Column(name = "address")
    private String address;
    
   // @NotNull
    @Column(name = "nb_room")
    private Long nbRoom;
    
    //@NotNull
    @Column(name = "nb_resident")
    private Long nbResident;
    
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "service_id", nullable = false)
    @JsonBackReference
    private Service service;

	public Hotel() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeHotel() {
		return typeHotel;
	}

	public void setTypeHotel(String typeHotel) {
		this.typeHotel = typeHotel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getNbRoom() {
		return nbRoom;
	}

	public void setNbRoom(Long nbRoom) {
		this.nbRoom = nbRoom;
	}

	public Long getNbResident() {
		return nbResident;
	}

	public void setNbResident(Long nbResident) {
		this.nbResident = nbResident;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Hotel(Long id, @Size(max = 65) String typeHotel, @Size(max = 150) String description, Long nbStars,
			@Size(max = 100) String address, Long nbRoom, Long nbResident, Service service) {
		super();
		this.id = id;
		this.typeHotel = typeHotel;
		this.description = description;
		this.nbStars = nbStars;
		this.address = address;
		this.nbRoom = nbRoom;
		this.nbResident = nbResident;
		this.service = service;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getNbStars() {
		return nbStars;
	}

	public void setNbStars(Long nbStars) {
		this.nbStars = nbStars;
	}

    
}
