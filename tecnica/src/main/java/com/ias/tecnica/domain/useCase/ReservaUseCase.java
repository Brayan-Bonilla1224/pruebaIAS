package com.ias.tecnica.domain.useCase;

import com.ias.tecnica.domain.model.Reserva;
import com.ias.tecnica.domain.puertos.in.ReservaUseCaseInterface;
import com.ias.tecnica.domain.puertos.out.ReservaUseCaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ReservaUseCase implements ReservaUseCaseInterface {

    private final ReservaUseCaseRepository reservaUseCaseRepository;

    @Override
    public Mono<Reserva> guardar(Reserva reserva) {

        return reservaUseCaseRepository.guardar(reserva);
    }

    @Override
    public Mono<Reserva> actualizar(Reserva reserva) {

        return reservaUseCaseRepository.actualizar(reserva);
    }

    @Override
    public Flux<Reserva> buscarTodos() {

        return reservaUseCaseRepository.buscarTodos();
    }

}
