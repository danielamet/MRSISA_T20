package com.isamrs.backend.dto;

import java.util.List;
import java.io.Serializable;

import lombok.NoArgsConstructor;
import com.isamrs.backend.model.Pharmacy;

@NoArgsConstructor
public class PharmacyDTO implements Serializable {

    private Long id;
    private String name;
    private String address;
    private String description;

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
