package com.ias.tecnica.infrastructure.adaptadores.in;

import com.ias.tecnica.domain.puertos.in.ReservaUseCaseInterface;
import com.ias.tecnica.infrastructure.utilidades.dto.ReservaRQDTO;
import com.ias.tecnica.infrastructure.utilidades.mapper.ReservaMapper;
import com.ias.tecnica.infrastructure.utilidades.validaciones.ReservaValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
@Component
@RequiredArgsConstructor
public class ReservaHandler {

    private final ReservaUseCaseInterface reservaUseCaseInterface;
    private final ReservaMapper reservaMapper;

    public Mono<ServerResponse> guardar(ServerRequest serverRequest){
        return serverRequest.bodyToMono(ReservaRQDTO.class)
                .map(ReservaValidation::validateReservaRQDTO)
                .flatMap(reservaRQDTO -> reservaUseCaseInterface.guardar(reservaMapper.reservaRQDTOToReserva(reservaRQDTO)))
                .map(ReservaValidation::validateResponseReserva)
                .flatMap(reserva -> ServerResponse.ok().bodyValue(reserva));
    }

    public Mono<ServerResponse> actualizar(ServerRequest serverRequest){
        return serverRequest.bodyToMono(ReservaRQDTO.class)
                .map(ReservaValidation::validateReservaRQDTO)
                .flatMap(reservaRQDTO -> reservaUseCaseInterface.guardar(reservaMapper.reservaRQDTOToReserva(reservaRQDTO)))
                .map(ReservaValidation::validateResponseReserva)
                .flatMap(reserva -> ServerResponse.ok().bodyValue(reserva));
    }

    public Mono<ServerResponse> buscarTodos(ServerRequest serverRequest){

        return reservaUseCaseInterface.buscarTodos()
                .collectList()
                .flatMap(reserva -> ServerResponse.ok().bodyValue(reserva));
    }

}
