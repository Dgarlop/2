const Semaforo = require('./semaforo')

const semaforo = new Semaforo(500)
let rojos = 0

console.log(`Semáforo en ${semaforo.color}`)

semaforo.on('cambio', (color) => console.log(`Cambio a ${color}`))

semaforo.once('rojo', () => console.log('(primer rojo: ¡frena!)'))

semaforo.on('rojo', () => {
  rojos++
  if (rojos === 2) semaforo.parar() 
})

semaforo.on('parado', () => console.log('Semáforo apagado'))
