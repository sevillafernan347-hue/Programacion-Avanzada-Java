# RepositorioGenerico_Avanzada1

Ejercicio original revisado el 3 de noviembre de 2026.

Requiere JDK 17 o superior y Maven. Abrir en NetBeans la carpeta que contiene `pom.xml`.

```sh
mvn clean test
mvn exec:java
```

Clase principal: `com.mycompany.repositoriogenerico_avanzada1.RepositorioGenerico_Avanzada1`.

El gráfico requiere una sesión gráfica. Las claves del repositorio son únicas; agregar una clave repetida lanza IllegalArgumentException. Deshacer elimina la inserción más reciente y su clave.
