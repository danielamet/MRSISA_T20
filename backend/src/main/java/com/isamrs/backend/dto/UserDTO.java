package com.isamrs.backend.dto;


import java.io.Serializable;

public class UserDTO implements Serializable {

    private String name;

    private String surname;

    private String email;

    private String password;

    private String roleType;

    private AddressDTO address;

    public UserDTO() {
        super();
    }

    public UserDTO(String name, String surname, String email, String password, String roleType, AddressDTO address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.roleType = roleType;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }
}
