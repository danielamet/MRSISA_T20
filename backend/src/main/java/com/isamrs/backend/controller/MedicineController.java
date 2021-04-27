package com.isamrs.backend.controller;

import java.util.ArrayList;
import java.util.List;

import com.isamrs.backend.dto.MedicineDTO;
import com.isamrs.backend.model.Medicine;
import com.isamrs.backend.service.MedicineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="api/medicine")
public class MedicineController {

    @Autowired
    MedicineService medicineService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<MedicineDTO>> getAllMedicine(){
        List<Medicine> m = medicineService.findAll();
        List<MedicineDTO> mDTOs = new ArrayList<>();

        for (Medicine medicine : m) {
            MedicineDTO novi = new MedicineDTO(medicine);
            mDTOs.add(novi);
        }

        return new ResponseEntity<>(mDTOs, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<MedicineDTO> createMedicine(@RequestBody MedicineDTO mDTO){
        Medicine m = new Medicine();
        try {
            m.setId(mDTO.getId());
            m.setName(mDTO.getName());
            m.setType(mDTO.getType());
            m.setShape(mDTO.getShape());
            m.setComposition(mDTO.getComposition());
            m.setManufacturer(mDTO.getManufacturer());
            m.setPrescription(mDTO.isPrescription());
            //m.setMedicineSubstituteIDs(mDTO.getMedicineSubstituteIDs());
            m.setNote(mDTO.getNote());
            
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(mDTO, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<MedicineDTO> getMedicine(@PathVariable String name){
        Medicine m = medicineService.findByName(name);

        if (m == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        MedicineDTO mDTO = new MedicineDTO(m.getId(), m.getName(), m.getType(), m.getShape(), m.getComposition(), m.getManufacturer(), m.isPrescription(), m.getNote());
        return new ResponseEntity<>(mDTO, HttpStatus.OK);

    }
    
}
