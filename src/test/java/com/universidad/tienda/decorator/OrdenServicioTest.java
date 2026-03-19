package com.universidad.tienda.decorator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OrdenServicioTest {

    @Test
    public void ordenServicioBase_debeProcesarOrdenBase() {
        OrdenServicio servicio = new OrdenServicioBase();

        String resultado = servicio.procesarOrden();

        assertEquals("Orden procesada", resultado);
    }

    @Test
    public void loggingDecorator_debeAgregarComportamiento() {
        OrdenServicio servicio = new LoggingDecorator(new OrdenServicioBase());

        String resultado = servicio.procesarOrden();

        assertTrue(resultado.contains("Orden procesada"));
        assertTrue(resultado.contains("Logging aplicado"));
    }

    @Test
    public void validacionDecorator_debeAgregarComportamiento() {
        OrdenServicio servicio = new ValidacionDecorator(new OrdenServicioBase());

        String resultado = servicio.procesarOrden();

        assertTrue(resultado.contains("Orden procesada"));
        assertTrue(resultado.contains("Validacion aplicada"));
    }

    @Test
    public void auditoriaDecorator_debeAgregarComportamiento() {
        OrdenServicio servicio = new AuditoriaDecorator(new OrdenServicioBase());

        String resultado = servicio.procesarOrden();

        assertTrue(resultado.contains("Orden procesada"));
        assertTrue(resultado.contains("Auditoria aplicada"));
    }

    @Test
    public void cadenaDeDecoradores_debeConservarOrden() {
        OrdenServicio servicio = new OrdenServicioBase();
        servicio = new LoggingDecorator(servicio);
        servicio = new ValidacionDecorator(servicio);
        servicio = new AuditoriaDecorator(servicio);

        String resultado = servicio.procesarOrden();

        assertEquals(
                "Orden procesada | Logging aplicado | Validacion aplicada | Auditoria aplicada",
                resultado
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void decorator_conComponenteNulo_debeLanzarExcepcion() {
        new LoggingDecorator(null);
    }
}