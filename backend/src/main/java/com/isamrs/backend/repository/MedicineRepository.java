package com.isamrs.backend.repository;

import com.isamrs.backend.model.Medicine;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long>{
    Medicine findByName(String name);
}
