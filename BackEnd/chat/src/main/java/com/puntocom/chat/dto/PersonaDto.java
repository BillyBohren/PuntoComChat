package com.puntocom.chat.dto;

import javax.validation.constraints.NotBlank;

public class PersonaDto {

    @NotBlank
    private String usuario;
    @NotBlank
    private String password;
    @NotBlank
    private String nombre;

    public PersonaDto() {
    }

    public PersonaDto(@NotBlank String usuario, @NotBlank String password, @NotBlank String nombre) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
