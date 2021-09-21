
# Este programa recibe como entrada una frase o serie de palabras
# y las imprime por consola con un marco hecho con asteriscos

# Este programa es muy parecido al Ejercicio5, pero aqui se permite
# personalizar la cantidad de espacio entre la frase y el marco

# Pidiendo ingresar una frase por consola
frase = input("Ingresa una frase: ")

# Pidiendo ingresar la cantidad de espacios entre la frase y el marco
espacio = int(input("Cantidad de espacios entre la frase y el marco: "))

# Verificando que no se ingrese una cantidad negativa
if(espacio < 0):
  print("Solo se admiten numeros positivos!")
  quit()

# Algunas variables String que nos ayudara a no repetir codigo y
# tan solo concatenar a la variable 'resultado' que se devolvera
marcoHorizontal = "*" * (len(frase) + espacio * 2 + 2) + "\n"
marcoVertical = "*" + " " * (len(frase) + espacio * 2) + "*\n"

# Armando el recuadro o marco con la frase adentro y tomando en cuenta
# la cantidad de espacios que se desea entre la frase y el marco
resultado = marcoHorizontal
for i in range(0, espacio):
  resultado += marcoVertical
resultado += "*" + " " * espacio + frase + " " * espacio + "*\n"
for i in range(0, espacio):
  resultado += marcoVertical
resultado += marcoHorizontal

# Imprimiendo por consola el resultado que es la frase con marco
print(resultado)
