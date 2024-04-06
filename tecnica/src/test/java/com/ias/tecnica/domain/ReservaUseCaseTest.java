package com.ias.tecnica.domain;

import com.ias.tecnica.domain.model.Reserva;
import com.ias.tecnica.domain.puertos.out.ReservaUseCaseRepository;
import com.ias.tecnica.domain.useCase.ReservaUseCase;
import com.ias.tecnica.util.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class ReservaUseCaseTest {

    @Mock
    ReservaUseCaseRepository reservaUseCaseRepository;

    @InjectMocks
    ReservaUseCase reservaUseCase;

    Reserva reserva;

    @BeforeEach
    void setUp() {
        reserva = TestData.buildReserva();

    }

    @Test
    void guardarReserva() {

        Mockito.when(reservaUseCaseRepository.guardar(Mockito.any())).thenReturn(Mono.just(reserva));
        Mono<Reserva> reservaMono = reservaUseCase.guardar(reserva);

        StepVerifier.create(reservaMono)
                .expectSubscription()
                .thenConsumeWhile(reserva1 -> true)
                .verifyComplete();
    }

    @Test
    void actualizarReserva() {

        Mockito.when(reservaUseCaseRepository.actualizar(Mockito.any())).thenReturn(Mono.just(reserva));
        Mono<Reserva> reservaMono = reservaUseCase.actualizar(reserva);

        StepVerifier.create(reservaMono)
                .expectSubscription()
                .thenConsumeWhile(reserva1 -> true)
                .verifyComplete();
    }

    @Test
    void buscarTodosReserva() {

        Mockito.when(reservaUseCaseRepository.buscarTodos()).thenReturn(Flux.just(reserva));
        Flux<Reserva> reservaMono = reservaUseCase.buscarTodos();

        StepVerifier.create(reservaMono)
                .expectSubscription()
                .thenConsumeWhile(reserva1 -> true)
                .verifyComplete();
    }

}
