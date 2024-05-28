# Tareas

1. Hacer el ultimo crud
2. Arreglar los dos cruds existentes
3. Hacer las 2 trasacciones

## Cruds
- [ ] `Reservas`.
- [ ] `Usuario`.
- [ ] `Servicio`.

## Transacciones
- [ ] Reserva de Servicio.
- [ ] Pago de servicio o Producto.

## Patrones creacionales
- [X] Builder -> Asignar atributos a `Usuario`.
- [X] Prototype -> Clonar `Reserva` ya existente.
- [X] Singleton -> Se implementa en el `ModelFactory` y en los controladores.

## Patrones comportamentales
- [X] Strategy -> Implementa diferentes extrategias para `Pago`.
- [X] Mediator -> `Mediator` Sirve de mediador entre los modelos y la vista.
- [X] Command -> Implementa comandos para crear distintos tipos de usuarios.

## Patrones estructurales
- [X] Proxy -> Se implementa en el login con la clase `Usuario`.
- [X] Facade -> fachada para Productivity Palace.
- [X] Bridge -> Se implementa para distribuir información en diferentes servicios de correo.