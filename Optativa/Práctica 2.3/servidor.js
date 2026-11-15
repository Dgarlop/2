const http = require('http')
const os = require('os')
const { randomInt } = require('crypto')

const PORT = process.env.PORT || 3000

const servidor = http.createServer((req, res) => {
  console.log(req.method, req.url)

  const { pathname } = new URL(req.url, `http://${req.headers.host ?? 'localhost'}`)

  if (pathname === '/') {
    res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' })
    res.end(`<h1>Servidor de 2º DAM</h1>
<p>Prueba las rutas <a href="/info">/info</a> y <a href="/dado">/dado</a>.</p>`)
  } else if (pathname === '/info') {
    res.writeHead(200, { 'Content-Type': 'application/json; charset=utf-8' })
    res.end(JSON.stringify({
      sistemaOperativo: `${os.type()} ${os.release()} (${os.platform()})`,
      cpus: os.cpus().length,
      versionNode: process.version
    }))
  } else if (pathname === '/dado') {
    res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' })
    res.end(`<h1>Has sacado un ${randomInt(1, 7)}</h1>`) // randomInt: máximo excluido
  } else {
    res.writeHead(404, { 'Content-Type': 'text/plain; charset=utf-8' })
    res.end('404 - Página no encontrada')
  }
})

servidor.listen(PORT, () => {
  console.log(`Servidor en http://localhost:${PORT}`)
})
