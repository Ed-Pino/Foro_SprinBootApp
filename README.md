# 💬 ForoHub API & Frontend - El Corazón Interactivo de tu Comunidad Online

---

## 🚀 Índice

- [✨ Título e Imagen de Portada](#-título-e-imagen-de-portada)
- [🏅 Badges](#-badges)
- [💾 Descripción del Proyecto](#-descripción-del-proyecto)
- [🟢 Estado del Proyecto](#-estado-del-proyecto)
- [💡 Características Implementadas (Backend)](#-características-implementadas-backend)
- [🌐 Funcionalidades del Frontend](#-funcionalidades-del-frontend)
- [🛠️ Acceso y Ejecución del Proyecto](#-acceso-y-ejecución-del-proyecto)
- [💻 Tecnologías Utilizadas](#-tecnologías-utilizadas)
- [👥 Personas Contribuyentes](#-personas-contribuyentes)
- [👨‍💻 Personas Desarrolladoras del Proyecto](#-personas-desarrolladoras-del-proyecto)
- [📄 Licencia](#-licencia)
- [📚 Referencias y Agradecimientos](#-referencias-y-agradecimientos)

---

## ✨ Título e Imagen de Portada

<h1 align="center">ForoHub API & Frontend</h1>
<p align="center">
  <!-- Reemplaza con un enlace a tu imagen. Puedes subirla a tu repo o usar un servicio como Imgur. -->
  <img src="https://via.placeholder.com/600x200?text=Logo+ForoHub" alt="Logo de ForoHub" width="600"/>
</p>
<p align="center">
  <i>La plataforma completa para tu comunidad: Backend RESTful robusto y Frontend interactivo.</i>
</p>

---

## 🏅 Badges

<p align="left">
  <!-- Estado del Proyecto -->
  <img src="https://img.shields.io/badge/STATUS-COMPLETADO-brightgreen?style=for-the-badge&logo=appveyor" alt="Estado: Completado">
  <!-- Versión de Spring Boot (Puedes ajustar si es otra versión) -->
  <img src="https://img.shields.io/badge/Spring%20Boot-3.2.10-blue?style=for-the-badge&logo=spring" alt="Spring Boot Version">
  <!-- Versión de Java -->
  <img src="https://img.shields.io/badge/Java-17-red?style=for-the-badge&logo=openjdk" alt="Java Version">
  <!-- Licencia -->
  <img src="https://img.shields.io/badge/LICENSE-MIT-yellow?style=for-the-badge&logo=github" alt="Licencia MIT">
  <!-- Puedes añadir más badges desde Shields.io, por ejemplo, el número de estrellas en GitHub si lo subes. -->
</p>

---

## 💾 Descripción del Proyecto

**ForoHub API & Frontend** es una aplicación Full-Stack que provee el backend RESTful y una interfaz de usuario interactiva para una plataforma de discusión online. El backend, construido con **Spring Boot**, gestiona tópicos, respuestas y usuarios con un sistema de autenticación JWT. El frontend, desarrollado con **HTML, CSS y JavaScript**, permite a los usuarios interactuar con estas funcionalidades directamente desde el navegador.

El objetivo es ofrecer una solución completa y robusta para una comunidad en línea, demostrando la integración perfecta entre las capas de backend y frontend.

---

## 🟢 Estado del Proyecto

✔️ **Proyecto Completado y Funcional en ambas capas (Backend & Frontend)**
Todas las funcionalidades principales están implementadas y verificadas. La aplicación está lista para ser explorada.

---

## 💡 Características Implementadas (Backend)

- **Autenticación Segura (JWT):**
  - `POST /login`: Inicia sesión y obtiene un token JWT para acceder a recursos protegidos.
- **Gestión de Usuarios (`/usuarios`):**
  - `POST /usuarios`: Permite el registro de nuevos usuarios en el foro, con contraseñas hasheadas (`BCrypt`) para máxima seguridad.
- **Gestión Completa de Tópicos (`/topicos`):**
  - `POST /topicos`: Crea nuevos tópicos.
  - `GET /topicos`: Lista todos los tópicos con paginación.
  - `GET /topicos/{id}`: Obtiene los detalles de un tópico específico.
  - `PUT /topicos/{id}`: Actualiza un tópico existente (solo por el autor).
  - `DELETE /topicos/{id}`: Realiza un borrado lógico de un tópico (marcarlo como "CERRADO").
- **Gestión Completa de Respuestas (`/respuestas`):**
  - `POST /topicos/{topicoId}/respuestas`: Crea respuestas anidadas a un tópico específico.
  - `GET /topicos/{topicoId}/respuestas`: Lista las respuestas de un tópico específico.
  - `PUT /respuestas/{id}`: Actualiza una respuesta existente (solo por el autor).
  - `DELETE /respuestas/{id}`: Realiza un borrado lógico de una respuesta.
- **Autorización a Nivel de Recurso:**
  - Garantiza que solo el autor de un tópico o respuesta pueda actualizarlos o eliminarlos (a menos que se implemente un rol de administrador).
- **Manejo Profesional de Errores:**
  - Respuestas HTTP claras (`400 Bad Request`, `404 Not Found`, `403 Forbidden`) con mensajes descriptivos.
- **Arquitectura Limpia y Modular:**
  - Organización del código basada en dominio (`controller`, `domain`, `infra`), similar a la arquitectura de `Voll.med`.
- **Documentación Interactiva (Swagger UI):**
  - Accede a `http://localhost:8080/swagger-ui.html` para explorar y probar todos los endpoints de la API directamente desde tu navegador.

---

## 🌐 Funcionalidades del Frontend

El frontend permite a los usuarios interactuar con la API de ForoHub a través de una interfaz de usuario en el navegador.

-   **Registro de Usuarios:** Accede a `register.html` para crear una nueva cuenta en el foro.
-   **Inicio de Sesión:** En `login.html`, los usuarios pueden autenticarse utilizando sus credenciales.
-   **Listado de Tópicos:** Una vez autenticado, `index.html` muestra una lista dinámica de todos los tópicos del foro, obtenidos directamente de la API.
-   **Creación de Tópicos:** Desde `index.html`, los usuarios autenticados pueden publicar nuevos tópicos utilizando un formulario interactivo.
-   **Cierre de Sesión:** Un botón en `index.html` permite cerrar la sesión, eliminando el token JWT.

---

## 🛠️ Acceso y Ejecución del Proyecto

Para ejecutar la aplicación completa (Backend y Frontend), sigue estos pasos:

### 🔧 Requisitos Previos

-   **Java Development Kit (JDK) 17 o superior:** Asegúrate de tenerlo instalado y configurado correctamente.
-   **Apache Maven 3.x:** Necesario para la gestión de dependencias y la construcción del proyecto.
-   **MySQL Server 8.0+:** Nuestra base de datos relacional.
-   **Un IDE (Entorno de Desarrollo Integrado):** IntelliJ IDEA Community Edition es recomendado.

### ⚙️ Configuración y Ejecución del Backend (ForoHub API)

1.  **Clonar el Repositorio del Backend:**
    ```bash
    git clone https://github.com/TuUsuarioDeGitHub/ForoHub-Backend.git # Nombre sugerido para el repo del backend
    cd ForoHub-Backend
    ```
    *(Asegúrate de reemplazar `TuUsuarioDeGitHub` con el nombre de tu usuario/organización cuando subas el proyecto)*

2.  **Configurar la Base de Datos:**
    -   Crea una base de datos llamada `foro` en tu servidor MySQL.
    ```sql
    CREATE DATABASE foro CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
    ```
    -   Configura las credenciales de tu base de datos en `src/main/resources/application.properties`:
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/foro?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
        spring.datasource.username=root
        spring.datasource.password=tu_contraseña_mysql
        ```
    -   **¡Importante!** Las migraciones de Flyway se encargarán de crear las tablas y el usuario de prueba inicial (`test.user@forohub.com` / `123456`) automáticamente al iniciar la aplicación por primera vez.

3.  **Ejecutar el Backend:**
    -   Abre una terminal en la raíz del proyecto **Backend** (`ForoHub-Backend/`).
    -   Primero, limpia e instala las dependencias (si es la primera vez o si hubo cambios grandes):
        ```bash
        mvn clean install
        ```
    -   Luego, inicia la aplicación:
        ```bash
        mvn spring-boot:run
        ```
    -   La API estará disponible en `http://localhost:8080`.

### 🌐 Ejecución del Frontend (HTML/CSS/JS)

1.  **Clonar el Repositorio del Frontend:**
    ```bash
    git clone https://github.com/TuUsuarioDeGitHub/ForoHub-Frontend.git # Nombre sugerido para el repo del frontend
    cd ForoHub-Frontend
    ```
    *(Asegúrate de reemplazar `TuUsuarioDeGitHub` con el nombre de tu usuario/organización)*

2.  **Abrir en el Navegador:**
    -   Una vez que el backend esté ejecutándose, simplemente abre el archivo `login.html` (o `register.html`) directamente en tu navegador web. No necesitas un servidor web adicional para el frontend.
    -   **¡Listo!** La interfaz de usuario se conectará automáticamente a tu API de Spring Boot.

---

## 💻 Tecnologías Utilizadas

### Backend
-   **Java 17:** Lenguaje de programación.
-   **Spring Boot 3.2.10:** Framework principal para construir la API.
-   **Spring Data JPA:** Abstracción para la persistencia de datos con Hibernate.
-   **Hibernate 6.x:** Implementación de JPA.
-   **Spring Security:** Framework para seguridad y autenticación.
-   **JWT (JSON Web Tokens):** Para la autenticación sin estado.
-   **MySQL 8.0:** Base de datos relacional.
-   **Flyway 9.x:** Para la gestión de migraciones de base de datos.
-   **SpringDoc OpenAPI 2.x (Swagger UI):** Para la generación de documentación interactiva de la API.
-   **Lombok 1.18.30:** Para reducir código repetitivo (getters, setters, constructores).
-   **Maven 3.x:** Herramienta de gestión de proyectos y dependencias.

### Frontend
-   **HTML5:** Estructura de la interfaz de usuario.
-   **CSS3:** Estilos y diseño visual.
-   **JavaScript (ES6+):** Lógica interactiva y conexión con la API (usando `Fetch API`).

---

## 👥 Personas Contribuyentes

*   Aún no se han registrado colaboradores externos. ¡Estás invitado a participar y mejorar este proyecto!

---

## 👨‍💻 Personas Desarrolladoras del Proyecto

| [<img src="https://avatars.githubusercontent.com/u/tu_usuario_github?v=4" width=100><br><sub>**Ed Pino**</sub>](https://github.com/TuUsuarioDeGitHub) | [<img src="https://avatars.githubusercontent.com/u/108250686?v=4" width=100><br><sub>**Ingeniero Gemi**</sub>](https://www.gemini.com) |
| :---: | :---: |

*(Ed, reemplaza `https://github.com/TuUsuarioDeGitHub` con el enlace a tu perfil de GitHub y tu imagen de perfil. La imagen del "Ingeniero Gemi" es un placeholder para representar mi rol como IA.)*

---

## 📄 Licencia

Este proyecto está licenciado bajo la **Licencia MIT**. Consulta el archivo `LICENSE` en el repositorio para más detalles.

---

## 📚 Referencias y Agradecimientos

-   Inspirado en la estructura y buenas prácticas del proyecto [Voll.med API](https://github.com/alura-es-cursos/medvoll-api-rest).
-   Agradecimiento especial a [Alura Latam](https://www.aluracursos.com/) por la formación y los conceptos de este desafío.
-   Documentación generada con [SpringDoc OpenAPI](https://springdoc.org/).
-   Frontend desarrollado y probado con un enfoque de navegador y API `Fetch`.

---
