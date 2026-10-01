/*var dni = prompt("Ingrese su DNI: ");
var letras = ["T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"];
var suma = 0;
var letra;
for (var i = 0; i < dni.length; i++) {
    if (i > 1 || i < 999999999){
        if(dni.length == 8){
            suma += parseInt(dni.charAt(i));
            letra = letras[suma % 23];
        } else {
            alert("El DNI debe tener 8 dígitos");
        }
    }
}

document.write(dni + letra);

document.write("<br>" + "Siguiente ejercicio " + "<br>");

var numero = prompt("Ingrese un número: ");
for (var i = 0; i <= 10; i++) {
    document.write("<br>" + numero + " x " + i + " = " + (numero * i) + "<br>");
}*/
/*
//Ejercicio 1
var nombre = prompt("Ingrese su nombre: ");
var suma = nombre.length;
document.write("<h1>El nombre " + nombre + " tiene " + suma + " letras</h1>");

//Ejercicio 2
var caracteres = prompt("Ingrese una frase: ");
var numero = prompt("Ingrese un número: ");
var letra =  caracteres.charAt(numero); 

alert("El caracter en la posición " + numero + " es: " + letra );

//Ejercicio 3
var n1 = prompt("Ingrese un número: ");
var n2 = prompt("Ingrese otro número: ");
var calculos = ("La suma es: " + n1 + n2) + " " + ("La resta es: " +n1 - n2) + " " + ("La multiplicacion es: " +n1 * n2) + " " + ("La divicion es: " +n1 / n2);
alert("Los resultados son: " + calculos);

//Ejercicio 4
var notaPracticas = prompt("Ingrese la nota de las prácticas: ");
var notaExamen = prompt("Ingrese la nota del examen: ");
var notaActitud = prompt("Ingrese la nota de la actitud: ");
var notaMedia = (parseFloat(notaPracticas) + parseFloat(notaExamen) + parseFloat(notaActitud)) / 3;
var aprobado = notaMedia >= 5 ? "Aprobado" : "Suspenso";
document.write("<h1>" + "Lenguaje de Marcas" + "</h1>");
document.write("<h1>" + notaMedia + " - " + aprobado + "</h1>");

//Ejercicio 5
var marca = prompt("Ingrese la marca del pc: ");
var modelo = prompt("Ingrese el modelo del pc: ");
var descuento = (marca == "MSI" || modelo == "Prestige") ? 5 + "%" : (marca == "HP" || modelo == "Pavilion") ? 10 + "%" : 0 + "%";
document.write("<h1>" +"Todos los pc sin descuento valen 1000$, este pc tiene un descuento del: " + descuento + "</h1>");

//Ejercicio 6
var numero = prompt("Ingrese un número del encamezado: ");
document.write("<h" + numero + ">" + "Encabezado nivel " + numero + "</h" + numero + ">");

//Ejercicio 7
var respuesta = prompt("Ingrese un nombre: ");
var contador = 0;

while (respuesta != "Velázquez" || contador == 3) {
    contador++;
    respuesta = prompt("Ingrese un nombre: ");
    if (contador == 3) {
    document.write("<h1>" + "Lo siento! La respuesta correcta es Velázquez" + "</h1>");
    exit();
    }
}
document.write("<h1>" + "Correcto! Ha acertado" + "</h1>");

//Ejercicio 8
var opcion = prompt("Desea jugar al juego de azar? (si/no)");
var cantidad = 30;
while (opcion == "si" || cantidad == 0 || cantidad >= 120) {
    var dado = Math.floor(Math.random() * 6) + 1;
    var apostado = prompt("Ingrese la cantidad que desea apostar: ");
    var numero = prompt("Ingrese un número del 1 al 6: ");
    if (numero == dado) {
        alert("Ha ganado! El número del dado es: " + dado);
        cantidad = cantidad + 10;
    }
    else {
        alert("Ha perdido! El número del dado es: " + dado);
        cantidad = cantidad - apostado;
    }
    opcion = prompt("Desea continuar jugando? (si/no)");
}

document.write("<h1>" + "Gracias por jugar! Su cantidad final es: " + cantidad + "</h1>");
*/
//Ejercicio 9 Y 10

var entrada = prompt("Ingrese una lista de nombres separados por comas: ");
var lista_nombres = entrada.split(',');

for (i in lista_nombres) {
    document.write("<h1>" + "Saludos, " + lista_nombres[i] + "!" + "</h1>");
}

document.write("<p>Número de personas: " + lista_nombres.length + "</p>");
document.write("<p>Primera persona: " + lista_nombres[0] + "</p>");
document.write("<p>Última persona: " + lista_nombres[lista_nombres.length - 1] + "</p>");

lista_nombres.sort();
console.log(lista_nombres);

lista_nombres.reverse();
console.log(lista_nombres);