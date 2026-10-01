var texto = prompt("Ingrese un texto: ").toLowerCase();
document.write("<h3> El tamaño del texto es: " + texto.length + "</h3>");
document.write("<h3> Mostrando la posición 8: " + texto.charAt(8) + "</h3>");
if(texto.includes("t")){
    document.write("<h3> El texto contiene la letra 't': " + texto.indexOf("t") + "</h3>");
}
else{
    document.write("<h3> El texto no contiene la letra 't'</h3>");
}
document.write("<h3> Mostrando el texto en mayúsculas: " + texto.toUpperCase() + "</h3>");
document.write("<h3> Mostrando el texto en minúsculas: " + texto.toLowerCase() + "</h3>");

var lista =[];
for(var i = 0; i < 5; i++){
    var numero = prompt("Ingrese un número: ");
    lista.push(numero);
}
document.write("<h3> Mostrando la lista inversa: " + lista.reverse() + "</h3>");
var numero = prompt("Ingrese un número: ");
lista.push(numero);
lista.reverse();
document.write("<h3> Mostrando la lista con el nuevo número: " + lista + "</h3>");

var fecha = new Date(prompt("Ingrese una fecha en formato yyyy-mm-dd: "));
var dia = fecha.getDate();
var mes = fecha.getMonth() + 1;
var anio = fecha.getFullYear();
fechaCompleta = dia + "/" + mes + "/" + anio;
document.write("<h3> Mostrando la fecha: " + fechaCompleta + "</h3>");
