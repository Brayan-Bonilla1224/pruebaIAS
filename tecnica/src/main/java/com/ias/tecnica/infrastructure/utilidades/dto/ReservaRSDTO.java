package com.ias.tecnica.infrastructure.utilidades.dto;

import com.ias.tecnica.domain.model.Reserva;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class ReservaRSDTO {

    private Reserva data;
    private int status;
    private String message;


}
