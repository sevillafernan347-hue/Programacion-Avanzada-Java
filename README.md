# Programación Avanzada en Java

Cuatro proyectos originales de NetBeans revisados, con pruebas y documentación. Los cinco ZIP recibidos incluían dos copias idénticas de RepositorioGenerico_Avanzada1.

## Proyectos

| Carpeta | Tema | Pruebas locales |
|---|---|---:|
| ProcesamientoAsincrono | Excepciones y retiros concurrentes | 3 |
| RepocitorioGenerico | Colecciones y gráfico Java 2D | 4 |
| RepositorioGenerico_Avanzada1 | Repositorio genérico y deshacer | 3 |
| SISTEMA-GESTION-DE-EMPLEADOS | Herencia y persistencia UTF-8 | 4 |

## Uso

Requiere JDK 17 o superior y Maven. Abrir cada subcarpeta en NetBeans o ejecutar desde ella:

```sh
mvn clean test
mvn exec:java
```

Los gráficos requieren una sesión gráfica. Los proyectos son independientes y cada uno tiene su pom.xml.

## Documentación

- [Informe técnico PDF](docs/Informe_revision_Java.pdf)
- [Informe editable en Markdown](docs/Informe_revision_Java.md)
- [Resultados y evidencias locales](docs/evidencias/)
- [Cambios realizados](CHANGELOG.md)

Las 14 pruebas locales pasaron el 3 de noviembre de 2026 con JDK 23, compilando para Java 17. GitHub Actions comprueba los cuatro proyectos con JDK 17.

Se conservan los autores y datos de ejemplo presentes en las fuentes originales. No se ha aplicado una licencia nueva a material de terceros.
