function media(lista) {
  if (lista.length === 0) return 0
  const suma = lista.reduce((acc, alumno) => acc + alumno.nota, 0)
  return suma / lista.length
}


function aprobados(lista) {
  return lista.filter((alumno) => alumno.nota >= 5)
}


function mejor(lista) {
  return lista.reduce(
    (max, alumno) => (max === undefined || alumno.nota > max.nota ? alumno : max),
    undefined
  )
}

module.exports = { media, aprobados, mejor }
