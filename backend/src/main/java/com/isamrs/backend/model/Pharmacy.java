package com.isamrs.backend.model;

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
    
    //TODO: Dodati listu dermatologa, listu farmaceuta, lekove, cenovnik lekova i pregleda


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
}
