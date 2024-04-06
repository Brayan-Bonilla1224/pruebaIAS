package com.ias.tecnica.infrastructure.utilidades.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "adaptadores.in")
public class RouteProperties {

    private String baseUrl;
    private String guardar;
    private String actualizar;
    private String buscarTodos;

    public String buildGuardar() {

        return this.getBaseUrl().concat(this.guardar);
    }

    public String buildActualizar() {

        return this.getBaseUrl().concat(this.actualizar);
    }
    public String buildBuscarTodos() {

        return this.getBaseUrl().concat(this.buscarTodos);
    }

}
