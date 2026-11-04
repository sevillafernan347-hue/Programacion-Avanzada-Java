# Investigación sobre GitHub Git y Git Bash

Estudiante: Fernando David Sevilla
Asignatura: Programación Avanzada
Fecha: 3 de noviembre de 2026

## Introducción

El desarrollo de un proyecto necesita conservar sus avances, identificar qué cambió y compartir los archivos de forma organizada. Esta investigación estudia GitHub, Git y Git Bash y aplica sus conceptos a cuatro ejercicios Java de NetBeans. El documento reúne los fundamentos, los comandos, el procedimiento de publicación, los resultados y los enlaces de los ejercicios.

La idea central es comprender tres tareas relacionadas: Git registra el historial del proyecto, GitHub permite alojarlo y colaborar en línea, y Git Bash proporciona una terminal para trabajar con Git en Windows. Aprender su relación permite pasar de una carpeta de archivos a un proyecto documentado y verificable. [1, 2, 3]

## Objetivo general

Comprender el funcionamiento de GitHub y su relación con Git y Git Bash mediante la consulta de documentación oficial y su aplicación en la organización y publicación de ejercicios de programación.

## Objetivos específicos

Distinguir las tres herramientas; explicar repositorios, commits, ramas y remotos; practicar el flujo de edición y publicación; identificar funciones de colaboración y automatización; y documentar los ejercicios con enlaces que permitan consultar sus fuentes y entregas.

## Organización del informe

| Página | Contenido |
|---|---|
| 2 | Cómo se realizó la investigación y conceptos fundamentales |
| 3 | Git Bash y configuración del entorno |
| 4 | Historial y publicación con Git |
| 5 | Ramas y colaboración |
| 6 | Servicios de GitHub y solución de problemas |
| 7 | Ejercicios y enlaces de consulta y descarga |
| 8 | Aplicación práctica y resultados comprobados |
| 9 | Análisis y conclusiones |
| 10 | Bibliografía y recursos oficiales |

# Método y conceptos fundamentales

## Cómo se realizó la investigación

La revisión documental partió de la investigación y la guía sobre GitHub elaboradas el 29 de octubre de 2026. Para esta versión se contrastaron los conceptos con GitHub Docs, la referencia de Git, el libro Pro Git y el sitio de Git for Windows. Se priorizaron fuentes oficiales para distinguir el comportamiento de Git de las funciones que ofrece la plataforma.

El trabajo siguió cuatro pasos: revisar la documentación; organizar términos y comandos por su función; aplicarlos a los proyectos Java; y comprobar el resultado en el historial remoto y en las pruebas automatizadas. Los comandos de las páginas siguientes son una guía reproducible para Git Bash; no constituyen una transcripción literal de todos los medios utilizados durante la publicación asistida.

## Qué es cada herramienta

| Herramienta | Definición y función |
|---|---|
| Git | Sistema distribuido de control de versiones. Cada clon normal conserva historial y permite crear commits localmente. |
| GitHub | Plataforma para alojar repositorios Git, revisar cambios, coordinar tareas y automatizar trabajo. |
| Git Bash | Entorno de terminal de Git for Windows que permite ejecutar Git y utilidades de Bash en Windows. |

Git puede utilizarse sin GitHub. GitHub también puede usarse desde el navegador, desde un IDE o desde herramientas de terminal. Git Bash no tiene una cuenta propia: la cuenta corresponde a GitHub y las credenciales permiten acceder a los recursos autorizados. [1, 2, 3]

## Vocabulario esencial

Repositorio: conjunto de archivos e historial. Commit: registro identificable de cambios preparados, con autor y mensaje. Rama: línea de desarrollo que permite avanzar por separado. Remoto: conexión con otro repositorio mediante una dirección. origin es un nombre habitual para esa conexión. [4, 5, 6]

README: documento de presentación e instrucciones, normalmente en Markdown. Clone: copia local de un repositorio. Fork: otro repositorio relacionado con el original en GitHub. Pull request: propuesta para revisar e integrar cambios entre ramas. Un ZIP contiene archivos, pero no reemplaza por sí solo el historial de Git. [4, 7]

## Los tres espacios de trabajo

El directorio de trabajo contiene los archivos que se editan. El área de preparación selecciona los cambios del próximo commit. El repositorio local conserva los commits. Publicar en GitHub agrega un paso de intercambio con el remoto: guardar, preparar, registrar y enviar son acciones distintas. [5]

# Git Bash y configuración del entorno

## Preparación en Windows

Git for Windows incluye Git Bash. Después de instalarlo desde su sitio oficial, se abre Git Bash desde Inicio o desde una carpeta. El indicador de la terminal muestra información del entorno; no forma parte de la orden que se debe copiar. La siguiente comprobación permite saber si Git está disponible. [3]

```bash
git --version
```

## Navegación y archivos

| Comando de Bash | Uso |
|---|---|
| pwd | Mostrar la carpeta actual. |
| ls / ls -a | Listar el contenido; -a incluye entradas ocultas. |
| cd carpeta / cd .. | Entrar en una carpeta o subir al directorio superior. |
| mkdir practica | Crear una carpeta llamada practica. |
| cat README.md | Mostrar el contenido de un archivo de texto. |
| clear | Limpiar la vista de la terminal. |
| cp archivo copia / mv archivo nombre | Copiar un archivo o moverlo y cambiar su nombre. |

Las órdenes de navegación pertenecen al entorno de terminal. Las órdenes que comienzan con git pertenecen a Git. Una ruta de Windows se puede expresar en Git Bash con /c/ al inicio. Las comillas permiten trabajar con espacios en nombres y carpetas.

```bash
cd "/c/Users/Fernando Sevilla/Documents/Neatbeans"
pwd
ls
```

## Identidad del autor y autenticación

Git utiliza nombre y correo para identificar al autor de los commits. Esa configuración no inicia sesión en GitHub. El siguiente correo es un ejemplo y debe sustituirse por el correo asociado a la cuenta o por el correo privado proporcionado por GitHub. [8]

```bash
git config --global user.name "Fernando Sevilla"
git config --global user.email "TU_CORREO"
git config --get user.name
git config --get user.email
```

La conexión remota puede utilizar HTTPS o SSH. En HTTPS se puede usar un administrador de credenciales; SSH utiliza claves autorizadas. La contraseña habitual de la cuenta no se introduce como contraseña de autenticación Git por HTTPS. Los tokens y claves privadas se mantienen fuera de los archivos del proyecto. [8, 9]

# Historial y publicación con Git

## Comandos para el trabajo diario

| Comando | Propósito |
|---|---|
| git init -b main | Iniciar un repositorio local con la rama main. |
| git clone URL | Obtener una copia local con su historial. |
| git status | Consultar cambios y archivos preparados. |
| git diff / git diff --staged | Comparar cambios sin preparar o ya preparados. |
| git add README.md | Preparar el archivo para el próximo commit. |
| git commit -m "Mensaje" | Registrar los cambios preparados en el historial. |
| git log --oneline | Consultar un resumen de los commits. |
| git remote -v | Revisar los remotos configurados. |
| git push -u origin main | Enviar main y configurar su seguimiento remoto. |
| git fetch origin | Descargar información e historial del remoto. |
| git pull --ff-only | Actualizar solo si la integración permite avance directo. |

git init se utiliza al comenzar un repositorio nuevo; git clone cuando ya existe uno remoto. Un commit registra únicamente los cambios preparados. El primer push con -u configura el seguimiento para simplificar envíos posteriores. [5, 6, 10]

## Ejemplo para publicar una carpeta nueva

Este ejemplo supone que el repositorio de GitHub ya fue creado vacío, sin commits iniciales, y que la carpeta local todavía no contiene .git. Si el remoto ya tiene historial, conviene clonarlo primero en otra carpeta y copiar allí los archivos del ejercicio.

```bash
git init -b main
git status
git add .
git diff --staged
git commit -m "Agrego ejercicios de programacion"
git remote add origin URL_DEL_REPOSITORIO
git push -u origin main
```

## Selección de los archivos publicados

Un archivo .gitignore define qué archivos no rastreados se omiten. En los ejercicios se excluyen target, la configuración privada de NetBeans y empleados.txt. Los binarios se identifican mediante .gitattributes para evitar transformaciones de saltos de línea. Ignorar un archivo no elimina una copia ya publicada ni sus versiones anteriores. [5, 10]

# Ramas y colaboración

## Trabajar sin mezclar avances

Una rama permite desarrollar un cambio y revisarlo antes de integrarlo. Crear una rama no copia físicamente todo el proyecto en otra carpeta. Git conserva referencias al historial y actualiza la versión visible al cambiar de rama. En un equipo conviene acordar nombres y revisar los cambios antes de fusionarlos. [11]

```bash
git switch -c mejora-documentacion
# Editar y guardar README.md
git add README.md
git commit -m "Amplio las instrucciones del proyecto"
git push -u origin mejora-documentacion
```

## Pull requests y revisión

Después de publicar la rama se puede abrir una pull request en GitHub. Allí se comparan cambios, se reciben comentarios y se consultan comprobaciones automáticas. Una vez aprobada la propuesta, se integra en la rama de destino. Un commit o un push no crea automáticamente una pull request. [7]

## Conflictos y actualización

Si dos cambios afectan partes incompatibles de un archivo, Git puede solicitar una resolución manual. Se revisan ambas versiones, se edita el resultado correcto, se prepara el archivo y se completa la operación indicada por git status. Los marcadores de conflicto no deben quedar dentro del código final. [11]

git pull --ff-only evita crear una integración automática cuando las ramas han divergido. Si se detiene, se debe revisar el historial y elegir cómo integrar los avances. Usar un envío forzado sin comprender la diferencia puede reemplazar historia remota necesaria para otras personas. [6]

## Organizar tareas y documentación

Las issues permiten registrar errores, preguntas, ideas y tareas. Una descripción útil incluye el problema, cómo reproducirlo y el resultado esperado. Projects ayuda a organizar el seguimiento del trabajo; las pull requests enlazan la propuesta concreta de cambio con su revisión. [7, 12]

Un README útil explica qué hace el proyecto, sus requisitos y cómo ejecutarlo. Markdown permite títulos, listas, tablas, bloques de comandos y enlaces. La licencia define las condiciones de reutilización: que un repositorio sea visible no equivale por sí solo a conceder todos los permisos sobre sus archivos. [4, 7]

# Funciones de GitHub y problemas frecuentes

## Funciones principales de la plataforma

| Función | Aplicación |
|---|---|
| Actions | Automatizar compilación, pruebas y otros flujos definidos en archivos YAML. |
| Pages | Publicar un sitio web estático desde un repositorio. |
| Issues y Projects | Registrar y organizar el trabajo pendiente. |
| Releases y etiquetas | Identificar versiones y acompañarlas con notas o archivos de entrega. |
| Organizaciones y permisos | Administrar colaboración y acceso a repositorios. |

GitHub Actions ejecuta flujos por eventos, como un push o una pull request. Un flujo contiene trabajos y pasos que se ejecutan en un entorno configurado. Pages sirve para publicar contenido web; no convierte automáticamente una aplicación Java de escritorio en una aplicación web. La disponibilidad de funciones depende de la configuración y del plan. [1, 13, 14]

## Errores habituales y su interpretación

| Mensaje o situación | Qué revisar |
|---|---|
| not a git repository | Entrar en la carpeta que contiene el repositorio; no iniciar otro por accidente. |
| Author identity unknown | Configurar nombre y correo de autor. |
| Repository not found | Comprobar URL, cuenta autenticada y permisos. |
| remote origin already exists | Consultar git remote -v y corregir la URL si hace falta. |
| Push rechazado por historial remoto | Consultar los cambios remotos antes de integrar. |
| No aparecen los archivos en GitHub | Verificar preparación, commit, push y rama seleccionada. |

## Buenas prácticas

Revisar git status y las diferencias antes de registrar cambios; escribir mensajes que expliquen el avance; excluir archivos temporales; mantener instrucciones claras y comprobar que los enlaces funcionan. Los secretos y tokens no se publican. Un repositorio privado solo puede consultarse con una cuenta autorizada; para compartirlo con un docente se debe conceder acceso a su cuenta. [9, 10]

# Ejercicios publicados y enlaces

Cuenta utilizada: sevillafernan347-hue. Los cuatro ejercicios están organizados en carpetas independientes dentro de un único repositorio privado llamado Programacion-Avanzada-Java. Los enlaces de esta página permiten abrir cada proyecto y consultar su ZIP; no representan cuatro repositorios independientes.

[Repositorio general de los ejercicios](https://github.com/sevillafernan347-hue/Programacion-Avanzada-Java)

## ProcesamientoAsincrono

Cuenta bancaria, excepciones y retiros concurrentes.

[Abrir código fuente y README](https://github.com/sevillafernan347-hue/Programacion-Avanzada-Java/tree/main/ProcesamientoAsincrono)

[Abrir archivo ZIP del ejercicio](https://github.com/sevillafernan347-hue/Programacion-Avanzada-Java/blob/main/entregas/ProcesamientoAsincrono.zip)

## RepocitorioGenerico

Repositorio genérico, colecciones y gráfico de ventas.

[Abrir código fuente y README](https://github.com/sevillafernan347-hue/Programacion-Avanzada-Java/tree/main/RepocitorioGenerico)

[Abrir archivo ZIP del ejercicio](https://github.com/sevillafernan347-hue/Programacion-Avanzada-Java/blob/main/entregas/RepocitorioGenerico.zip)

## RepositorioGenerico_Avanzada1

Colecciones, historial de operaciones y Java 2D.

[Abrir código fuente y README](https://github.com/sevillafernan347-hue/Programacion-Avanzada-Java/tree/main/RepositorioGenerico_Avanzada1)

[Abrir archivo ZIP del ejercicio](https://github.com/sevillafernan347-hue/Programacion-Avanzada-Java/blob/main/entregas/RepositorioGenerico_Avanzada1.zip)

## SISTEMA-GESTION-DE-EMPLEADOS

Modelo de empleados, controlador y persistencia UTF-8.

[Abrir código fuente y README](https://github.com/sevillafernan347-hue/Programacion-Avanzada-Java/tree/main/SISTEMA-GESTION-DE-EMPLEADOS)

[Abrir archivo ZIP del ejercicio](https://github.com/sevillafernan347-hue/Programacion-Avanzada-Java/blob/main/entregas/SISTEMA-GESTION-DE-EMPLEADOS.zip)

## Archivo duplicado recibido

RepositorioGenerico_Avanzada1 (1).zip y RepositorioGenerico_Avanzada1.zip tenían el mismo contenido. Se conservan los dos nombres de entrega y ambos corresponden al mismo ejercicio.

[Abrir RepositorioGenerico_Avanzada1 (1).zip](https://github.com/sevillafernan347-hue/Programacion-Avanzada-Java/blob/main/entregas/RepositorioGenerico_Avanzada1%20%281%29.zip)

Para descargar un ZIP en GitHub se abre su enlace y se utiliza la opción de descarga del archivo. Los enlaces requieren iniciar sesión con la cuenta propietaria o con una cuenta que tenga acceso al repositorio.

# Aplicación práctica y resultados

## Organización y publicación de los ejercicios

Se revisaron cinco ZIP, que correspondían a cuatro proyectos distintos. Se ajustaron los errores de compilación, las clases principales y la configuración Maven. El código, las pruebas y la documentación se organizaron por carpetas; después se crearon un commit y el remoto origin y se envió la rama main a GitHub.

La recepción del código se comprobó comparando el identificador del commit local con el de GitHub. También se revisó que el PDF publicado conservara sus bytes. Este procedimiento permite distinguir entre tener archivos locales y confirmar que el contenido llegó al remoto.

## Correcciones realizadas como parte de la práctica

ProcesamientoAsincrono: cuenta bancaria compilable, retiros sincronizados y rechazo de importes inválidos. Repositorios genéricos: deshacer elimina también la clave; las claves duplicadas se rechazan y las ventanas se crean desde el hilo de eventos de Swing. Empleados: nombres y paquetes coherentes, acceso al guardado, lectura UTF-8 y tratamiento explícito de errores.

## Comprobación local y remota

| Proyecto | Pruebas locales | GitHub Actions |
|---|---|---|
| ProcesamientoAsincrono | 3 aprobadas | Aprobado |
| RepocitorioGenerico | 4 aprobadas | Aprobado |
| RepositorioGenerico_Avanzada1 | 3 aprobadas | Aprobado |
| SISTEMA-GESTION-DE-EMPLEADOS | 4 aprobadas | Aprobado |

Las 14 pruebas locales terminaron sin fallos ni errores el 3 de noviembre de 2026. El flujo de GitHub Actions también aprobó los cuatro proyectos. La ejecución local utilizó JDK 23 compilando para Java 17; el flujo remoto utilizó Java 17. Estos resultados corresponden a la validación inicial del código publicado.

[Ejecución remota comprobada](https://github.com/sevillafernan347-hue/Programacion-Avanzada-Java/actions/runs/41755199692)

[Comprobaciones y ejecuciones posteriores](https://github.com/sevillafernan347-hue/Programacion-Avanzada-Java/actions)

## Cómo utilizar los ejercicios

Para obtener el conjunto se clona el repositorio. Después se entra en una carpeta de proyecto y se ejecuta Maven o se abre esa carpeta en NetBeans. Los gráficos requieren un entorno gráfico y el sistema de empleados anexa datos a empleados.txt en su directorio de trabajo.

```bash
git clone https://github.com/sevillafernan347-hue/Programacion-Avanzada-Java.git
cd Programacion-Avanzada-Java/ProcesamientoAsincrono
mvn clean test
mvn exec:java
```

# Análisis y conclusiones

## Qué aporta este procedimiento

La revisión documental permitió separar herramientas que suelen confundirse. Git registra versiones; Git Bash ofrece una forma de dar instrucciones en Windows; GitHub agrega alojamiento, revisión y automatización. Esta distinción ayuda a ubicar un problema: archivos locales, historial, conexión o permisos.

La publicación de los ejercicios mostró la utilidad de mantener fuentes, pruebas y documentación juntas. El historial facilita conocer la evolución del trabajo; los README permiten ejecutar cada proyecto y las comprobaciones automáticas proporcionan evidencia adicional sobre su estado.

## Ventajas y límites observados

El trabajo local con Git permite registrar avances sin conexión. Compartirlos por GitHub requiere acceso a internet y permisos. Las diferencias de texto son fáciles de revisar; los PDF y ZIP requieren comprobar sus contenidos por otros medios. Conservar únicamente archivos comprimidos no ofrece la misma trazabilidad que conservar las fuentes con sus commits.

Un resultado aprobado de pruebas demuestra los casos comprobados, no la ausencia de cualquier defecto posible. Las ventanas de Swing no recibieron una revisión visual completa. La clase coneccionDB permanece como esqueleto del ejercicio bancario; los ejemplos mantienen double para los importes y el sistema de empleados puede repetir los datos al ejecutar nuevamente su demostración.

## Conclusiones

1. GitHub permite organizar proyectos y colaborar sobre ellos. Su utilidad académica incluye documentación, historial y revisión de avances, además del alojamiento de archivos.

2. El flujo editar, preparar, registrar y enviar permite entender dónde está cada cambio. Un archivo guardado no equivale a un commit y un commit local no equivale a una publicación.

3. Las ramas y las pull requests facilitan proponer mejoras y revisarlas. Las issues ayudan a describir el trabajo y Actions permite repetir comprobaciones.

4. La investigación se aplicó a cuatro ejercicios Java publicados en un repositorio privado, con enlaces de consulta y descarga. Las pruebas locales y remotas aprobaron la validación inicial del código.

5. Mantener instrucciones claras, permisos adecuados y credenciales protegidas forma parte del uso responsable de estas herramientas. Para continuar el aprendizaje conviene practicar cambios pequeños, consultar el historial y revisar cada envío.

## Resultado de la investigación

El informe integra la consulta de fuentes oficiales, los conceptos principales, el catálogo inicial de comandos, el procedimiento de publicación y la evidencia de su aplicación. Los enlaces de la página 7 conectan la explicación con los ejercicios entregados.

# Bibliografía y recursos oficiales

Fuentes oficiales consultadas o verificadas para esta edición el 3 de noviembre de 2026. Los números entre corchetes del texto corresponden a esta lista. Los enlaces son clicables.

[1] GitHub Docs. [Qué es GitHub](https://docs.github.com/es/get-started/start-your-journey/what-is-github).

[2] Git. [Introducción práctica a Git](https://git-scm.com/docs/gittutorial).

[3] Git for Windows. [Git Bash y herramientas para Windows](https://gitforwindows.org/).

[4] GitHub Docs. [Acerca de los repositorios](https://docs.github.com/es/repositories/creating-and-managing-repositories/about-repositories).

[5] Pro Git. [Registrar cambios en el repositorio](https://git-scm.com/book/en/v2/Git-Basics-Recording-Changes-to-the-Repository).

[6] Pro Git. [Trabajar con remotos](https://git-scm.com/book/en/v2/Git-Basics-Working-with-Remotes).

[7] GitHub Docs. [Hola mundo y flujo con pull requests](https://docs.github.com/es/get-started/using-github/hello-world).

[8] GitHub Docs. [Configurar Git](https://docs.github.com/en/get-started/git-basics/set-up-git).

[9] GitHub Docs. [Autenticación en GitHub](https://docs.github.com/es/authentication/keeping-your-account-and-data-secure/about-authentication-to-github).

[10] Git. [Referencia de comandos](https://git-scm.com/docs).

[11] Pro Git. [Ramas y fusiones básicas](https://git-scm.com/book/en/v2/Git-Branching-Basic-Branching-and-Merging).

[12] GitHub Docs. [GitHub Issues](https://docs.github.com/es/issues/tracking-your-work-with-issues/learning-about-issues/about-issues).

[13] GitHub Docs. [GitHub Actions](https://docs.github.com/es/actions/get-started/understand-github-actions).

[14] GitHub Docs. [GitHub Pages](https://docs.github.com/es/pages/getting-started-with-github-pages/what-is-github-pages).
