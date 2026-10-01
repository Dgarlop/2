var cantidad = prompt("Ingrese la cantidad de etiquetas <p> que desea ingresar: ");
var padre = document.getElementById("1");
for(var i = 0; i < cantidad; i++){
    var parrafo = document.createElement("p");
    parrafo.appendChild(document.createTextNode("parrafo " + (i+1)));
    padre.appendChild(parrafo);
}

//Borrando a los hijos
var hijos = padre.getElementsByTagName("p");
for (var i = 0; i < cantidad; i++){
    padre.removeChild(hijos[i]);
}