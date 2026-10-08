//ejercicio1
console.log(document.getElementsByTagName("title")[0].textContent);
document.getElementById("nombre").value = "Diego";
document.getElementById("apellido").value = "Garcia";
document.getElementById("saludo").textContent = "Hola Francisco Alarcón";
var nuevoParrafo = document.createElement("p");
nuevoParrafo.textContent = "¿Que tal estás?";
document.getElementById("saludo").appendChild(nuevoParrafo);

//ejercicio2


