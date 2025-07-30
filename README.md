# 💬 ForoHub API - El Corazón de tu Comunidad Online

---

## 🚀 Índice

- [✨ Título e Imagen de Portada](#-título-e-imagen-de-portada)
- [🏅 Badges](#-badges)
- [💾 Descripción del Proyecto](#-descripción-del-proyecto)
- [🟢 Estado del Proyecto](#-estado-del-proyecto)
- [💡 Características Implementadas](#-características-implementadas)
- [🛠️ Acceso y Ejecución del Proyecto](#-acceso-y-ejecución-del-proyecto)
- [💻 Tecnologías Utilizadas](#-tecnologías-utilizadas)
- [👥 Personas Contribuyentes](#-personas-contribuyentes)
- [👨‍💻 Personas Desarrolladoras del Proyecto](#-personas-desarrolladoras-del-proyecto)
- [📄 Licencia](#-licencia)
- [📚 Referencias y Agradecimientos](#-referencias-y-agradecimientos)

---

## ✨ Título e Imagen de Portada

<h1 align="center">ForoHub API</h1>
<p align="center">
  <!-- Reemplaza con un enlace a tu imagen. Puedes subirla a tu repo o usar un servicio como Imgur. -->
  <img src="https://st2.depositphotos.com/3591429/5245/i/450/depositphotos_52451245-stock-illustration-hands-holding-speech-bubbles.jpg" alt="Logo de ForoHub" width="600"/>
</p>
<p align="center">
  <i>El motor RESTful para tu plataforma de discusión, robusto y seguro.</i>
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

**ForoHub API** es el proyecto de backend que sirve como la espina dorsal para una plataforma de discusión o foro online. Construida con **Spring Boot**, esta API RESTful proporciona un conjunto completo de operaciones (CRUD) para gestionar tópicos, respuestas y usuarios, todo ello protegido por un robusto sistema de autenticación basado en JSON Web Tokens (JWT).

El objetivo principal de ForoHub API es ofrecer una solución de backend limpia, segura y escalable para cualquier aplicación cliente (web o móvil) que necesite interactuar con datos de un foro.

---

## 🟢 Estado del Proyecto

✔️ **Proyecto Completado y Funcional**
El desarrollo de las funcionalidades principales y la arquitectura básica están finalizadas. La API está lista para ser consumida y extendida.

---

## 💡 Características Implementadas

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

## 🛠️ Acceso y Ejecución del Proyecto

### 🔧 Requisitos Previos

-   **Java Development Kit (JDK) 17 o superior:** Asegúrate de tenerlo instalado y configurado correctamente.
-   **Apache Maven 3.x:** Necesario para la gestión de dependencias y la construcción del proyecto.
-   **MySQL Server 8.0+:** Nuestra base de datos relacional.
-   **Un IDE (Entorno de Desarrollo Integrado):** IntelliJ IDEA Community Edition es recomendado.

### 🧬 Clonar y Configurar

1.  **Clonar el Repositorio:**
    ```bash
    git clone https://github.com/Ed-Pino/Foro_SprinBootApp.git
    cd ForoHub
    ```

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

### ▶️ Ejecutar el Proyecto

1.  **Limpiar e Instalar Dependencias (Primer Ejecución o Cambios Grandes):**
    Abre una terminal en la raíz del proyecto (`ForoHub/`) y ejecuta:
    ```bash
    mvn clean install
    ```
    Este comando descargará todas las dependencias y compilará el proyecto.

2.  **Iniciar la Aplicación:**
    Desde la misma terminal en la raíz del proyecto, ejecuta:
    ```bash
    mvn spring-boot:run
    ```
    La aplicación se iniciará en `http://localhost:8080`.

3.  **Acceder a la Documentación (Swagger UI):**
    Una vez que la aplicación esté corriendo, abre tu navegador y ve a:
    ```
    http://localhost:8080/swagger-ui.html
    ```
    Aquí podrás explorar y probar todos los endpoints.

---

## 💻 Tecnologías Utilizadas

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

---

## 👥 Personas Contribuyentes

*   Aún no se han registrado colaboradores externos. ¡Estás invitado a participar y mejorar este proyecto!

---

## 👨‍💻 Personas Desarrolladoras del Proyecto

| [<img src="https://avatars.githubusercontent.com/u/tu_usuario_github?v=4" width=100><br><sub>**Ed Pino**</sub>](https://github.com/TuUsuarioDeGitHub) | 
| :---: | :---: |

*(Ed`https://github.com/Ed-Pino/Foro_SprinBootApp.git`*

---

## 📄 Licencia

Este proyecto está licenciado bajo la **Licencia MIT**. Consulta el archivo `LICENSE` en el repositorio para más detalles.

---

## 📚 Referencias y Agradecimientos

-   Inspirado en la estructura y buenas prácticas del proyecto [Voll.med API](https://github.com/alura-es-cursos/medvoll-api-rest).
-   Agradecimiento especial a [Alura Latam](https://www.aluracursos.com/) por la formación y los conceptos de este desafío.
-   Documentación generada con [SpringDoc OpenAPI](https://springdoc.org/) y probada con [Insomnia](https://insomnia.rest/).

---
