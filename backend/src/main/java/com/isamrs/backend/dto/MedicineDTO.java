package com.isamrs.backend.dto;

import java.util.List;

import com.isamrs.backend.enumeration.MedicineShape;
import lombok.NoArgsConstructor;
import com.isamrs.backend.model.Medicine;


@NoArgsConstructor
public class MedicineDTO {

    private Long id;
    private String name;
    private String type;
    private MedicineShape shape;
    private String composition;
    private String manufacturer;
    private boolean prescription;
    //private List<Long> medicineSubstituteIDs;
    private String note;

    public MedicineDTO(Long id, String name, String type, MedicineShape shape, String composition, String manufacturer, boolean prescription, String note) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.shape = shape;
        this.composition = composition;
        this.manufacturer = manufacturer;
        this.prescription = prescription;
        //this.medicineSubstituteIDs = medicineSubstituteIDs;
        this.note = note;
    }

    public MedicineDTO(Medicine medicine){
        this.id = medicine.getId();
        this.name = medicine.getName();
        this.type = medicine.getType();
        this.shape = medicine.getShape();
        this.composition = medicine.getComposition();
        this.manufacturer = medicine.getManufacturer();
        this.prescription = medicine.isPrescription();
        //this.medicineSubstituteIDs = medicine.getMedicineSubstituteIDs();
        this.note = medicine.getNote();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public MedicineShape getShape() {
        return shape;
    }

    public String getComposition() {
        return composition;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public boolean isPrescription() {
        return prescription;
    }

    // public List<Long> getMedicineSubstituteIDs() {
    //     return medicineSubstituteIDs;
    // }

    public String getNote() {
        return note;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setShape(MedicineShape shape) {
        this.shape = shape;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPrescription(boolean prescription) {
        this.prescription = prescription;
    }

    // public void setMedicineSubstituteIDs(List<Long> medicineSubstituteIDs) {
    //     this.medicineSubstituteIDs = medicineSubstituteIDs;
    // }

    public void setNote(String note) {
        this.note = note;
    }
}
