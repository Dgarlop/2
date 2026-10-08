//ejercicio1
/*
console.log(document.getElementsByTagName("title")[0].textContent);
document.getElementById("nombre").value = "Diego";
document.getElementById("apellido").value = "Garcia";
document.getElementById("saludo").textContent = "Hola Francisco Alarcón";
var nuevoParrafo = document.createElement("p");
nuevoParrafo.textContent = "¿Que tal estás?";
document.getElementById("saludo").appendChild(nuevoParrafo);*/

//ejercicio2
/*
var li = document.getElementsByTagName("li");
for (var i = 0; i < li.length; i++) {
        li[i].hidden = true;
    }
function mostrar() {
    for (var i = 0; i < li.length; i++) {
        li[i].hidden = false;
    }
}*/

//ejercicio3
/*
var nombre = document.getElementById("nombre");
var apellido = document.getElementById("apellido");
function correcto() {
    nombre.style.color = "green";
    apellido.style.color = "green";
}
function incorrecto() {
    nombre.style.color = "red";
    apellido.style.color = "red";
}*/

//ejercicio4
/*
window.onload = function() {
    document.getElementById("ciudad").textContent = "Sevilla";
    document.getElementById("gastos").textContent = "3 €";
    document.getElementById("fecha").textContent = new Date().toLocaleDateString();
    //Asi se pide el prompt desde el principio
    /*var ciudad = prompt("Introduce tu ciudad");
    var gastos = prompt("Introduce los gastos de envío");
    var fecha = prompt("Introduce la fecha");
    document.getElementById("ciudad").textContent = ciudad;
    document.getElementById("gastos").textContent = gastos;
    document.getElementById("fecha").textContent = fecha;
};
function cambiar(){
    //Asi se cambia cuando lo solicite el usuario
    var ciudad = prompt("Introduce tu ciudad");
    var gastos = prompt("Introduce los gastos de envío");
    var fecha = prompt("Introduce la fecha");
    document.getElementById("ciudad").textContent = ciudad;
    document.getElementById("gastos").textContent = gastos;
    document.getElementById("fecha").textContent = fecha;
};*/

//ejercicio5
/*
var ciudades_gratis = ["Sevilla", "Madrid", "Barcelona", "Valencia"];
var ciudades_gastos = ["Cantabria", "Pontevedra", "Toledo", "Segovia"];
window.onload = function() {
    document.getElementById("ciudad").textContent = "Sevilla";
    document.getElementById("gastos").textContent = "3 €";
    document.getElementById("fecha").textContent = new Date().toLocaleDateString();
    //Asi se pide el prompt desde el principio
    /*
    var ciudad = prompt("Introduce tu ciudad");
    var gastos = prompt("Introduce los gastos de envío");
    var fecha = prompt("Introduce la fecha");
    document.getElementById("ciudad").textContent = ciudad;
    document.getElementById("gastos").textContent = gastos;
    document.getElementById("fecha").textContent = fecha;*/
/*};
function cambiar(){
    //Asi se cambia cuando lo solicite el usuario
    var fechaEstilo = document.getElementById("fecha");
    var ciudad = prompt("Introduce tu ciudad");
    document.getElementById("ciudad").textContent = ciudad;
    if (ciudades_gratis.includes(ciudad)) {
        var gastos = "Gratis";
        var fecha = prompt("Introduce la fecha");
        document.getElementById("fecha").textContent = fecha;
    }
    else if (ciudades_gastos.includes(ciudad)) {
        var gastos = prompt("Introduce los gastos de envío");
        document.getElementById("gastos").textContent = gastos;
        var fecha = prompt("Introduce la fecha");
        document.getElementById("fecha").textContent = fecha;
    }
    else {
        document.getElementById("gastos").textContent = "No se pueden realizar envíos a esta ciudad";
        fechaEstilo.hidden = true;
    }
};*/

//Ejercicio6
/*
var div = document.getElementById("ejercicio6");
var info = div.getElementsByTagName("p");
console.log(info);
var mostrar = document.getElementById("mostrar");
for (var i = 1; i < info.length; i++) {
    info[i].hidden = true;
}
function mostrarInfo() {
    if(mostrar.textContent === "Mostrar mas") {
        for (var i = 1; i < info.length; i++) {
        info[i].hidden = false;
        }
        mostrar.textContent = "Mostrar menos";
    }
    else{
        for (var i = 1; i < info.length; i++) {
        info[i].hidden = true;
        }
        mostrar.textContent = "Mostrar mas";
    }
}
    */
//Ejercicio7
/*
var info = document.getElementById("ejercicio6").getElementsByTagName("p");
var ids = document.getElementsByTagName("h3");
var tamano = 15;
function aumentarLetra(){
    tamano +=10;
    info[0].style.fontSize = tamano + "px";
}
function disminuirLetra(){
    tamano -=10;
    info[0].style.fontSize = tamano + "px";
}
    */
//Ejercicio8y9
/*
var lista = document.getElementById("ListaCompra");
var producto = document.createElement("li");
var boton1 = document.createElement("button");
var boton2 = document.createElement("button");
function añadir() {
    var texto = prompt("Introduce el producto");
    producto.textContent = texto; 
    boton1.textContent = "Si";
    boton2.textContent = "No";
    producto.appendChild(boton1);
    producto.appendChild(boton2);
    lista.appendChild(producto); 
    boton1.onclick = si;
    boton2.onclick = no;
}
function si(){
    producto.style.color = "green";
    producto.style.fontStyle = "italic";
    producto.style.fontWeight = "normal";
}
function no(){
    producto.style.color = "red";
    producto.style.fontWeight = "bold";
    producto.style.fontStyle = "normal";
}
    */
//Ejercicio10
const productos = [
    { id: 1, nombre: 'Patata', precio: 1, imagen: 'patata.jpg'}, 
    { id: 2, nombre: 'Cebolla', precio: 1.2, imagen: 'cebolla.jpg' },  
    { id: 3, nombre: 'Calabacin', precio: 2.1, imagen: 'calabacin.jpg' },  
    { id: 4, nombre: 'Fresas', precio: 0.6, imagen: 'fresas.jpg'}
];
var lista = document.createElement("ul");
for(i in productos){
    var producto = document.createElement("li");
    var nuevoProducto = productos[i];
    producto.textContent = nuevoProducto.id + " - " +
                           nuevoProducto.nombre + " - " +
                           nuevoProducto.precio + " €";
    var imagen = document.createElement("img");
    imagen.src = nuevoProducto.imagen;
    imagen.width = 100;
    producto.appendChild(imagen);
    var boton = document.createElement("button");
    boton.textContent = "Disponible";
    boton.classList.add("disabled");
    boton.onclick = estado;
    producto.appendChild(boton);
    lista.appendChild(producto);
}
document.body.appendChild(lista);

function estado(){
    if (this.style.backgroundColor == "gray") {
        this.style.backgroundColor = "green";
        this.style.color = "white";

        } else {
            this.style.backgroundColor = "gray";
            this.style.color = "white";

        }
}