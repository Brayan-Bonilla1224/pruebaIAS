package com.ias.tecnica.infrastructure.utilidades.dao;

import com.ias.tecnica.domain.model.Identificacion;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@Table("reserva")
public class ReservaDAO {

    @Id
    private Long id;
    private String nombre;
    private String numero;
    private String tipo;
    private int cantidad;
    private String observaciones;
    private String fecha;

}
