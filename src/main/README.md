# 🚗 Gestión de Coches y Concesionarios

Aplicación backend desarrollada con **Spring Boot** que permite gestionar coches y concesionarios mediante una API REST.

El sistema implementa operaciones **CRUD completas** sobre tres entidades relacionadas:

- 🚘 Coches
- 🏢 Concesionarios
- 🔗 Relación Coches–Concesionarios (Many-to-Many)

---


## 🗂 Estructura de la Base de Datos

La aplicación trabaja con tres tablas:

### 1️⃣ Tabla: `coches`

Contiene la información de los vehículos.

| Campo  | Tipo   | Descripción |
|--------|--------|------------|
| id_coche     | Int   | Identificador único |
| marca  | String | Marca del coche |
| modelo | String | Modelo del coche |
| foto | String | foto del coche |

---

### 2️⃣ Tabla: `concesionarios`

Contiene la información de los concesionarios.

| Campo  | Tipo   | Descripción              |
|--------|--------|--------------------------|
| id_concesionario     | Int   | Identificador único      |
| nombre | String | Nombre del concesionario |
| ubicacion | String | ubicacion del concesionario               |

---

### 3️⃣ Tabla: `coches_concesionarios`

Tabla intermedia que representa la relación **Many-to-Many** entre coches y concesionarios.

| Campo              | Tipo | Descripción |
|-------------------|------|------------|
| coche_id          | Int | Clave foránea hacia coches |
| concesionario_id  | Int | Clave foránea hacia concesionarios |

---

### 4️⃣ Tabla: `depreciaciones`

Tabla que almacena la información de depreciación asociada a un coche.

Cada registro representa la evolución de los valores de depreciación de un coche concreto.

| Campo            | Tipo | Descripción |
|------------------|------|------------|
| id_depreciacion  | Int  | Identificador único de la depreciación |
| coche_fk         | Int  | Clave foránea hacia la tabla coches |
| valores          | JSON | Lista de valores de depreciación almacenados en formato JSON |


---
### 5️⃣ Tabla: `notas`

Tabla que almacena las notas asociadas a un coche.

Cada registro representa un comentario o nota sobre un coche específico.

| Campo      | Tipo   | Descripción |
|------------|--------|------------|
| id_nota    | Int    | Identificador único de la nota |
| coche_fk   | Int    | Clave foránea hacia la tabla coches |
| texto      | String | Contenido de la nota (no puede estar vacío) |

---





# 🚀 Instrucciones para replicar la base de datos la Aplicación

## importar

- docker exec -i mysql-server mysql -u root -p1234 coches < coches.sql

---

## exportar

- docker exec -i mysql-server mysqldump --no-tablespaces -u root -p1234 coches > coches.sql

---

