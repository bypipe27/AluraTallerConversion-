# Conversor de Monedas

Este proyecto es una aplicación en Java que permite realizar conversiones de monedas utilizando tasas de cambio obtenidas de una API externa. El programa ofrece un menú interactivo para que el usuario seleccione las monedas a convertir y realice los cálculos correspondientes.

---

## **¿Qué hace cada parte del programa?**

### **1. Clase `Main`**
Es el punto de entrada del programa. Aquí se realiza lo siguiente:
- **Menú interactivo**: Muestra las opciones disponibles para convertir monedas.
- **Conexión a la API**: Obtiene las tasas de cambio actualizadas desde la API `ExchangeRate-API`.
- **Lógica de conversión**: Según la opción seleccionada, calcula el valor convertido utilizando las tasas de cambio.
- **Resultados**: Muestra el resultado de la conversión al usuario.

### **2. Clase `Monedachange`**
- Representa la estructura de los datos obtenidos de la API.
- Contiene:
    - `base_code`: La moneda base (en este caso, USD).
    - `conversion_rates`: Un mapa con las tasas de cambio para diferentes monedas.

### **3. Clase `Moneda`**
- Es una clase auxiliar que no se utiliza directamente en el flujo principal.
- Contiene información sobre una moneda, como su nombre (`moneda`), sus valores (`valor`) y la moneda base (`base`).

### **4. Clase `Calculadora`**
- Contiene el método estático `convertir`, que realiza el cálculo de la conversión.
- **Parámetros**:
    - `cantidad`: La cantidad de dinero a convertir.
    - `tasaCambio`: La tasa de cambio obtenida de la API.
    - `esInversa`: Indica si la conversión es inversa (por ejemplo, de ARS a USD).
- **Resultado**: Devuelve el valor convertido.

---

## **¿Cómo funciona el programa?**

1. **Inicio**: El programa muestra un menú con las opciones de conversión disponibles.
2. **Selección de opción**: El usuario elige la conversión que desea realizar.
3. **Conexión a la API**: El programa obtiene las tasas de cambio actualizadas.
4. **Cálculo**: Según la opción seleccionada, calcula el valor convertido.
5. **Resultado**: Muestra el resultado al usuario.

---

## **Opciones del menú**

1. **Dólar -> Peso Argentino**
2. **Peso Argentino -> Dólar**
3. **Dólar -> Real Brasileño**
4. **Real Brasileño -> Dólar**
5. **Dólar -> Peso Colombiano**
6. **Peso Colombiano -> Dólar**
7. **Salir**

---

## **Requisitos**

- **Java 17 o superior**.
- **Dependencias**:
    - `Gson`: Para procesar el JSON de la API.
    - **Conexión a Internet**: Para obtener las tasas de cambio desde la API.

---

## **Estructura del proyecto**

```
src/
├── com/alura/conversor/Modelo/
│   ├── Calculadora.java
│   ├── Monedachange.java
│   ├── Moneda.java
├── com/alura/conversor/principal/
│   ├── Main.java
```
---

## **Ejemplo de uso**

1. Ejecuta el programa.
2. Selecciona una opción del menú (por ejemplo, `1` para convertir de Dólar a Peso Argentino).
3. Ingresa la cantidad a convertir.
4. El programa mostrará el resultado de la conversión.

---
