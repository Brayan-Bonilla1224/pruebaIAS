package com.ias.tecnica.infrastructure.utilidades.validaciones;

import com.ias.tecnica.domain.model.Reserva;
import com.ias.tecnica.infrastructure.utilidades.dto.ReservaRQDTO;
import com.ias.tecnica.infrastructure.utilidades.dto.ReservaRSDTO;
import lombok.experimental.UtilityClass;
import reactor.core.publisher.Mono;

@UtilityClass
public class ReservaValidation {

    public static ReservaRQDTO validateReservaRQDTO(ReservaRQDTO reservaRQDTO) {
        validarNombre(reservaRQDTO.getNombre());
        validarComensales(reservaRQDTO.getCantidad());
        return reservaRQDTO;
    }

    void validarNombre(String nombre) {

        if (nombre.length() > 60)
            throw new RuntimeException("El nombre debe ser inferior a 60 caracteres");
    }

    void validarComensales(int comensales) {

        if (comensales > 4)
            throw new RuntimeException("La cantidad de comensales es máximo 4 por reserva");

    }

    public static ReservaRSDTO validateResponseReserva(Reserva reserva){
        return ReservaRSDTO.builder()
                .data(reserva)
                .status(200)
                .message("OK")
                .build();
    }

}
