package com.example.oscarapp.model;

public class Usuario {

    private final String uuid;
    private final String username;
    private final Integer token;

    public Usuario(String uuid, String username, Integer token ) {
        this.uuid = uuid;
        this.username = username;
        this.token = token;
    }


    public String getUuid() {
        return uuid;
    }

    public String getUsername() {
        return username;
    }

    public Integer getToken() {
        return token;
    }
}
