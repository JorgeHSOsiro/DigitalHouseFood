package com.example.digitalhousefood.model;

import java.io.Serializable;

public class Restaurante implements Serializable {
    private String nomeRestaurante;
    private String enderecoRestaurante;
    private String horarioRestaurante;
    private String fotoRestaurante;

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    public String getEnderecoRestaurante() {
        return enderecoRestaurante;
    }

    public void setEnderecoRestaurante(String enderecoRestaurante) {
        this.enderecoRestaurante = enderecoRestaurante;
    }

    public String getHorarioRestaurante() {
        return horarioRestaurante;
    }

    public void setHorarioRestaurante(String horarioRestaurante) {
        this.horarioRestaurante = horarioRestaurante;
    }

    public String getFotoRestaurante() {
        return fotoRestaurante;
    }

    public void setFotoRestaurante(String fotoRestaurante) {
        this.fotoRestaurante = fotoRestaurante;
    }
}
