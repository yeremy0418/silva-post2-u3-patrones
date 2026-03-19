package com.universidad.tienda.decorator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DecoratorConfig {

    @Bean
    public OrdenServicio ordenServicio() {
        OrdenServicio base = new OrdenServicioBase();
        return new AuditoriaDecorator(
                new ValidacionDecorator(
                        new LoggingDecorator(base)));
    }
}