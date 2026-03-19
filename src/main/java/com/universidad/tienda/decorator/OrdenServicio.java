package com.universidad.tienda.decorator;

public class OrdenServicio {

	public Orden crearOrdenBase(String descripcionProducto, double costoBase) {
		return new OrdenBase(descripcionProducto, costoBase);
	}

	public Orden agregarEnvioExpress(Orden orden) {
		return new EnvioExpressDecorator(orden);
	}

	public Orden agregarEmpaqueRegalo(Orden orden) {
		return new EmpaqueRegaloDecorator(orden);
	}

	public Orden aplicarDescuento(Orden orden, double montoDescuento) {
		return new CuponDescuentoDecorator(orden, montoDescuento);
	}

	public Orden crearOrdenCompletaConDescuento(
			String descripcionProducto,
			double costoBase,
			boolean conEnvioExpress,
			boolean conEmpaqueRegalo,
			double montoDescuento
	) {
		Orden orden = crearOrdenBase(descripcionProducto, costoBase);

		if (conEnvioExpress) {
			orden = agregarEnvioExpress(orden);
		}

		if (conEmpaqueRegalo) {
			orden = agregarEmpaqueRegalo(orden);
		}

		if (montoDescuento > 0) {
			orden = aplicarDescuento(orden, montoDescuento);
		}

		return orden;
	}
}
