const segundos = Number(process.argv[2])
const mensaje = process.argv.slice(3).join(' ') || '¡Tiempo!'

if (!Number.isInteger(segundos) || segundos <= 0) {
  console.error('Uso: node temporizador.js <segundos> [mensaje]')
  console.error('  <segundos> debe ser un número entero mayor que 0')
  console.error('  Ejemplo: node temporizador.js 10 Sacar la pizza')
  process.exit(1)
}

let quedan = segundos
console.time('Duración total')

const intervalo = setInterval(() => {
  quedan--
  if (quedan > 0) {
    console.log(`Quedan ${quedan} s`)
  } else {
    clearInterval(intervalo) 
    console.log(mensaje)
    console.timeEnd('Duración total')
  }
}, 1000)

setTimeout(() => console.log('¡Ya vas por la mitad!'), (segundos * 1000) / 2)

console.log(`Temporizador de ${segundos} s iniciado`)
