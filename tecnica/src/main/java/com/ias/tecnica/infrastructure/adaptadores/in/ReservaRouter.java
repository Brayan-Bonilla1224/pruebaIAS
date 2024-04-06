package com.ias.tecnica.infrastructure.adaptadores.in;

import com.ias.tecnica.infrastructure.utilidades.properties.RouteProperties;
import lombok.RequiredArgsConstructor;
import net.sf.jsqlparser.schema.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

@Configuration
@RequiredArgsConstructor
public class ReservaRouter {

    private final RouteProperties routeProperties;

    @Bean
    public RouterFunction<ServerResponse> routerFunction(ReservaHandler reservaHandler) {

        return RouterFunctions.route(RequestPredicates.POST(routeProperties.buildGuardar()), reservaHandler::guardar)
                .andRoute(RequestPredicates.PUT(routeProperties.buildActualizar()), reservaHandler::actualizar)
                .andRoute(RequestPredicates.GET(routeProperties.buildBuscarTodos()), reservaHandler::buscarTodos);
    }

}
