package com.universidad.tienda.decorator;

public class ValidacionDecorator extends OrdenServicioDecorator {

    public ValidacionDecorator(OrdenServicio ordenServicio) {
        super(ordenServicio);
    }

    public String procesarOrden(String ordenId, double monto) {
        System.out.println("VALIDACION");
        if (ordenId == null || ordenId.trim().isEmpty()) {
            throw new IllegalArgumentException("El id de orden es obligatorio");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero");
        }
        return super.procesarOrden(ordenId, monto) + " | Validacion aplicada";
    }
}