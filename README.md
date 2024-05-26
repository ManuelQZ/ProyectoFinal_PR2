# Productivity Palace Arcade

## Descripción del Proyecto

Productivity Palace Arcade es un sistema de gestión integral diseñado para un arcade que ofrece servicios de gaming y productos relacionados. El objetivo principal del sistema es facilitar la administración eficiente de usuarios, reservas, empleados, servicios, productos y pagos, proporcionando una experiencia fluida tanto para los usuarios como para los empleados.

## Características Principales

### Gestión de Usuarios
- **Registro de Usuarios:** Permite a los nuevos usuarios registrarse proporcionando su nombre, correo electrónico y saldo inicial.
- **Inicio de Sesión:** Los usuarios pueden autenticarse para acceder a sus cuentas.
- **Administración de Saldo:** Los usuarios pueden ver y actualizar su saldo disponible.

### Gestión de Reservas
- **Creación de Reservas:** Los usuarios pueden realizar reservas para diferentes servicios ofrecidos por el arcade.
- **Consulta y Modificación:** Permite ver detalles de las reservas, así como modificar o cancelar las reservas existentes.

### Gestión de Empleados
- **Registro de Empleados:** Los empleados pueden ser registrados con sus respectivos cargos y niveles de permisos.
- **Asignación de Tareas:** Los empleados pueden gestionar reservas y supervisar servicios.

### Gestión de Servicios
- **Definición de Servicios:** Administración de los servicios ofrecidos, incluyendo precios y disponibilidad.
- **Reserva de Servicios:** Los usuarios pueden reservar servicios disponibles.

### Gestión de Productos
- **Inventario de Productos:** Administración de los productos disponibles para la venta, incluyendo precios y cantidades disponibles.
- **Actualización de Inventario:** Modificación de la información de los productos y actualización de inventarios tras las ventas.

### Gestión de Pagos
- **Registro de Pagos:** Los usuarios pueden realizar pagos por servicios y productos adquiridos.
- **Historial de Pagos:** Consulta de los pagos realizados, incluyendo detalles como tipo de pago, monto y fecha.

## Arquitectura del Sistema

### Clases Principales

#### Usuario
- **Atributos:**
  - `nombre (String)`: Nombre del usuario.
  - `correoElectronico (String)`: Correo electrónico del usuario.
  - `saldo (Double)`: Saldo disponible del usuario.
- **Métodos:** Registro, inicio de sesión, administración de saldo.

#### Reserva
- **Atributos:**
  - `Usuario ()`: Referencia al usuario que realiza la reserva.
  - `Servicio ()`: Referencia al servicio reservado.
  - `fecha (String)`: Fecha de la reserva.
  - `estado ()`: Estado de la reserva.
- **Métodos:** Creación, modificación, cancelación de reservas.

#### Empleado
- **Atributos:**
  - `nombre (String)`: Nombre del empleado.
  - `cargo (String)`: Cargo del empleado.
  - `nivelPermisos ()`: Nivel de permisos del empleado.
- **Métodos:** Registro, gestión de permisos, supervisión de reservas.

#### Servicio
- **Atributos:**
  - `nombre (String)`: Nombre del servicio.
  - `precio (String)`: Precio del servicio.
  - `disponibilidadReserva (String)`: Disponibilidad del servicio para ser reservado.
- **Métodos:** Administración de servicios, consulta de disponibilidad.

#### Producto
- **Atributos:**
  - `nombre (String)`: Nombre del producto.
  - `precio (String)`: Precio del producto.
  - `cantidadDisponible (Integer)`: Cantidad disponible del producto.
- **Métodos:** Administración de productos, actualización de inventario.

#### Pago
- **Atributos:**
  - `tipoDePago (String)`: Tipo de pago realizado.
  - `monto (String)`: Monto del pago.
  - `fecha (String)`: Fecha del pago.
- **Métodos:** Registro y consulta de pagos.
