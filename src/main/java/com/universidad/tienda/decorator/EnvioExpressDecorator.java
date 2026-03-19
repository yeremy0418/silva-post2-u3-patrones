package com.universidad.tienda.decorator;

public class EnvioExpressDecorator extends OrdenDecorator {
    private static final double COSTO_ENVIO_EXPRESS = 25.0;

    public EnvioExpressDecorator(Orden orden) {
        super(orden);
    }

    public String getDescripcion() {
        return orden.getDescripcion() + " + Envio Express";
    }

    public double getCosto() {
        return orden.getCosto() + COSTO_ENVIO_EXPRESS;
    }
}