const fs = require('fs')
const path = require('path')

process.stdout.write('¿Qué fichero quieres copiar? ')

process.stdin.once('data', (entrada) => {
  const origen = entrada.toString().trim()
  const nombreCopia = 'MAYUS-' + path.basename(origen)
  const destino = path.join(path.dirname(origen), nombreCopia)

  const lectura = fs.createReadStream(origen, 'utf8')
  let escritura
  let bytes = 0


  lectura.on('open', () => {
    escritura = fs.createWriteStream(destino)

    escritura.on('error', (err) => {
      console.error('Error al escribir:', err.message)
      process.exit(1)
    })

    escritura.on('finish', () => {
      console.log(`Creado ${nombreCopia} (${bytes} bytes)`)
      process.exit() 
    })
  })

  lectura.on('data', (trozo) => {
    bytes += Buffer.byteLength(trozo) 
    escritura.write(trozo.toUpperCase())
  })

  lectura.on('end', () => escritura.end())

  lectura.on('error', (err) => {
    console.error('Error:', err.message)
    process.exit(1)
  })
})
