package com.ias.tecnica.util;

import com.ias.tecnica.domain.model.Identificacion;
import com.ias.tecnica.domain.model.Reserva;
import com.ias.tecnica.infrastructure.utilidades.dto.ReservaRQDTO;

public class TestData {

    public static String endpoint = "http://localhost:";
    public static Reserva buildReserva(){
        Reserva reserva = new Reserva(Long.parseLong("1"), "Prueba", buildIdentificacion(),
                3, "Ninguna", "05/04/2024 18:20:00");
        return reserva;
    }

    public static Identificacion buildIdentificacion(){
        Identificacion identificacion = new Identificacion("123456", "CC");
        return identificacion;
    }

    public static ReservaRQDTO buildReservaRQDTO(){
        return ReservaRQDTO.builder()
                .id(Long.parseLong("1"))
                .tipo("CC")
                .fecha("05/04/2024 18:20:00")
                .numero("123456")
                .cantidad(3)
                .nombre("Prueba")
                .observaciones("Ninguna")
                .build();
    }
}
