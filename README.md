
# Monexchange

Monexchange es una aplicación para gestionar el intercambio de divisas. 
El proyecto proporciona funcionalidades para convertir monedas, gestionar tasas de cambio y manejar operaciones relacionadas.

## Características

- **Conversión de monedas**: Calcula tasas de cambio entre distintas divisas.
- **Gestión de operaciones**: Registro y validación de operaciones de intercambio.
- **Excepciones personalizadas**: Manejo de errores diseñado para un flujo eficiente y seguro.

## Requisitos del Sistema

- **Java**: Versión 11 o superior
- **Maven**: Versión 3.6.3 o superior

## Estructura del Proyecto

```
Monexchange/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org.exchange/
│   │   │       ├── controller/
│   │   │       ├── exception/
│   │   │       ├── model/
│   │   │       └── view/
│   │   └── resources/
│   ├── test/
├── pom.xml
└── README.md
```

- **`controller`**: Contiene los controladores principales`.
- **`model`**: Define las clases de datos y modelos de negocio.
- **`view`**: Manejo de la interfaz o representación de datos.
- **`exception`**: Manejo de excepciones personalizadas para el proyecto.

## Configuración

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/usuario/Monexchange.git
   ```
2. **Construir el proyecto**:
   Navega al directorio raíz del proyecto y ejecuta:
   ```bash
   mvn clean install
   ```
3. **Ejecutar el programa**:
   ```bash
   java -jar target/Monexchange-1.0.jar
   ```

## Uso

### Conversión de divisas
Utiliza los métodos expuestos en el controlador `RateExchangeMoney.java` para realizar conversiones entre diferentes divisas.

### Operaciones
Gestiona las operaciones de intercambio utilizando las clases en `Operation.java`.

## Licencia

Este proyecto está licenciado bajo la [Licencia MIT](LICENSE).
