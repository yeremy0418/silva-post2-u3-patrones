package com.universidad.tienda.facade;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NotificacionFacadeTest {

    @Test
    void notificarCompraExitosa_debeInvocarTresCanales() {
        NotificacionFacade facade = new NotificacionFacade(
                new EmailService(),
                new SMSService(),
                new PushService()
        );

        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        PrintStream salidaOriginal = System.out;
        System.setOut(new PrintStream(salida));
        try {
            facade.notificarCompraExitosa("cliente@correo.com", "+593999999999", "token-123", "ORD-100");
        } finally {
            System.setOut(salidaOriginal);
        }

        String texto = salida.toString();
        assertTrue(texto.contains("EMAIL ->"));
        assertTrue(texto.contains("SMS ->"));
        assertTrue(texto.contains("PUSH ->"));
    }
}