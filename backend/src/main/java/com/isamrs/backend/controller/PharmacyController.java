package com.isamrs.backend.controller;

import java.util.ArrayList;
import java.util.List;

import com.isamrs.backend.dto.PharmacyDTO;
import com.isamrs.backend.model.Pharmacy;
import com.isamrs.backend.service.PharmacyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="api/pharmacy")
public class PharmacyController {

    @Autowired
    PharmacyService pharmacyService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<PharmacyDTO>> getAllPharmacy(){
        List<Pharmacy> p = pharmacyService.findAll();
        List<PharmacyDTO> pDTOs = new ArrayList<>();

        for (Pharmacy phar : p) {
            PharmacyDTO novi = new PharmacyDTO(phar);
            pDTOs.add(novi);
        }

        return new ResponseEntity<>(pDTOs, HttpStatus.OK);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<PharmacyDTO> getPharmacy(@PathVariable String name){
        Pharmacy p = pharmacyService.findByName(name);

        if (p == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        PharmacyDTO pDTO = new PharmacyDTO(p.getId(), p.getName(), p.getAddress(),p.getDescription(), p.getDermatologists(), p.getPharmacists(), p.getMedicines());
        return new ResponseEntity<>(pDTO, HttpStatus.OK);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<PharmacyDTO> createPharmacy(@RequestBody PharmacyDTO pDTO){
        Pharmacy p = new Pharmacy();
        try {
            p.setId(pDTO.getId());
            p.setName(pDTO.getName());
            p.setAddress(pDTO.getAddress());
            p.setDescription(pDTO.getDescription());
            p.setDermatologists(pDTO.getDermatologists());
            p.setPharmacists(pDTO.getPharmacists());
            p.setMedicines(pDTO.getMedicines());
            
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(pDTO, HttpStatus.CREATED);
    }
    
}
