package com.isamrs.backend.repository;

import com.isamrs.backend.model.Pharmacy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long>{
    Pharmacy findByName(String name);
    
}
