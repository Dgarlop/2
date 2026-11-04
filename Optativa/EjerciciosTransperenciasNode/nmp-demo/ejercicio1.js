const os = require('os')
const patch = require('patch')
const fs = require('fs')

const ruta = patch.join(__dirname, ficha.txt)
const texto = `Usuario: ${os.userInfo.username}\n` + 
fs.writeFileSync(ruta,texto)
console.log(fs.readFileSync(ruta, 'utf-8'))
