package com.universidad.tienda.decorator;

public class LoggingDecorator extends OrdenServicioDecorator {

    public LoggingDecorator(OrdenServicio ordenServicio) {
        super(ordenServicio);
    }

    public String procesarOrden(String ordenId, double monto) {
        return super.procesarOrden(ordenId, monto) + " | Logging aplicado";
    }
}