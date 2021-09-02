package com.isamrs.backend.dto;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

import lombok.NoArgsConstructor;

import com.isamrs.backend.model.Medicine;
import com.isamrs.backend.model.Pharmacy;
import com.isamrs.backend.model.User;

@NoArgsConstructor
public class PharmacyDTO implements Serializable {

    private Long id;
    private String name;
    private String address;
    private String description;
    private List<User> dermatologists;
    private List<User> pharmacists;
    private List<Medicine> medicines;

    public PharmacyDTO(Long id, String name, String address, String description){
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
    }

    public PharmacyDTO(Long id, String name, String address, String description, List<User> dermatologists, List<User> pharmacists, List<Medicine> medicines){
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.dermatologists = dermatologists;
        this.pharmacists = pharmacists;
        this.medicines = medicines;
    }

    public PharmacyDTO(Pharmacy p){
        this.id = p.getId();
        this.name = p.getName();
        this.address = p.getAddress();
        this.description = p.getDescription();
        this.dermatologists = p.getDermatologists();
        this.pharmacists = p.getPharmacists();
        this.medicines = p.getMedicines();
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
