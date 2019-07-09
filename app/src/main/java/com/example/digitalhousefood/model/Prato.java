package com.example.digitalhousefood.model;

import java.io.Serializable;

public class Prato implements Serializable {
    private String fotoPrato;
    private String nomePrato;
    private String descricaoPrato;

    public String getFotoPrato() {
        return fotoPrato;
    }

    public void setFotoPrato(String fotoPrato) {
        this.fotoPrato = fotoPrato;
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public String getDescricaoPrato() {
        return descricaoPrato;
    }

    public void setDescricaoPrato(String descricaoPrato) {
        this.descricaoPrato = descricaoPrato;
    }
}
