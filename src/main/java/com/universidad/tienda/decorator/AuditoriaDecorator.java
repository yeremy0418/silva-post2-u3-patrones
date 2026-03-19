package com.universidad.tienda.decorator;

public class AuditoriaDecorator extends OrdenServicioDecorator {

    public AuditoriaDecorator(OrdenServicio ordenServicio) {
        super(ordenServicio);
    }

    public String procesarOrden(String ordenId, double monto) {
        return super.procesarOrden(ordenId, monto) + " | Auditoria aplicada";
    }
}