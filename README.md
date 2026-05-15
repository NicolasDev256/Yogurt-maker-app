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

```
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

---

## Taller 1
### Fase A: Configuración de Dependencias
Añade la biblioteca SpringDoc OpenAPI a tu archivo pom.xml (Maven)
• Reto: Identifica la dependencia correcta para Spring Boot 3.x
(generalmente springdoc-openapi-starter-webmvc-ui)
<img width="709" height="117" alt="Captura de pantalla 2026-05-15 173714" src="https://github.com/user-attachments/assets/6409fa21-8a61-4cff-9c17-f5d67335a739" />

### Verificación: Tras compilar, comprueba que puedes acceder a la interfaz
en: http://localhost:8080/swagger-ui/index.html
<img width="1344" height="626" alt="image" src="https://github.com/user-attachments/assets/5371e91a-0446-4b0d-b721-be4afb6e3d08" />
<img width="1342" height="618" alt="image" src="https://github.com/user-attachments/assets/9f21e1c1-1848-4534-94c7-fce1f8d8f964" />
<img width="1339" height="476" alt="image" src="https://github.com/user-attachments/assets/258e21b1-0960-4213-a965-6c50d5ef134b" />
<img width="1338" height="328" alt="image" src="https://github.com/user-attachments/assets/96d5e874-39e5-40d7-b85c-14495bb19c26" />

---

## Fase B: Enriquecimiento de la Documentación (Anotaciones)
No es suficiente con que aparezcan los endpoints; la documentación debe ser descriptiva. Debes aplicar las siguientes anotaciones en tus Controllers:

@Tag: Define un nombre y descripción para cada módulo (ej. "Gestión de Usuarios").

@Operation: Describe qué hace cada método (resumen y descripción detallada).

@ApiResponse: Documenta al menos dos escenarios por endpoint:

200 OK o 201 Created para éxito.

400 Bad Request o 404 Not Found para errores.

<img width="944" height="610" alt="image" src="https://github.com/user-attachments/assets/bd4c489e-dc6b-4c18-9e7a-5acecd8bf8de" />

---

<img width="963" height="602" alt="image" src="https://github.com/user-attachments/assets/108a2449-47ff-4e01-bf08-40240e5e811d" />

---

<img width="967" height="604" alt="image" src="https://github.com/user-attachments/assets/5566d59f-38b3-44ff-8186-adf823236a6c" />

---

### @Schema: Ve a tus clases DTO/Entity y añade descripciones a los atributos (ej. "ID único del usuario", "Correo electrónico en formato válido").

<img width="756" height="501" alt="Captura de pantalla 2026-05-15 180330" src="https://github.com/user-attachments/assets/92e416e0-9b45-495e-ab3b-661babbf6b03" />

---

<img width="546" height="342" alt="image" src="https://github.com/user-attachments/assets/5ab028c3-5ab3-42ba-af47-1f696f918c94" />

---


<img width="596" height="553" alt="image" src="https://github.com/user-attachments/assets/aef75175-0066-46f3-9771-7f487dcd38a1" />

---

<img width="884" height="601" alt="image" src="https://github.com/user-attachments/assets/300dec3c-f418-45ef-af7b-6a55292465c3" />

---

<img width="597" height="157" alt="image" src="https://github.com/user-attachments/assets/a918a813-f472-45a7-96e7-306d82fbcd17" />

---

## Fase C: Pruebas Funcionales desde Swagger
Una vez documentada, utiliza la interfaz de Swagger para:

Realizar una petición POST exitosa.
<img width="1314" height="621" alt="image" src="https://github.com/user-attachments/assets/e3f511cd-dff7-49bc-a1cd-491d9c3f0408" />

---

Realizar una petición GET para verificar que el dato se guardó.
<img width="1316" height="429" alt="image" src="https://github.com/user-attachments/assets/833e2fc1-7d37-4235-ad6a-e358590a9c5b" />

---

<img width="1311" height="532" alt="image" src="https://github.com/user-attachments/assets/363115fc-2bfd-4f3e-bc8d-52a67e960a34" />

---

## Taller 2
### Fase B
Utiliza una herramienta de modelado (Mermaid.js, Lucidchart, Draw.io o StarUML) para crear el diagrama siguiendo estos estándares:

Anotaciones: Representa las anotaciones de Spring (como @Service, @RestController) como stereotypes (ej: «RestController»).

Relaciones: * Usa Inyección de Dependencias (flechas de asociación) para mostrar cómo el Controller usa al Service, y el Service al Repository.

Usa Herencia/Implementación (flechas con punta hueca) para las interfaces de los Repositorios.

Multiplicidad: Si tus entidades tienen relaciones (@OneToMany, @ManyToOne), especifica la cardinalidad (1..*, 0..1).

<img width="2481" height="2560" alt="WhatsApp Image 2026-05-15 at 6 37 50 PM" src="https://github.com/user-attachments/assets/45581961-680a-49b6-ad41-bbc8a9aa9ac5" />

---

### Fase C
Justificación Técnica 
Escribe una breve descripción (máximo 200 palabras) explicando por qué decidiste separar la lógica en esas capas y cómo se refleja el principio de Responsabilidad Única en tu diagrama. 
R// separe el proyecto en capas porque si metia todo en un solo sitio despues iba a ser un problema mantenerlo, por eso en el diagrama se ve que el controlador solo recibe peticiones, el servicio hace toda la logica de produccion y los repositorios solo hablan con la base de datos. 
Por ejemplo TemperatureControlService lo saque aparte porque controlar temperaturas no es lo mismo que gestionar lotes, si mezclaba todo esa clase se volvia gigante y tocar una cosa afectaba la otra.
El principio de responsabilidad unica en el diagrama:  
el controlador cambia si cambia la API, el servicio si cambia la receta o los tiempos de produccion y los repositorios si cambia la base de datos, cada clase tiene un solo trabajo

---

### Archivo Fuente: El archivo editable (ej. .drawio, .md para Mermaid) para verificar la autoría.
classDiagram
    class YogurtBatchController <<RestController>> {
        +startNewBatch()
        +startHeating()
        +startInoculating()
        +startIncubation()
        +startRefrigeration()
        +completeBatch()
        +markAsFailed()
        +getAllBatches()
        +getBatch()
        +recordTemperature()
    }
     class YogurtMakingService <<Service>> {
        +startNewBatch()
        +startHeating()
        +startInoculating()
        +startIncubation()
        +startRefrigeration()
        +completeBatch()
        +markAsFailed()
        +getBatch()
        +getAllBatches()
        +getBatchesByStatus()
        +recordTemperature()
    }
     class TemperatureControlService <<Service>> {
        +startHeatingProcess()
        +startIncubationControl()
        +getCurrentTemperature()
    }
    class YogurtBatchRepository <<Repository>>
    class RecipeRepository <<Repository>>
    class TemperatureLogRepository <<Repository>>
    class JpaRepository
    
  class Recipe {
        +id
        +name
        +defaultMilkVolume
        +defaultStarterAmount
        +heatingTemperature
        +heatingDuration
        +inoculationTemperature
        +incubationTemperature
        +minIncubationTime
        +maxIncubationTime
        +refrigerationTime
    }
    class YogurtBatch {
        +id
        +batchCode
        +status
        +milkVolume
        +starterAmount
        +targetTemperature
        +incubationTime
        +startTime
        +incubationStartTime
        +incubationEndTime
        +refrigerationStartTime
        +createdAt
        +updatedAt
    }
    class TemperatureLog {
        +id
        +temperature
        +recordedAt
        +type
    }
    YogurtBatchController --> YogurtMakingService : inyección de dependencia
    YogurtMakingService --> YogurtBatchRepository : inyección de dependencia
    YogurtMakingService --> RecipeRepository : inyección de dependencia
    YogurtMakingService --> TemperatureLogRepository : inyección de dependencia
    YogurtMakingService --> TemperatureControlService : delega control de temperatura
    TemperatureControlService --> TemperatureLogRepository : inyección de dependencia
    TemperatureControlService --> YogurtBatchRepository : persiste cambios de estado

  YogurtBatchRepository ..|> JpaRepository
    RecipeRepository ..|> JpaRepository
    TemperatureLogRepository ..|> JpaRepository

   Recipe "1" o-- "0..*" YogurtBatch : recipe
    YogurtBatch "1" o-- "0..*" TemperatureLog : temperatureLogs














