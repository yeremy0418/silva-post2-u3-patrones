package com.universidad.tienda;

import com.universidad.tienda.decorator.LoggingDecorator;
import com.universidad.tienda.decorator.OrdenServicio;
import com.universidad.tienda.decorator.OrdenServicioBase;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DecoratorTest {

    private OrdenServicio buildCompleto() {
        DecoratorConfig config = new DecoratorConfig();
        return config.ordenServicioCompleto(config.ordenBase());
    }

    @Test
    void testOrdenValida() {
        OrdenServicio svc = buildCompleto();

        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        PrintStream salidaOriginal = System.out;
        System.setOut(new PrintStream(salida));

        String result;
        try {
            result = svc.procesarOrden("ORD-001", 50000.0);
        } finally {
            System.setOut(salidaOriginal);
        }

        assertTrue(result.startsWith("PROCESADA:"));
        assertTrue(result.contains("Logging aplicado"));
        assertTrue(result.contains("Validacion aplicada"));
        assertTrue(result.contains("Auditoria aplicada"));

        String log = salida.toString();
        int idxAuditoria = log.indexOf("AUDITORIA");
        int idxValidacion = log.indexOf("VALIDACION");
        int idxLog = log.indexOf("LOG");
        int idxBase = log.indexOf("BASE");

        assertTrue(idxAuditoria >= 0);
        assertTrue(idxValidacion > idxAuditoria);
        assertTrue(idxLog > idxValidacion);
        assertTrue(idxBase > idxLog);
    }

    @Test
    void testOrdenMontoInvalido() {
        OrdenServicio svc = buildCompleto();
        assertThrows(IllegalArgumentException.class,
                () -> svc.procesarOrden("ORD-002", 0.0));
    }

    @Test
    void testOrdenIdVacio() {
        OrdenServicio svc = buildCompleto();
        assertThrows(IllegalArgumentException.class,
                () -> svc.procesarOrden("", 10000.0));
    }

    @Test
    void testDecoradorIndividualLogging() {
        OrdenServicio base = new OrdenServicioBase();
        OrdenServicio conLog = new LoggingDecorator(base);
        assertDoesNotThrow(() -> conLog.procesarOrden("ORD-003", 0.0));
    }
}