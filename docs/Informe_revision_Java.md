# Informe de revisión de proyectos Java

Fernando Sevilla | Programación Avanzada | 3 de noviembre de 2026

Se revisaron cinco archivos ZIP que corresponden a cuatro proyectos diferentes de NetBeans y Maven. Las correcciones permiten compilar los cuatro proyectos con Java 17 o superior y ejecutar sus pruebas. El resultado de la validación local fue de 14 pruebas aprobadas, sin fallos ni errores.

## Objetivo y alcance

Restablecer la compilación y el funcionamiento de los ejercicios originales, corregir los defectos encontrados en el manejo de colecciones, concurrencia y persistencia, y preparar una entrega reproducible con código, pruebas e informe. Se conservaron los nombres de los proyectos y los datos de ejemplo.

## Inventario revisado

| Proyecto | Pruebas |
|---|---:|
| ProcesamientoAsincrono | 3 |
| RepocitorioGenerico | 4 |
| RepositorioGenerico_Avanzada1 | 3 |
| SISTEMA-GESTION-DE-EMPLEADOS | 4 |

Los ZIP RepositorioGenerico_Avanzada1.zip y RepositorioGenerico_Avanzada1 (1).zip eran idénticos. Se trataron como una sola versión del ejercicio y ambos se actualizaron con el mismo contenido corregido.

# Errores encontrados y correcciones

## Configuración de los cuatro proyectos

Los archivos pom.xml pedían Java 26, mientras que el equipo dispone de JDK 23. Se estableció Java 17 como versión de compilación y se fijaron las versiones de los complementos Maven para compilar, ejecutar pruebas y lanzar la clase principal. También se corrigieron las clases principales declaradas que no existían o no coincidían con el código.

## ProcesamientoAsincrono

CuentaBancaria contenía errores de sintaxis, diferencias entre el nombre del archivo y la clase, y una importación de excepción incorrecta. Se reconstruyeron el constructor, el retiro y la consulta de saldo. El retiro y la lectura del saldo se sincronizan; se rechazan importes no finitos, negativos o nulos y se conserva el saldo al rechazar un retiro por fondos insuficientes.

Se añadió la clase principal que faltaba, con un ejecutor de dos hilos y dos retiros sobre la misma cuenta. Se espera el resultado de las tareas y se cierra el ejecutor al terminar. El retiro que consigue ejecutarse primero puede variar, por lo que el saldo final válido puede ser 300 o 500 para este ejemplo.

## Los dos repositorios genéricos

Deshacer eliminaba un elemento de la lista, pero dejaba la clave en el mapa. Las claves duplicadas también podían desincronizar las colecciones. La implementación corregida usa un LinkedHashMap para conservar el orden y una pila de claves para deshacer la inserción exacta. Se rechazan claves repetidas y elementos nulos; obtenerTodos devuelve una copia no modificable.

En la versión Avanzada1 se eliminó la llamada a setVisible sobre un repositorio de datos, que lanzaba UnsupportedOperationException. La creación de las ventanas se trasladó al hilo de eventos de Swing. En RepocitorioGenerico se corrigió además el manejo del registro de excepciones para evitar una conversión de tipo inválida.

## Sistema de gestión de empleados

Se alinearon los nombres de archivos, clases y paquetes; se añadió la importación de Serializable; se hizo público el método de guardado; y se definió la ruta del archivo mediante Path. El controlador ahora devuelve false ante errores de escritura, permite listar registros y rechaza textos con separadores e importes inválidos. La lectura comunica sus errores sin presentarlos como una lista vacía. El archivo usa UTF-8.

# Validación y resultados

## Procedimiento

Se ejecutó Maven clean test en cada proyecto utilizando el Maven incluido con NetBeans 25 y el JDK 23 instalado. La configuración compila el código con release 17. Las pruebas emplean JUnit 5 y las pruebas de archivos usan directorios temporales para mantener aislados los datos del ejercicio.

ProcesamientoAsincrono: 3 pruebas; 0 fallos; 0 errores. Resultado de Maven: BUILD SUCCESS.

RepocitorioGenerico: 4 pruebas; 0 fallos; 0 errores. Resultado de Maven: BUILD SUCCESS.

RepositorioGenerico_Avanzada1: 3 pruebas; 0 fallos; 0 errores. Resultado de Maven: BUILD SUCCESS.

SISTEMA-GESTION-DE-EMPLEADOS: 4 pruebas; 0 fallos; 0 errores. Resultado de Maven: BUILD SUCCESS.

## Casos de regresión

Cuenta bancaria: fondos insuficientes y monto faltante, retiro hasta saldo cero, rechazo de importes inválidos y 100 intentos concurrentes de retirar 25 sobre un saldo de 1000. Exactamente 40 retiros tienen éxito y el saldo termina en cero.

Repositorios: eliminación de la clave al deshacer, historial vacío, rechazo de claves duplicadas sin alterar los datos, mismo valor bajo claves diferentes y protección de la lista devuelta. RepocitorioGenerico comprueba además la conservación del nombre y las ventas de un producto.

Empleados: archivo inexistente, escritura y lectura posterior con caracteres acentuados, salario total, ruta de escritura inválida, rechazo de separadores y valores no finitos, y propagación explícita de errores de lectura.

## Ejecución de las clases principales de consola

La cuenta bancaria terminó sin excepción no controlada. En la ejecución comprobada, el retiro de 700 fue aceptado y el de 500 fue rechazado con un faltante de 200; el saldo final fue 300.

El sistema de empleados guardó y recuperó los dos registros de ejemplo con salarios totales de 17500 y 21000. La ejecución se realizó en una carpeta de prueba para evitar modificar los datos de trabajo originales.

## Límites de la comprobación

La compilación y las pruebas de los repositorios no equivalen a una revisión visual completa de las ventanas de Swing. El ejercicio bancario conserva double y no pretende ser un sistema financiero de producción. Los registros de empleados se anexan al archivo: ejecutar el ejemplo varias veces repite los registros. La clase coneccionDB sigue siendo un esqueleto sin conexión a base de datos, ajena a la demostración de retiros.

# Entrega y uso de los proyectos

## Abrir en NetBeans

Seleccionar Archivo y luego Abrir proyecto. Elegir la carpeta que contiene pom.xml dentro de cada directorio original. Los ZIP mantienen la estructura con la carpeta del proyecto en su interior. La copia ColeccionesVentas_Avanzada1 de un ejercicio anterior no forma parte de esta revisión.

## Comprobar y ejecutar

Desde la carpeta que contiene pom.xml, con JDK 17 o superior y Maven disponible, utilizar los siguientes comandos. NetBeans también permite ejecutar estas acciones desde el menú del proyecto.

```
mvn clean test
```

```
mvn exec:java
```

La primera ejecución requiere descargar las dependencias Maven. El sistema de empleados crea empleados.txt en el directorio de trabajo. Los dos proyectos de repositorio requieren un entorno gráfico para mostrar su ventana de ventas.

## Contenido de la entrega

Se incluye el código fuente de los cuatro proyectos, sus pruebas, instrucciones README, evidencia de Maven, un registro de cambios y este informe. Se conserva un ZIP de respaldo de los originales anterior a las modificaciones. Los ZIP originales se regeneran con las fuentes corregidas y sin los archivos de compilación target.

## Repositorio

GitHub privado: https://github.com/sevillafernan347-hue/Programacion-Avanzada-Java

El repositorio reúne los cuatro proyectos en directorios separados e incluye un flujo de GitHub Actions para repetir las pruebas. La validación documentada en este informe corresponde a la ejecución local; el estado de la ejecución remota se consulta en GitHub Actions.

## Archivos que sustentan la revisión

Fuentes y pom.xml de los cinco ZIP facilitados, clases corregidas de src/main/java, pruebas de src/test/java e informes XML de target/surefire-reports. Las evidencias copiadas en docs/evidencias permiten consultar los resultados exactos de las ejecuciones locales.
