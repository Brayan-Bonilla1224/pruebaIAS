package com.ias.tecnica.domain.model;

public class Identificacion {

    private String numero;
    private String tipo;

    public Identificacion() {

    }

    public Identificacion(String numero, String tipo) {

        this.numero = numero;
        this.tipo = tipo;
    }

    public String getNumero() {

        return numero;
    }

    public void setNumero(String numero) {

        this.numero = numero;
    }

    public String getTipo() {

        return tipo;
    }

    public void setTipo(String tipo) {

        this.tipo = tipo;
    }

}
