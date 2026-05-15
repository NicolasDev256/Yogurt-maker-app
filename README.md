#  Sistema de Producción de Yogur

Sistema backend para la gestión de producción de yogur: recetas, lotes, temperaturas y estadísticas 
Construido con **Spring Boot 4.0.3** y **Java 25**

---

## Tecnologías utilizadas

- Java 25
- Spring Boot 4.0.3
- Spring Data JPA / Hibernate
- H2 Database
- Lombok
- springdoc-openapi (Swagger)
- Maven Wrapper 3.9.12

---

## Instalación y ejecución

### Requisitos previos
- JDK 25 instalado
- Git (opcional, para clonar)

---

### Pasos

```bash
# Clonar el repositorio
git clone https://github.com/NicolasDev256/Yogurt-maker-app.git
cd Yogurt-maker-app

# Ejecutar la aplicación
# En Windows:
mvnw.cmd spring-boot:run

# En Linux / Mac:
./mvnw spring-boot:run

---

## Accesos importantes

| Recurso | URL |
| API base | `http://localhost:8083` |
| Consola H2 | `http://localhost:8083/h2-console` |
| Swagger UI | `http://localhost:8083/swagger-ui.html` |

---

## Endpoints principales

| Método | Endpoint | Descripción |
| POST | `/api/recipes` | Crear receta |
| GET | `/api/recipes` | Listar recetas activas |
| POST | `/api/batches` | Iniciar nuevo lote |
| POST | `/api/batches/{batchId}/heating` | Comenzar calentamiento |
| POST | `/api/batches/{batchId}/incubation` | Comenzar incubación |
| POST | `/api/batches/{batchId}/complete` | Completar lote |
| GET | `/api/monitoring/dashboard` | Ver estadísticas globales |

Documentación completa en Swagger: `http://localhost:8083/swagger-ui.html`

---

## Flujo típico de producción

1.Crear receta (o usar una existente) → POST /api/recipes

2.Iniciar lote → POST /api/batches

3.Calentar → POST /api/batches/{id}/heating

  ºEl sistema simula el aumento gradual de temperatura y lo registra.

4.Enfriar (automático hasta temperatura de inoculación)

5.Inocular → POST /api/batches/{id}/inoculating

6.Incubar → POST /api/batches/{id}/incubation

  ºControl automático de temperatura durante el tiempo indicado.

7.Refrigerar → POST /api/batches/{id}/refrigeration

8.Completar → POST /api/batches/{id}/complete

Todos los cambios de temperatura quedan registrados en temperature_logs y se pueden consultar con los endpoints de monitoreo.
```

### Licencia
Este proyecto está bajo la licencia Apache 2.0. Consulta el archivo LICENSE para más detalles.

## Taller 1
### Fase A: Configuración de Dependencias
Añade la biblioteca SpringDoc OpenAPI a tu archivo pom.xml (Maven)
• Reto: Identifica la dependencia correcta para Spring Boot 3.x
(generalmente springdoc-openapi-starter-webmvc-ui)
<img width="709" height="117" alt="Captura de pantalla 2026-05-15 173714" src="https://github.com/user-attachments/assets/6409fa21-8a61-4cff-9c17-f5d67335a739" />





