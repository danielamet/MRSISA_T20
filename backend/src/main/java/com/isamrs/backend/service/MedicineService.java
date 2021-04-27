package com.isamrs.backend.service;

import java.util.List;

import com.isamrs.backend.model.Medicine;
import com.isamrs.backend.repository.MedicineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {
    
    @Autowired
    MedicineRepository medicineRepository;

    public List<Medicine> findAll(){
        return medicineRepository.findAll();
    }

    public Medicine findById(Long id){
        return medicineRepository.findById(id).orElse(null);
    }

    public Medicine findByName(String name){
        return medicineRepository.findByName(name);
    }

    public Medicine save(Medicine medicine) throws Exception{
        //Medicine m = getOne(medicine.getId());
        if (findById(medicine.getId()) == null) {
            return medicineRepository.save(medicine);
        } else {
            throw new Exception("Medicine with the same ID already exists");
        }

    }
}
