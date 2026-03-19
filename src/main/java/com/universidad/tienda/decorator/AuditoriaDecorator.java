package com.universidad.tienda.decorator;

public class AuditoriaDecorator extends OrdenServicioDecorator {

    public AuditoriaDecorator(OrdenServicio ordenServicio) {
        super(ordenServicio);
    }

    public String procesarOrden() {
        return super.procesarOrden() + " | Auditoria aplicada";
    }
}