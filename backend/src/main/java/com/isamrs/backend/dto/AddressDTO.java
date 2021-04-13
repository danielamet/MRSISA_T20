package com.isamrs.backend.dto;


public class AddressDTO {

    private String street;

    private String city;

    private Integer zip;

    private String country;

    public AddressDTO() {
    }

    public AddressDTO(String street, String city, Integer zip, String country) {
        super();
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
