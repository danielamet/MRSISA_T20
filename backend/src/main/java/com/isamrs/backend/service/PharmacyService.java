package com.isamrs.backend.service;

import java.util.List;

import com.isamrs.backend.model.Pharmacy;
import com.isamrs.backend.repository.PharmacyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacyService {

    @Autowired
    PharmacyRepository pharmacyRepository;

    public List<Pharmacy> findAll(){
        return pharmacyRepository.findAll();
    }

    public Pharmacy findById(Long id){
        return pharmacyRepository.findById(id).orElse(null);
    }

    public Pharmacy findByName(String name){
        return pharmacyRepository.findByName(name);
    }

    public Pharmacy save(Pharmacy pharmacy) throws Exception{
        if (findById(pharmacy.getId()) == null) {
            return pharmacyRepository.save(pharmacy);
        } else {
            throw new Exception("Pharmacy with the same ID already exists!");
        }

    }
    
}
