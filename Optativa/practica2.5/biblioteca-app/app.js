const express = require('express')
const path = require('path')

const app = express()
const PORT = process.env.PORT || 3000

app.set('view engine', 'ejs')
app.set('views', path.join(__dirname, 'views'))

const libros = [
  { titulo: 'El Quijote', autor: 'Miguel de Cervantes', anio: 1605, disponible: true },
  { titulo: 'Cien años de soledad', autor: 'Gabriel García Márquez', anio: 1967, disponible: false },
  { titulo: 'La sombra del viento', autor: 'Carlos Ruiz Zafón', anio: 2001, disponible: true },
  { titulo: 'Clean Code', autor: 'Robert C. Martin', anio: 2008, disponible: false },
  { titulo: 'El nombre del viento', autor: 'Patrick Rothfuss', anio: 2007, disponible: true }
]

app.use((req, res, next) => {
  const hora = new Date().toLocaleTimeString('es-ES')
  console.log(`${hora} ${req.method} ${req.url}`)
  next()
})

app.use(express.static(path.join(__dirname, 'public')))

app.get('/', (req, res) => {
  res.render('index', { titulo: 'Inicio' })
})

app.get('/horario', (req, res) => {
  const horario = [
    { dia: 'Lunes', horas: '8:30 - 14:30' },
    { dia: 'Martes', horas: '8:30 - 14:30' },
    { dia: 'Miércoles', horas: '8:30 - 14:30' },
    { dia: 'Jueves', horas: '8:30 - 14:30 y 16:00 - 19:00' },
    { dia: 'Viernes', horas: '8:30 - 13:30' }
  ]
  res.render('horario', { titulo: 'Horario', horario })
})

app.get('/libros', (req, res) => {
  res.render('libros', { titulo: 'Libros', libros })
})

app.get('/libros/disponibles', (req, res) => {
  const disponibles = libros.filter((libro) => libro.disponible)
  res.render('libros', { titulo: 'Libros disponibles', libros: disponibles })
})

app.use((req, res) => {
  res.status(404).render('404', { titulo: 'Página no encontrada' })
})

app.listen(PORT, () => {
  console.log(`Servidor de la biblioteca en http://localhost:${PORT}`)
})
