package com.isamrs.backend.dto;

import java.io.Serializable;

public class LoginUserDTO implements Serializable {

    private String token;
    private String roleType;

    public LoginUserDTO() {
    }

    public LoginUserDTO(String token, String role) {
        this.token = token;
        this.roleType = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}
