package com.ias.tecnica.domain.model;

public class Reserva {
    private Long id;
    private String nombre;
    private Identificacion identificacion;
    private int cantidad;
    private String observaciones;
    private String fecha;

    public Reserva() {

    }

    public Reserva(Long id, String nombre, Identificacion identificacion, int cantidad, String observaciones, String fecha) {

        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.cantidad = cantidad;
        this.observaciones = observaciones;
        this.fecha = fecha;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public Identificacion getIdentificacion() {

        return identificacion;
    }

    public void setIdentificacion(Identificacion identificacion) {

        this.identificacion = identificacion;
    }

    public int getCantidad() {

        return cantidad;
    }

    public void setCantidad(int cantidad) {

        this.cantidad = cantidad;
    }

    public String getObservaciones() {

        return observaciones;
    }

    public void setObservaciones(String observaciones) {

        this.observaciones = observaciones;
    }

    public String getFecha() {

        return fecha;
    }

    public void setFecha(String fecha) {

        this.fecha = fecha;
    }

}
