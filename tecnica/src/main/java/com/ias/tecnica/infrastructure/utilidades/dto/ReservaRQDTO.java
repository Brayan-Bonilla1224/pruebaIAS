package com.ias.tecnica.infrastructure.utilidades.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class ReservaRQDTO {

    private Long id;
    private String nombre;
    private String numero;
    private String tipo;
    private int cantidad;
    private String observaciones;
    private String fecha;

}
