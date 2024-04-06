package com.ias.tecnica.domain.puertos.out;

import com.ias.tecnica.domain.model.Reserva;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReservaUseCaseRepository {

    Mono<Reserva> guardar(Reserva reserva);

    Mono<Reserva> actualizar(Reserva reserva);

    Flux<Reserva> buscarTodos();

}
