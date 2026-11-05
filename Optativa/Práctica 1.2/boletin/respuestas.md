# Boletín U2.1 y U2.2 – Node.js, asincronía, módulos y npm

> Estructura de la entrega: `ejercicio1/`, `ejercicio2/`, `notas-app/` y este fichero.
> Todos los programas se han ejecutado con Node.js v22.

---

## 1. Código bloqueante y no bloqueante

### a) Orden previsto

**Orden: `A`, `D true`, `B`, `C`.**

1. Se ejecuta el script en el hilo principal. `console.log('A')` se apila, se ejecuta y se desapila → **A**.
2. `setTimeout(..., 0)` se apila: Node registra el temporizador y se desapila enseguida. El callback **no** se ejecuta aún; queda esperando en la fase de *timers* del event loop.
3. `fs.readFile(...)` se apila: Node delega la lectura al sistema (el *thread pool* de libuv) y se desapila inmediatamente. Su callback se encolará cuando la lectura termine.
4. `fs.readFileSync(...)` es síncrona: **bloquea** el hilo principal hasta tener el contenido del fichero. Después se ejecuta `console.log('D', true)` → **D true**.
5. Ya no queda código síncrono: la pila de llamadas queda vacía y **solo entonces** empieza a trabajar el event loop, que recorre sus fases:
   - Fase de *timers*: el temporizador de 0 ms ya ha vencido (la lectura síncrona ha tardado más), así que su callback pasa a la pila → **B**.
   - Fase de *poll* (E/S): cuando la lectura asíncrona ha terminado, su callback se encola y se ejecuta → **C**. `readFile` necesita varias operaciones encadenadas (abrir, leer, cerrar) y cada una vuelve al event loop, por lo que `C` llega después de `B`.

### b) Ejecución y comprobación

Salida real (repetida varias veces con el mismo resultado):

```
A
D true
B
C
```

- **Bloqueante:** `fs.readFileSync`. Mientras se ejecuta, el hilo principal no hace nada más: no se atienden temporizadores ni callbacks.
- **No bloqueantes:** `setTimeout` y `fs.readFile`. Solo registran la tarea y devuelven el control; el resultado se gestiona más tarde mediante un callback. (`console.log` también se ejecuta de forma síncrona, pero es instantáneo.)
- **Diferencia:** una operación bloqueante detiene el programa hasta que termina; una no bloqueante lo deja continuar y avisa al terminar. En un servidor, bloquear el hilo principal impide atender a otros clientes.

### c) Fichero inexistente (`orden-c.js`)

Salida:

```
A
D true
B
C - Error al leer el fichero: ENOENT: no such file or directory, open 'no-existe.txt'
```

Con la convención «error primero», el callback recibe `err` como primer parámetro; si existe, se gestiona y se hace `return`. **El programa no se detiene**: el error no se lanza como excepción, se pasa al callback, y el resto del código (`A`, `D`, `B`) se ejecuta con normalidad. Si no se comprobara `err`, simplemente se ignoraría el fallo.

### d) `process.version` y `document.title` (`orden-d.js`)

- `console.log(process.version)` muestra la versión de Node (por ejemplo `v22.23.4`): `process` es un objeto global propio de Node.js.
- `console.log(document.title)` lanza **`ReferenceError: document is not defined`**, porque `document` pertenece al DOM, que solo existe en el navegador.

Como el error se produce en el código síncrono principal y no se captura, el proceso termina con código de salida 1. Por eso **ni `B` ni `C` llegan a mostrarse** (se comprobó al ejecutarlo): la excepción se lanza antes de que el event loop pueda ejecutar los callbacks pendientes.

**Navegador vs Node.js:** en el navegador JavaScript tiene `window`, `document`, el DOM, `localStorage`, etc., pero no accede al sistema de ficheros. En Node.js no hay DOM ni `window` (el objeto global es `globalThis`), pero se dispone de `process`, `fs`, `require`/módulos, `__filename`, etc. Es el mismo lenguaje con distinto entorno de ejecución y distintas APIs.

---

## 2. Callbacks, promesas y async/await

### a) Callback hell

Cada operación depende del resultado de la anterior: hace falta `config` para saber qué fichero leer; hace falta el `texto` para calcular el informe; y el informe es necesario para escribirlo. Como las operaciones son asíncronas, el código que sigue **no puede ir después** de la llamada (se ejecutaría antes de que haya resultado), así que tiene que ir **dentro del callback** de la anterior. Esto produce un anidamiento creciente en forma de pirámide (*callback hell*), con consecuencias claras:

- código difícil de leer y de mantener;
- gestión de errores repetida en cada nivel (`if (err) return ...`);
- además, errores como el de `JSON.parse` (que lanza una excepción) no quedan cubiertos por ninguno de esos `if (err)`.

### b) y c) Reescrituras

- `ejercicio2/procesar-then.js`: usa `fs/promises` y encadena `.then()`, con un único `.catch()` al final. Como `config` se necesita en varios `.then()`, se guarda en una variable externa.
- `ejercicio2/procesar-async.js`: usa una función `async`, `await` y un único `try/catch`; el código se lee de forma secuencial y plana.

### d) Prueba sin `alumnos.txt`

Las tres versiones muestran `Error: ENOENT: no such file or directory, open 'alumnos.txt'` y no se rompe el programa. Sitios donde hay que gestionar el error:

| Versión | Sitios de gestión de errores |
|---|---|
| Callbacks (`procesar.js`) | **3** (un `if (err)` en cada callback), más el `JSON.parse`, que quedaría sin proteger |
| Promesas (`procesar-then.js`) | **1** (`.catch()` único, recoge cualquier fallo de la cadena) |
| `async/await` (`procesar-async.js`) | **1** (`try/catch` único, incluye también el `JSON.parse`) |

### e) Ampliación

`ejercicio2/procesar-espera.js` define `esperar(ms)`, que devuelve `new Promise((resolve) => setTimeout(resolve, ms))`, y la usa con `await esperar(1000)` antes de escribir el informe.

---

## 3. Proyecto con módulos y npm

La aplicación está en `notas-app/` (`package.json`, `notas.json`, `notas.js`, `app.js`, `.gitignore`, y la ampliación `notas.mjs` / `app.mjs`).

Para ejecutarla tras descomprimir la entrega:

```
cd notas-app
npm install      # instala picocolors (declarado en package.json) y genera package-lock.json
npm start
```

### Paso 6: `npm start` y `npm run dev`

- `npm start` ejecuta `node app.js` una sola vez y muestra el resumen (media 6.00, 4 aprobados, mejor alumno Marta con los datos de ejemplo).
- `npm run dev` ejecuta `node --watch app.js`: tras mostrar el resumen, Node se queda esperando y **reinicia el programa automáticamente cuando se guarda un fichero que la aplicación ha cargado como módulo** (`app.js` o `notas.js`). Se comprobó modificando `notas.js`: aparece `Restarting 'app.js'` y se vuelve a mostrar el resumen.
- **Observación:** si se modifica `notas.json` y se guarda, **no se reinicia**, porque ese fichero se lee con `fs.readFile` (en tiempo de ejecución), no se carga como módulo con `require`/`import`, y `--watch` solo vigila los ficheros del grafo de módulos. Para que también vigile ese fichero se puede añadir `--watch-path=./notas.json` (`node --watch --watch-path=./notas.json app.js`); con esta opción sí se reinicia al guardar la nota (también se comprobó).

### Paso 7: `.gitignore`, `node_modules` y los dos `package*.json`

El `.gitignore` contiene `node_modules` y `.env`. Después de borrar `node_modules`, `npm install` lo vuelve a crear leyendo `package.json` / `package-lock.json`, y la aplicación vuelve a funcionar igual.

- **`package.json`**: es el manifiesto del proyecto. Contiene el nombre, la versión, los **scripts** (`start`, `dev`) y las **dependencias** con rangos de versión (`"picocolors": "^1.1.1"`, es decir, «1.1.1 o una versión compatible superior»). Lo escribe y mantiene el desarrollador.
- **`package-lock.json`**: lo genera npm automáticamente y registra la **versión exacta** de cada paquete instalado (también de las dependencias de las dependencias), junto con su origen y su huella de integridad. Garantiza que `npm install` instale exactamente lo mismo en cualquier máquina (instalaciones reproducibles). Se sube al repositorio, pero no se edita a mano.
- `node_modules` no se sube ni se entrega porque se puede regenerar siempre con `npm install`, y es muy pesada. `.env` suele contener claves y datos sensibles que no deben ir al repositorio.

### Paso 8 (ampliación): módulos ES

Con `notas.mjs` (`export function ...`) y `app.mjs` (`import ... from`), la ruta del import cambia en que **la extensión es obligatoria**: `import { media, aprobados, mejor } from './notas.mjs'`. En CommonJS, `require('./notas')` puede omitirla (Node prueba `.js`, `.json`, etc.); en los módulos ES, Node no completa extensiones. Otras diferencias: se usa `import`/`export` en lugar de `require`/`module.exports`, los módulos ES son siempre asíncronos en su carga y no existen `__filename`/`__dirname`. Los paquetes de npm se importan igual (`import pc from 'picocolors'`).
