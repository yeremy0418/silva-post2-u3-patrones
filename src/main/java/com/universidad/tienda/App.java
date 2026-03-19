package com.universidad.tienda;

import com.universidad.tienda.decorator.Orden;
import com.universidad.tienda.decorator.OrdenServicio;

/**
 * Demostracion basica del patron Decorator para ordenes.
 *
 */
public class App {
    public static void main(String[] args) {
        OrdenServicio servicio = new OrdenServicio();

        Orden ordenPremium = servicio.crearOrdenCompletaConDescuento(
                "Laptop",
                1200.0,
                true,
                true,
                120.0
        );

        System.out.println("Descripcion: " + ordenPremium.getDescripcion());
        System.out.println("Costo final: $" + ordenPremium.getCosto());
    }
}
