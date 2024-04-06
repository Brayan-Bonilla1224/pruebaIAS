package com.ias.tecnica.infrastructure.utilidades.mapper;

import com.ias.tecnica.domain.model.Reserva;
import com.ias.tecnica.infrastructure.utilidades.dao.ReservaDAO;
import com.ias.tecnica.infrastructure.utilidades.dto.ReservaRQDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    @Mapping(target = "identificacion.numero", source = "reservaDAO.numero")
    @Mapping(target = "identificacion.tipo", source = "reservaDAO.tipo")
    Reserva reservaDAOToReserva(ReservaDAO reservaDAO);


    @Mapping(target = "numero", source = "reserva.identificacion.numero")
    @Mapping(target = "tipo", source = "reserva.identificacion.tipo")
    ReservaDAO reservaToReservaDAO(Reserva reserva);

    @Mapping(target = "identificacion.numero", source = "reservaRQDTO.numero")
    @Mapping(target = "identificacion.tipo", source = "reservaRQDTO.tipo")
    Reserva reservaRQDTOToReserva(ReservaRQDTO reservaRQDTO);

}
