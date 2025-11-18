# TrabajoFinal_Laboratorio
# CineCentro 
- Institución: Universidad de La Punta (ULP)
- Materia: Laboratorio de Programación I
- Año: 2025
- Integrantes (comisión 1, grupo 11):
  
  - Mauricio Reta
  - Juan Cruz Rodriguez
  - Agustín Mazza
  - Jeremías Hoyo
  - Facundo Lopez Cozzella
  - Jeremías Sirur Flores
  


## Descripción
Aplicación desktop desarrollada en Java con interfaz Swing para la gestión y venta de entradas en un cine multisala. Incluye cartelera, selección de funciones, mapa de butacas en tiempo real y emisión de tickets.

## Tecnologías
- Java JDK 24
- Java Swing
- MySQL 8.0 + JDBC
- Patrón DAO + Singleton para conexión
- NetBeans IDE

## Esquema de Base de Datos (`cinemacentro`)

| Tabla          | Clave Primaria   | Campos principales                                           | Relaciones                  |
|----------------|------------------|--------------------------------------------------------------|-----------------------------|
| pelicula       | idPelicula (int) | título, director, actores, género, estreno, enCartelera      |                             |
| sala           | nroSala (int)    | capacidad, apta3D, es3D, estado                              |                             |
| proyeccion     | codAsiento (int) | idioma, subtitulada, horario, precioDelLugar, lugaresDisponibles | → pelicula, → sala          |
| comprador      | dni (int)        | nombre, fechaNac, password, medioDePago, estado              |                             |
| ticketcompra   | codTicket (int)  | fechaCompra, fechaFuncion, monto                             | → comprador                 |
| detalleticket  | codD (int)       | funcion, cant, subTotal, codAsiento, codAsiento2             | → ticketcompra, → proyeccion|

> El diseño actual utiliza `codAsiento` como PK en `proyeccion` (limitación conocida). El sistema funciona correctamente dentro del alcance del proyecto.

## Funcionalidades Principales
- Registro y login de compradores
- Cartelera dinámica (solo películas con `enCartelera = 1`)
- Selección de proyección (película + horario + sala)
- Mapa visual de asientos con disponibilidad en tiempo real
- Compra de 1 a 6 entradas (contiguas o no)
- Generación automática de ticket y detalle de compra
- Actualización inmediata de lugares disponibles
- Persistencia completa de todas las operaciones

## Estado
Proyecto 100 % funcional  
Código limpio, comentado y organizado  
Base de datos completa y normalizada dentro del alcance  
Listo para presentación y entrega final
