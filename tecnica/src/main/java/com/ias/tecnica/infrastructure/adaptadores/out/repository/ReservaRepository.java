package com.ias.tecnica.infrastructure.adaptadores.out.repository;

import com.ias.tecnica.infrastructure.utilidades.dao.ReservaDAO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends ReactiveCrudRepository<ReservaDAO, Long> {

}
