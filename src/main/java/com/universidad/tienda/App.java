package com.universidad.tienda;

import com.universidad.tienda.decorator.AuditoriaDecorator;
import com.universidad.tienda.decorator.LoggingDecorator;
import com.universidad.tienda.decorator.OrdenServicio;
import com.universidad.tienda.decorator.OrdenServicioBase;
import com.universidad.tienda.decorator.ValidacionDecorator;

/**
 * Demostracion basica del patron Decorator para ordenes.
 *
 */
public class App {
    public static void main(String[] args) {
        OrdenServicio servicio = new OrdenServicioBase();
        servicio = new LoggingDecorator(servicio);
        servicio = new ValidacionDecorator(servicio);
        servicio = new AuditoriaDecorator(servicio);

        System.out.println(servicio.procesarOrden());
    }
}
