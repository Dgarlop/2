const fs = require("node:fs/promises");


async function unirArchivos() {
  try {
    const a =await fs.readFile('a.txt', 'utf8')
    const b =await fs.readFile('a.txt', 'utf8')
    const c =await fs.readFile('a.txt', 'utf8')
    
    const texto = a+b+c 
    await fs.writeFile('todo.txt', texto)
    
    console.log("todo.txt creado");
  } catch (error) {
    console.error('Error: ', err.menssage);
  }
}

unirArchivos();
