const fs = require('fs/promises')
const pc = require('picocolors')
const { media, aprobados, mejor } = require('./notas')

async function main() {
  try {
    const contenido = await fs.readFile('notas.json', 'utf8')
    const lista = JSON.parse(contenido)

    console.log('--- Alumnos ---')
    for (const alumno of lista) {
      const linea = `${alumno.nombre}: ${alumno.nota}`
      console.log(alumno.nota >= 5 ? pc.green(linea) : pc.red(linea))
    }

    console.log('\n--- Resumen ---')
    console.log('Nota media:', media(lista).toFixed(2))
    console.log('Aprobados:', aprobados(lista).length)
    const top = mejor(lista)
    console.log('Mejor alumno:', top ? top.nombre : '-')
  } catch (err) {
    console.error('Error:', err.message)
  }
}

main()
