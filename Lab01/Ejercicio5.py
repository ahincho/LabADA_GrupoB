
# Este programa recibe como entrada una frase o serie de palabras
# y las imprime por consola con un marco hecho con asteriscos

# Pidiendo ingresar una frase por consola
frase = input("Ingresa una frase: ")

# Tener en cuenta que el espacio entre el marco y la frase
# es de 1 en esta version 'original' del problema planteado

# Algunas variables String que nos ayudara a no repetir codigo y
# tan solo concatenar a la variable 'resultado' que se devolvera
marcoHorizontal = "*" * (len(frase) + 4) + "\n"
marcoVertical = "*" + " " * (len(frase) + 2) + "*\n"

# Armando el recuadro o marco con la frase adentro
resultado = marcoHorizontal
resultado += marcoVertical
resultado += "* " + frase + " *\n"
resultado += marcoVertical
resultado += marcoHorizontal

# Imprimiendo por consola el resultado que es la frase con marco
print(resultado)
