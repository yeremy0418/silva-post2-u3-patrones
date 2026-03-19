package com.universidad.tienda.decorator;

public abstract class OrdenServicioDecorator implements OrdenServicio {
    protected final OrdenServicio ordenServicio;

    protected OrdenServicioDecorator(OrdenServicio ordenServicio) {
        if (ordenServicio == null) {
            throw new IllegalArgumentException("El componente base no puede ser nulo");
        }
        this.ordenServicio = ordenServicio;
    }

    public String procesarOrden() {
        return ordenServicio.procesarOrden();
    }
}