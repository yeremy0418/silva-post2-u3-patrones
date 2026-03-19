# Proyecto: Patron Decorator en Java

Implementacion del patron de diseno **Decorator** para una tienda que construye ordenes dinamicamente con:

- Envio express
- Empaque de regalo
- Cupon de descuento

## Estructura principal

- `Orden`: componente base
- `OrdenBase`: implementacion concreta del componente
- `OrdenDecorator`: decorador abstracto
- `EnvioExpressDecorator`: decorador concreto
- `EmpaqueRegaloDecorator`: decorador concreto
- `CuponDescuentoDecorator`: decorador concreto
- `OrdenServicio`: fachada para construir ordenes
- `App`: demo de uso

## Checkpoints de verificacion

1. **Compilacion**
   - Comando: `mvn clean compile`
   - Esperado: `BUILD SUCCESS`

2. **Pruebas unitarias**
   - Comando: `mvn test`
   - Esperado: todas las pruebas en verde

3. **Verificacion funcional (manual)**
   - Comando: `mvn exec:java -Dexec.mainClass="com.universidad.tienda.App"`
   - Esperado: impresion de descripcion y costo final de una orden compuesta

## Cobertura de criterios de rubrica (evidencia tecnica)

1. **Aplicacion correcta del patron**
   - Se separa componente, decorador abstracto y decoradores concretos.
   - Se aplica composicion en vez de herencia rigida para extender comportamiento.

2. **Diseno orientado a objetos**
   - Validaciones de entrada para evitar estados invalidos.
   - Responsabilidades separadas por clase.

3. **Calidad y pruebas**
   - Casos base, acumulacion de decoradores, descuento y validaciones de error.
   - Verificacion de descripcion y costo final.

4. **Demostracion de uso**
   - Clase `App` con escenario completo de orden premium.

## Comandos utiles

- `mvn clean test`
- `mvn -q test`
