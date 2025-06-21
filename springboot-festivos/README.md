# Proyecto Spring Boot - Festivos

Este proyecto es una aplicación Spring Boot que gestiona días festivos en Colombia. Permite insertar registros en las tablas `Tipo` y `Festivo` utilizando JPA para la persistencia de datos.

## Estructura del Proyecto

La estructura del proyecto es la siguiente:

```
springboot-festivos
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── ejemplo
│   │   │           └── festivos
│   │   │               ├── FestivosApplication.java
│   │   │               ├── controller
│   │   │               ├── model
│   │   │               ├── repository
│   │   │               └── service
│   │   └── resources
│   │       ├── application.properties
│   │       └── data.sql
├── pom.xml
└── README.md
```

## Requisitos

- Java 11 o superior
- Maven

## Configuración

1. Clona el repositorio en tu máquina local.
2. Navega al directorio del proyecto.
3. Abre el archivo `src/main/resources/application.properties` y configura la conexión a tu base de datos.

## Ejecución

Para ejecutar la aplicación, utiliza el siguiente comando en la terminal:

```
mvn spring-boot:run
```

Esto iniciará la aplicación y podrás interactuar con ella a través de los endpoints que se implementarán en el controlador.

## Inserción de Datos

Los registros iniciales para las tablas `Tipo` y `Festivo` se insertarán automáticamente al iniciar la aplicación, utilizando el archivo `data.sql`.

## Contribuciones

Las contribuciones son bienvenidas. Si deseas mejorar el proyecto, por favor abre un issue o un pull request.

## Licencia

Este proyecto está bajo la Licencia MIT.