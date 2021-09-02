package com.isamrs.backend.model;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "pharmacy")
public class Pharmacy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", unique=true, nullable = false)
	private String name;

    @Column(name="address", unique=true, nullable = false)
	private String address;

    @Column(name="description", nullable = false)
	private String description;
    
    //TODO: Dodati cenovnik lekova i pregleda
    @OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<User> dermatologists;

    @OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<User> pharmacists;

    @OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Medicine> medicines;

    public Pharmacy(){

    }

    public Pharmacy(Long id, String name, String address, String description){
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
    }

    public Pharmacy(Long id, String name, String address, String description, List<User> dermatologists, List<User> pharmacists, List<Medicine> medicines){
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.dermatologists = dermatologists;
        this.pharmacists = pharmacists;
        this.medicines = medicines;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getDermatologists() {
		return dermatologists;
	}

	public void setDermatologists(List<User> dermatologists) {
		this.dermatologists = dermatologists;
	}

    public List<User> getPharmacists() {
		return pharmacists;
	}

	public void setPharmacists(List<User> pharmacists) {
		this.pharmacists = pharmacists;
	}

    public List<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}
}
