const EventEmitter = require('events')

const COLORES = ['verde', 'ámbar', 'rojo']

class Semaforo extends EventEmitter {
  constructor(milisegundos) {
    super()
    this.indice = 0
    this.color = COLORES[this.indice] 
    this.temporizador = setInterval(() => this.cambiar(), milisegundos)
  }

  cambiar() {
    this.indice = (this.indice + 1) % COLORES.length
    this.color = COLORES[this.indice]
    this.emit('cambio', this.color)
    if (this.color === 'rojo') {
      this.emit('rojo')
    }
  }

  parar() {
    clearInterval(this.temporizador)
    this.emit('parado')
  }
}

module.exports = Semaforo
