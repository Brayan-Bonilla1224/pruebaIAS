package com.ias.tecnica.infrastructure;

import com.ias.tecnica.domain.model.Reserva;
import com.ias.tecnica.domain.puertos.in.ReservaUseCaseInterface;
import com.ias.tecnica.infrastructure.adaptadores.in.ReservaHandler;
import com.ias.tecnica.infrastructure.adaptadores.in.ReservaRouter;
import com.ias.tecnica.infrastructure.utilidades.dto.ReservaRQDTO;
import com.ias.tecnica.infrastructure.utilidades.mapper.ReservaMapper;
import com.ias.tecnica.infrastructure.utilidades.properties.RouteProperties;
import com.ias.tecnica.util.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ContextConfiguration(classes = {ReservaRouter.class, ReservaHandler.class, RouteProperties.class})
@WebFluxTest(properties = {"adaptadores.in.baseUrl= /api/restaurant", "adaptadores.in.guardar= /guardar",
        "adaptadores.in.actualizar= /actualizar", "adaptadores.in.buscarTodos= /buscarTodos"})
class RouterTest {

    @Autowired
    WebTestClient webTestClient;
    @Autowired
    RouteProperties routeProperties;
    @MockBean
    ReservaMapper reservaMapper;
    @MockBean
    ReservaUseCaseInterface reservaUseCaseInterface;

    @Value("${server.port}")
    String port;

    ReservaRQDTO reservaRQDTO;
    Reserva reserva;

    @BeforeEach
    void setUp() {

        reservaRQDTO = TestData.buildReservaRQDTO();
        reserva = TestData.buildReserva();
    }

    @Test
    void guardarReserva() {

        Mockito.when(reservaUseCaseInterface.guardar(Mockito.any())).thenReturn(Mono.just(reserva));
        Mockito.when(reservaMapper.reservaRQDTOToReserva(Mockito.any())).thenReturn(reserva);
        statusAssertions(reservaRQDTO, routeProperties.buildGuardar()).is2xxSuccessful();
    }

    @Test
    void actualizarReserva() {
        Mockito.when(reservaUseCaseInterface.guardar(Mockito.any())).thenReturn(Mono.just(reserva));
        Mockito.when(reservaMapper.reservaRQDTOToReserva(Mockito.any())).thenReturn(reserva);
        statusAssertions(reservaRQDTO, routeProperties.buildGuardar()).is2xxSuccessful();

        Mockito.when(reservaUseCaseInterface.actualizar(Mockito.any())).thenReturn(Mono.just(reserva));
        Mockito.when(reservaMapper.reservaRQDTOToReserva(Mockito.any())).thenReturn(reserva);
        statusAssertionsPut(reservaRQDTO, routeProperties.buildActualizar()).is2xxSuccessful();
    }

    @Test
    void buscarTodoReserva() {
        Mockito.when(reservaUseCaseInterface.guardar(Mockito.any())).thenReturn(Mono.just(reserva));
        Mockito.when(reservaMapper.reservaRQDTOToReserva(Mockito.any())).thenReturn(reserva);
        statusAssertions(reservaRQDTO, routeProperties.buildGuardar()).is2xxSuccessful();

        Mockito.when(reservaUseCaseInterface.buscarTodos()).thenReturn(Flux.just(reserva));
        Mockito.when(reservaMapper.reservaRQDTOToReserva(Mockito.any())).thenReturn(reserva);
        statusAssertionsGet(reservaRQDTO, routeProperties.buildBuscarTodos()).is2xxSuccessful();
    }

    private <T>StatusAssertions statusAssertions(T body, String url){
        return webTestClient.post()
                .uri(TestData.endpoint + port + url)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(body)
                .exchange()
                .expectStatus();
    }

    private <T>StatusAssertions statusAssertionsPut(T body, String url){
        return webTestClient.put()
                .uri(TestData.endpoint + port + url)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(body)
                .exchange()
                .expectStatus();
    }

    private <T>StatusAssertions statusAssertionsGet(T body, String url){
        return webTestClient.get()
                .uri(TestData.endpoint + port + url)
                .exchange()
                .expectStatus();
    }



}
