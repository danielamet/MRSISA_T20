package com.isamrs.backend.model;

import com.isamrs.backend.enumeration.MedicineShape;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "medicine")
public class Medicine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", unique=true, nullable = false)
	private String name;

    // Vrsta
    @Column(name="type", nullable = false)
	private String type;

    // Oblik leka(prasak,kapsula,tableta,mast,pasta,gel,rastvor,sirup, itd..)
    @Column(name="shape", nullable = false)
	private MedicineShape shape;

    @Column(name="composition", nullable = false)
	private String composition;

    @Column(name="manufacturer", nullable = false)
	private String manufacturer;

    // Rezim izdavanja(na recept ili bez recepta) - true = recept, false = bez recepta
    @Column(name="prescription", nullable = false)
	private boolean prescription;

    //TODO: Implementirati ovaj atribut kao listu referenci na kljuceve drugih lekova
    @Column(name="substitutes")
    private String medicineSubstituteNames;

    // Dodatne napomene
    @Column(name="note")
	private String note;

    public Medicine() {
    }

    public Medicine(Long id, String name, String type, MedicineShape shape, String composition, String manufacturer, boolean prescription, String medicineSubstituteNames, String note) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.shape = shape;
        this.composition = composition;
        this.manufacturer = manufacturer;
        this.prescription = prescription;
        this.medicineSubstituteNames = medicineSubstituteNames;
        this.note = note;
    }

    public Medicine(String name, String type, MedicineShape shape, String composition, String manufacturer, boolean prescription, String medicineSubstituteNames, String note) {
        this.name = name;
        this.type = type;
        this.shape = shape;
        this.composition = composition;
        this.manufacturer = manufacturer;
        this.prescription = prescription;
        this.medicineSubstituteNames = medicineSubstituteNames;
        this.note = note;
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

    public String getComposition() {
        return composition;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public boolean isPrescription() {
        return prescription;
    }

    public String getMedicineSubstituteNames() {
        return medicineSubstituteNames;
    }

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

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPrescription(boolean prescription) {
        this.prescription = prescription;
    }

    public void setMedicineSubstituteNames(String medicineSubstituteNames) {
        this.medicineSubstituteNames = medicineSubstituteNames;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public MedicineShape getShape() {
        return shape;
    }

    public void setShape(MedicineShape shape) {
        this.shape = shape;
    }
}
