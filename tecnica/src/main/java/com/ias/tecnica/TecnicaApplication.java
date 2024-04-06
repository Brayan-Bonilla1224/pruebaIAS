package com.ias.tecnica;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableR2dbcRepositories
//@EnableWebFlux
@SpringBootApplication
public class TecnicaApplication {

    @Bean
    ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {

        ConnectionFactoryInitializer connectionFactoryInitializer = new ConnectionFactoryInitializer();
        connectionFactoryInitializer.setConnectionFactory(connectionFactory);
        connectionFactoryInitializer.setDatabaseCleaner(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
        return connectionFactoryInitializer;
    }

    public static void main(String[] args) {

        SpringApplication.run(TecnicaApplication.class, args);
    }

}
