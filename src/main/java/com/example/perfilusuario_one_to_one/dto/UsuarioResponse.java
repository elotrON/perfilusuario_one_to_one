package com.example.perfilusuario_one_to_one.dto;

public class UsuarioResponse {

    private Integer id;
    private String nombre;
    private String email;
    private PerfilResponse perfilResponse;


    public PerfilResponse getPerfilResponse() {
        return perfilResponse;
    }

    public void setPerfilResponse(PerfilResponse perfilResponse) {
        this.perfilResponse = perfilResponse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
