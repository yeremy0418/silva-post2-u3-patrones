package com.universidad.tienda.decorator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OrdenServicioTest {

    @Test
    public void crearOrdenBase_debeRetornarCostoYDescripcionBase() {
        OrdenServicio servicio = new OrdenServicio();

        Orden orden = servicio.crearOrdenBase("Mouse", 20.0);

        assertEquals("Mouse", orden.getDescripcion());
        assertEquals(20.0, orden.getCosto(), 0.001);
    }

    @Test
    public void agregarDecoradores_debeAcumularCosto() {
        OrdenServicio servicio = new OrdenServicio();

        Orden orden = servicio.crearOrdenBase("Teclado", 50.0);
        orden = servicio.agregarEnvioExpress(orden);
        orden = servicio.agregarEmpaqueRegalo(orden);

        assertEquals(83.0, orden.getCosto(), 0.001);
    }

    @Test
    public void aplicarDescuento_noDebePermitirCostoNegativo() {
        OrdenServicio servicio = new OrdenServicio();

        Orden orden = servicio.crearOrdenBase("Cable HDMI", 10.0);
        orden = servicio.aplicarDescuento(orden, 99.0);

        assertEquals(0.0, orden.getCosto(), 0.001);
    }

    @Test
    public void crearOrdenCompletaConDescuento_debeAplicarTodosLosAjustes() {
        OrdenServicio servicio = new OrdenServicio();

        Orden orden = servicio.crearOrdenCompletaConDescuento("Monitor", 300.0, true, true, 50.0);

        assertEquals(283.0, orden.getCosto(), 0.001);
        assertTrue(orden.getDescripcion().contains("Monitor"));
        assertTrue(orden.getDescripcion().contains("Envio Express"));
        assertTrue(orden.getDescripcion().contains("Empaque de Regalo"));
        assertTrue(orden.getDescripcion().contains("Cupon de Descuento"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void crearOrdenBase_conDescripcionVacia_debeLanzarExcepcion() {
        OrdenServicio servicio = new OrdenServicio();
        servicio.crearOrdenBase(" ", 50.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void aplicarDescuentoNegativo_debeLanzarExcepcion() {
        OrdenServicio servicio = new OrdenServicio();

        Orden orden = servicio.crearOrdenBase("Tablet", 200.0);
        servicio.aplicarDescuento(orden, -5.0);
    }
}