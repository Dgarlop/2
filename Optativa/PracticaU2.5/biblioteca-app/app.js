//En app.js crea un middleware de registro que muestre en la terminal, para cada petición, la hora, el método
//y la URL (por ejemplo: 10:15:02 GET /horario).

const app = require('express')();
const PORT = 3000;

app.get('/', (req, res) => {
 res.send('¡Hola mundo desde Express!')
 const now = new Date();
 const timestamp = now.toLocaleTimeString();
 console.log(`${timestamp} ${req.method} ${req.url}`);
})
app.get('/horario', (req, res) => {
 res.send('¡horario!')
 const fecha = new Date();
 const registro = fecha.toLocaleTimeString();
 console.log(`${registro} ${req.method} ${req.url}`);
})
app.get('/prestamos', (req, res) => {
 res.send('prestamos!')
 const fecha = new Date();
 const registro = fecha.toLocaleTimeString();
 console.log(`${registro} ${req.method} ${req.url}`);
})
app.get('/css/estilos.css ', (req, res) => {
 res.send('estilos!')
 const fecha = new Date();
 const registro = fecha.toLocaleTimeString();
 console.log(`${registro} ${req.method} ${req.url}`);
})

app.listen(PORT, () => {
 console.log(`Servidor en http://localhost:${PORT}`)
})

