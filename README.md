# Proyecto: Patron Decorator en Java

Implementacion del patron de diseno **Decorator** siguiendo la estructura de clases solicitada en la guia del curso.

## Estructura principal

- `OrdenServicio`: Component (interface)
- `OrdenServicioBase`: ConcreteComponent
- `OrdenServicioDecorator`: Decorator abstracto
- `LoggingDecorator`: ConcreteDecorator 1
- `ValidacionDecorator`: ConcreteDecorator 2
- `AuditoriaDecorator`: ConcreteDecorator 3
- `App`: demo de uso

## Checkpoints de verificacion

1. **Compilacion**
   - Comando: `mvn clean compile`
   - Esperado: `BUILD SUCCESS`

2. **Pruebas unitarias**
   - Comando: `mvn test`
   - Esperado: todas las pruebas en verde

3. **Verificacion funcional (manual)**
   - Comando: `java -cp target/classes com.universidad.tienda.App`
   - Esperado: impresion de la cadena de procesamiento con decoradores

## Cobertura de criterios de rubrica (evidencia tecnica)

1. **Aplicacion correcta del patron**
   - Se separa componente, decorador abstracto y decoradores concretos.
   - Se aplica composicion en vez de herencia rigida para extender comportamiento.

2. **Diseno orientado a objetos**
   - Validaciones de entrada para evitar estados invalidos.
   - Responsabilidades separadas por clase.

3. **Calidad y pruebas**
   - Casos base, cadena de decoradores y validacion de errores por componente nulo.
   - Verificacion del orden de aplicacion de decoradores.

4. **Demostracion de uso**
   - Clase `App` con composicion de `LoggingDecorator`, `ValidacionDecorator` y `AuditoriaDecorator`.

## Comandos utiles

- `mvn clean test`
- `mvn -q test`
