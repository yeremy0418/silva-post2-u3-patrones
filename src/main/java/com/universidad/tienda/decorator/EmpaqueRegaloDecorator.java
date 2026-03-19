package com.universidad.tienda.decorator;

public class EmpaqueRegaloDecorator extends OrdenDecorator {
    private static final double COSTO_EMPAQUE_REGALO = 8.0;

    public EmpaqueRegaloDecorator(Orden orden) {
        super(orden);
    }

    public String getDescripcion() {
        return orden.getDescripcion() + " + Empaque de Regalo";
    }

    public double getCosto() {
        return orden.getCosto() + COSTO_EMPAQUE_REGALO;
    }
}