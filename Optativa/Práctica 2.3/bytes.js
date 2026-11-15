const texto = process.argv.slice(2).join(' ')

console.log('Texto:     ', texto)
console.log('Caracteres:', texto.length)
console.log('Bytes:     ', Buffer.byteLength(texto))
console.log('Buffer:    ', Buffer.from(texto))


const abecedario = Buffer.alloc(26)
for (let i = 0; i < abecedario.length; i++) {
  abecedario[i] = 65 + i // A es 65 (nota para mi)
}
console.log('\nAbecedario (buffer):', abecedario)
console.log('Abecedario (texto): ', abecedario.toString())
