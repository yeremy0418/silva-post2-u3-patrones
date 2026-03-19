package com.universidad.tienda.decorator;

public class OrdenServicioBase implements OrdenServicio {

    public String procesarOrden(String ordenId, double monto) {
        System.out.println("BASE");
        return "PROCESADA:" + ordenId + " | monto=" + monto;
    }
}