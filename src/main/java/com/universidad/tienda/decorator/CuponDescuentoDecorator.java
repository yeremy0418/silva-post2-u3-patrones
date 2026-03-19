package com.universidad.tienda.decorator;

public class CuponDescuentoDecorator extends OrdenDecorator {
    private final double montoDescuento;

    public CuponDescuentoDecorator(Orden orden, double montoDescuento) {
        super(orden);
        if (montoDescuento < 0) {
            throw new IllegalArgumentException("El descuento no puede ser negativo");
        }
        this.montoDescuento = montoDescuento;
    }

    public String getDescripcion() {
        return orden.getDescripcion() + " + Cupon de Descuento";
    }

    public double getCosto() {
        double costoConDescuento = orden.getCosto() - montoDescuento;
        return Math.max(0.0, costoConDescuento);
    }
}