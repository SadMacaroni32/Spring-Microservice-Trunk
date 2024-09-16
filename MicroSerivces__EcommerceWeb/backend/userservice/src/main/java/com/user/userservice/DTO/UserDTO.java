package com.user.userservice.DTO;

public class UserDTO {
    private String token;


    public UserDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    

    
}
