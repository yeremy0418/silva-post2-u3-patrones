package com.universidad.tienda.decorator;

public class LoggingDecorator extends OrdenServicioDecorator {

    public LoggingDecorator(OrdenServicio ordenServicio) {
        super(ordenServicio);
    }

    public String procesarOrden() {
        return super.procesarOrden() + " | Logging aplicado";
    }
}