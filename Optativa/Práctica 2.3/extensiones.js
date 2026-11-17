const fs = require('fs')
const path = require('path')

const carpeta = process.argv[2] ?? __dirname

let entradas
try {
  entradas = fs.readdirSync(carpeta, { withFileTypes: true })
} catch (err) {
  console.error(`No se puede leer la carpeta "${carpeta}": ${err.message}`)
  process.exit(1)
}

const cuenta = {}
for (const entrada of entradas) {
  if (!entrada.isFile()) continue // se ignoran las subcarpetas
  const ext = path.extname(entrada.name) || '(sin extensión)'
  cuenta[ext] = (cuenta[ext] ?? 0) + 1
}

const tabla = Object.entries(cuenta).map(([extension, ficheros]) => ({ extension, ficheros }))
console.table(tabla)
