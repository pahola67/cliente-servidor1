# 🎬 Catálogo de Películas

Este proyecto fue generado con **Angular CLI v18.0.4** y **Spring Boot 3.x**.  
Es una aplicación web que permite a los usuarios registrarse, iniciar sesión y gestionar una lista personal de películas.

---

## 📝 Descripción del Proyecto
El sistema sigue una arquitectura **cliente-servidor** y ofrece funcionalidades como:

- Registro e inicio de sesión de usuarios.
- Gestión de películas (**CRUD**): crear, ver, editar y eliminar.

---

## 💻 Tecnologías Utilizadas

### 🔹 Front-End (Cliente)
- Angular **17.3.x**
- TypeScript

### 🔹 Back-End (Servidor)
- Spring Boot **3.x**
- Java **17**
- Maven

### 🔹 Base de Datos
- MySQL **8.0**

---

## ✨ Características Principales

### 🔐 Autenticación
✔️ Registro de nuevos usuarios  
✔️ Inicio de sesión seguro  

### 🎬 Gestión de Películas (CRUD)
✔️ **Crear**: Formulario para agregar nuevas películas  
✔️ **Leer**: Lista de todas las películas registradas  
✔️ **Actualizar**: Editar detalles de películas  
✔️ **Eliminar**: Borrar películas de la base de datos  

---

## ✅ Requisitos y Versiones

Asegúrate de tener instaladas estas tecnologías:

- ☕ **Java (OpenJDK 17.0.16)**
- 🟢 **Node.js 20.19.4**
- 🅰️ **Angular CLI 18.0.4**
- 🗄️ **MySQL 8.0.x**
- 🌀 **Git 2.34.1**

---

## 📂 Estructura del Proyecto

```bash
.
├── cliente/        # Front-End (Angular)
│   ├── src/
│   │   ├── app/
│   │   │   ├── components/
│   │   │   │   ├── pelicula/
│   │   │   │   │   ├── agregar/ # Formulario para agregar películas
│   │   │   │   │   └── listar/  # Lista de películas
│   │   │   │   └── usuario/     # Registro e inicio de sesión
│   │   │   ├── model/      # Modelos de datos (Pelicula, Usuario)
│   │   │   ├── service/    # Servicios (HTTP con el back-end)
│   │   │   └── ...
│   ├── package.json
│   └── ...
├── servidor/       # Back-End (Spring Boot)
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/categoriapelicula/
│   │   │   │   ├── controller/   # Endpoints REST
│   │   │   │   ├── model/        # Entidades JPA
│   │   │   │   ├── repository/   # Repositorios
│   │   │   │   ├── service/      # Lógica de negocio
│   │   │   │   └── CategoriapeliculaApplication.java
│   │   │   └── resources/
│   │   │       └── application.properties # Configuración DB
│   ├── pom.xml
│   └── ...
└── README.md
```
---
### Back-End
🧠 Explicación de la Estructura

cliente/src/app/components/ → Componentes visuales (películas, usuarios).
cliente/src/app/model/ → Modelos de datos (pelicula.ts, usuario.ts).
cliente/src/app/service/ → Servicios HTTP para conectarse con el backend.
servidor/src/main/java/... → Controllers, services, repositories y entidades.
application.properties → Configuración de la conexión MySQL.

---
🛠️ Instrucciones de Configuración y Ejecución
### 1️⃣ Configurar el Back-End (Spring Boot)
cd servidor

### Editar src/main/resources/application.properties:

spring.application.name=categoriaPelicula
spring.datasource.url=jdbc:mysql://localhost:3306/catalogo_pelicula
spring.datasource.username=tu_usuario_mysql
spring.datasource.password=tu_contraseña_mysql
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

**Ejecutar con Maven:**
mvn spring-boot:run

## 1️⃣ Verifica tu pom.xml
Asegurarse que el po.Xml tenga todas las dependencia como esta:
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope> <!-- COLOCAR -->
</dependency> 

## 2️⃣ Limpia y actualiza Maven
*mvn clean
*mvn install
*mvn dependency:resolve

## 3️⃣ Errores comunes

*Olvidar el MySQL Connector → falla la conexión a la DB.
*Usar versión de Spring Boot incompatible con Java → errores de compilación.
Dependencias duplicadas → conflictos de clases.

