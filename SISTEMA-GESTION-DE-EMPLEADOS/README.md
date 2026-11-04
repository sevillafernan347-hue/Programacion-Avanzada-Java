# SISTEMA-GESTION-DE-EMPLEADOS

Ejercicio original revisado el 3 de noviembre de 2026.

Requiere JDK 17 o superior y Maven. Abrir en NetBeans la carpeta que contiene `pom.xml`.

```sh
mvn clean test
mvn exec:java
```

Clase principal: `com.mycompany.sistema.gestion.de.empleados.SISTEMAGESTIONDEEMPLEADOS`.

El ejemplo anexa dos registros a empleados.txt en el directorio de trabajo. Cada ejecución los añade de nuevo. El almacenamiento usa UTF-8 y rechaza separadores dentro de los campos.
