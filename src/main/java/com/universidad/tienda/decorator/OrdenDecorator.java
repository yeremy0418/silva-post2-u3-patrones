package com.universidad.tienda.decorator;

public abstract class OrdenDecorator implements Orden {
    protected final Orden orden;

    protected OrdenDecorator(Orden orden) {
        if (orden == null) {
            throw new IllegalArgumentException("La orden a decorar no puede ser nula");
        }
        this.orden = orden;
    }
}