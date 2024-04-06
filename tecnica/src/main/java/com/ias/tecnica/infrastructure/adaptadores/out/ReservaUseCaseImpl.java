package com.ias.tecnica.infrastructure.adaptadores.out;

import com.ias.tecnica.domain.model.Reserva;
import com.ias.tecnica.domain.puertos.out.ReservaUseCaseRepository;
import com.ias.tecnica.infrastructure.adaptadores.out.repository.ReservaRepository;
import com.ias.tecnica.infrastructure.utilidades.mapper.ReservaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
@RequiredArgsConstructor
public class ReservaUseCaseImpl implements ReservaUseCaseRepository {


    private final ReservaRepository reservaRepository;
    private final ReservaMapper reservaMapper;
    @Override
    public Mono<Reserva> guardar(Reserva reserva) {

        return reservaRepository.save(reservaMapper.reservaToReservaDAO(reserva))
                .map(reservaMapper::reservaDAOToReserva);
    }

    @Override
    public Mono<Reserva> actualizar(Reserva reserva) {

        return reservaRepository.save(reservaMapper.reservaToReservaDAO(reserva))
                .map(reservaMapper::reservaDAOToReserva);
    }

    @Override
    public Flux<Reserva> buscarTodos() {

        return reservaRepository.findAll()
                .map(reservaMapper::reservaDAOToReserva);
    }

}
