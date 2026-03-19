package com.universidad.tienda.decorator;

public class ValidacionDecorator extends OrdenServicioDecorator {

    public ValidacionDecorator(OrdenServicio ordenServicio) {
        super(ordenServicio);
    }

    public String procesarOrden() {
        return super.procesarOrden() + " | Validacion aplicada";
    }
}