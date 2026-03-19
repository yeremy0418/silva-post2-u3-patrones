# Proyecto: Patron Decorator en Java

Implementacion del patron de diseno **Decorator** siguiendo la estructura de clases solicitada en la guia del curso.

## Estructura principal

- `OrdenServicio`: Component (interface)
- `OrdenServicioBase`: ConcreteComponent
- `OrdenServicioDecorator`: Decorator abstracto
- `LoggingDecorator`: ConcreteDecorator 1
- `ValidacionDecorator`: ConcreteDecorator 2
- `AuditoriaDecorator`: ConcreteDecorator 3
- `DecoratorConfig`: composicion de la cadena `Auditoria -> Validacion -> Log -> Base`
- `NotificacionFacade`: fachada para notificar en Email, SMS y Push

## Checkpoints de verificacion

1. **Compilacion**
   - Comando: `mvn clean compile`
   - Esperado: `BUILD SUCCESS`

2. **Pruebas unitarias**
   - Comando: `mvn test`
   - Esperado: todas las pruebas en verde

3. **Verificacion funcional (tests automatizados)**
   - Comando: `mvn test`
   - Esperado: pruebas del patron Decorator y Facade en verde

## Cobertura de criterios de rubrica (evidencia tecnica)

1. **Aplicacion correcta del patron**
   - Se separa componente, decorador abstracto y decoradores concretos.
   - Se aplica composicion en vez de herencia rigida para extender comportamiento.

2. **Diseno orientado a objetos**
   - Validaciones de entrada para evitar estados invalidos.
   - Responsabilidades separadas por clase.

3. **Calidad y pruebas**
   - Casos base, cadena de decoradores y validacion de datos invalidos.
   - Verificacion de propagacion de excepciones y del facade de notificaciones.

4. **Demostracion de uso**
   - Pruebas JUnit 5 como evidencia ejecutable de composicion y comportamiento.

## Comandos utiles

- `mvn clean test`
- `mvn -q test`
