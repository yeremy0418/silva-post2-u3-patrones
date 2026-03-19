package com.universidad.tienda;

import com.universidad.tienda.decorator.AuditoriaDecorator;
import com.universidad.tienda.decorator.LoggingDecorator;
import com.universidad.tienda.decorator.OrdenServicio;
import com.universidad.tienda.decorator.OrdenServicioBase;
import com.universidad.tienda.decorator.ValidacionDecorator;
import com.universidad.tienda.facade.EmailService;
import com.universidad.tienda.facade.NotificacionFacade;
import com.universidad.tienda.facade.PushService;
import com.universidad.tienda.facade.SMSService;

/**
 * Demostracion basica del patron Decorator para ordenes.
 *
 */
public class App {
    public static void main(String[] args) {
        OrdenServicio servicio = new OrdenServicioBase();
        servicio = new LoggingDecorator(servicio);
        servicio = new ValidacionDecorator(servicio);
        servicio = new AuditoriaDecorator(servicio);

        System.out.println(servicio.procesarOrden("ORD-001", 50000.0));

        NotificacionFacade notificacionFacade = new NotificacionFacade(
            new EmailService(),
            new SMSService(),
            new PushService()
        );

        notificacionFacade.notificarCompraExitosa(
            "cliente@correo.com",
            "+593999999999",
            "token-demo-123",
            "ORD-001"
        );

        notificacionFacade.notificarErrorPago(
            "cliente@correo.com",
            "+593999999999",
            "ORD-002"
        );
    }
}
