package com.universidad.tienda.decorator;

public class OrdenBase implements Orden {
    private final String descripcionProducto;
    private final double costoBase;

    public OrdenBase(String descripcionProducto, double costoBase) {
        if (descripcionProducto == null || descripcionProducto.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripcion del producto es obligatoria");
        }
        if (costoBase < 0) {
            throw new IllegalArgumentException("El costo base no puede ser negativo");
        }
        this.descripcionProducto = descripcionProducto;
        this.costoBase = costoBase;
    }

    public String getDescripcion() {
        return descripcionProducto;
    }

    public double getCosto() {
        return costoBase;
    }
}