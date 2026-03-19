package com.universidad.tienda;

import com.universidad.tienda.decorator.AuditoriaDecorator;
import com.universidad.tienda.decorator.LoggingDecorator;
import com.universidad.tienda.decorator.OrdenServicio;
import com.universidad.tienda.decorator.OrdenServicioBase;
import com.universidad.tienda.decorator.ValidacionDecorator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DecoratorConfig {

    @Bean("ordenBase")
    public OrdenServicio ordenBase() {
        return new OrdenServicioBase();
    }

    @Bean("ordenCompleto")
    public OrdenServicio ordenServicioCompleto(@Qualifier("ordenBase") OrdenServicio base) {
        return new AuditoriaDecorator(
                new ValidacionDecorator(
                        new LoggingDecorator(base)));
    }
}