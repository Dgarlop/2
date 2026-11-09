//PEDIR NOTAS a la hora de pedirlo me tiene que pasar CUALQUIER COSA y despuies VALIDAR que sea solo NUMEROS y añadirlo a una LISTA y mostrar mensaje cual NO es VALIDO

function pedirNotas(){
    //me falta perdirlo por teclado (No me acuerdo)
    console.log("introduce las notas");
    var notas  = [1.2,"x",5,4];
    var long = notas.length
    var contador = 0;
    var listaNotas=[];
    
    while (contador <long){
        var n = (notas[contador]);
        
        if (n>=0 || n<=10){
            listaNotas.push(n)
        }
        else{
            console.log("Nota no valida: " + n )
        }
        
        contador = contador +1;
    }
    console.log(listaNotas)
    return listaNotas
}

function calcularMedia(lista){
    var long = lista.length;
    var contador = 0;
    var media = 0;
    var suma = 0;
    while (contador <long){
        var n = (lista[contador]);  
        suma = n + suma;
        contador = contador +1;
    }
    media = suma /long;
    alert("Media es: " + media);
    return media;
}
function calificacion(media){
    switch(Math.floor(media)){
        case 5 : 
            alert("suficiente")
        case 6:
            alert("Bien")
        case 7:
            alert("Notable") 
        case 8:
            alert("Notable")
        case 9:
            alert("Sobresaliente")
        case 10:
            alert("Sobresaliente")   
        default: alert("insuficiente") 
    }   
}
function aprobados(lista){
    var long = lista.length;
    var contador = 0;
    var aprobados = 0;
    while (contador <long){
        var n = (lista[contador]);  
        if(n>=5){
            aprobados = aprobados + 1;
        }
        contador = contador +1;
    }
    alert("Aprobados: " + aprobados + " de " + long);

}


var n = pedirNotas();

var m = calcularMedia(n);
calificacion(m);
aprobados(n);