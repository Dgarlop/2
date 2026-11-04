const http = require ('http')

const servidor = http.createServer((req, res) => {
    const url = new URL(req.url,
        'http://localhost')
    if (url.pathname === '/saludo') {
        const nombre =
            url.searchParams.get('nombre')
        if (nombre) {
            res.writeHead(200, { 'Content-Type': 'text/plain' })
            res.end(`Hola ${nombre}`)
        }
        else {
            res.writeHead(400, { 'Content-Type': 'text/plain' })
            res.end('Hola desconocido')
        }
    }
    else {
        res.writeHead(404, { 'Content-Type': 'text/plain' })
        res.end('No encontrado')
    }
})
servidor.listen(3000, () => {
    console.log('Servidor escuchando en el puerto 3000')
});