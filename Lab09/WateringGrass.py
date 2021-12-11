
'''
    
    Autor: Hincho Jove, Angel Eduardo

    Descripcion del Problema:

    Se tienen 'N' aspersores instalados de forma horizontal sobre
    una banda de cesped de dimensiones 'L * W'. Cada aspersor se
    encuentra en la linea media horizontal. Asi mismo se nos da la
    posicion de cada aspersor, la distancia desde extremo izquierdo
    de linea media horizontal y su radio donde riega el aspersor

    Finalmente se pide calcular la cantidad minima de aspersores
    que se deben encender en orden para que el riego sera sobre
    toda la banda o franja de cesped de dimensiones ya dadas

''' 

import sys
from math import sqrt

# Metodo 'turnOnSprinklers' - Solucion del problema

'''

    Explicacion de la Solucion:

    En este caso lo que debemos hacer es recibir nuestros datos
    y generar un arreglo con las posiciones de los asperores y
    su zona de riego o trabajo. Debemos ubicar la linea media
    horizontal para poder calcular las distancias y zonas de
    posible riego que se pueden utilizar usando el teorema de
    Pitagoras. Una vez se agreguen estos datos a un arreglo
    estandar debemos ordenarlo para iterar segun las posiciones
    en el eje 'x' de nuestros aspersores. El problema se puede
    solucionar probando con los aspersores mas cercanos a la
    izquierda o al inicio e ir acumulando aquellos que riegan una
    zona de cesped adecuadamente. Finalmente revisamos que toda
    nuestra banda de cesped haya sido regada correctamente

'''

def turnOnSprinklers(sprinklers, l, n):
    # Iniciamos con algunas variables auxiliares siendo
    # useAmount : Aspersores utilizados para el riego
    # currentSprinkler : Aspersor con el que estamos
    # trabajando o evaluando su zona de riego en el cesped
    # currentLong : El largo de la franja o banda de cesped
    # que ya ha sido regada exitosamente por los aspersores
    useAmount, currentSprinkler, currentLong = 0, 0, 0
    # Iteraremos hasta que toda el cesped este regado
    while True:
        # La posicion mas lejana al iniciar nuestro regado seria de
        # -1. Inclusive antes que la posicion 0 porque no esta regada
        farther = -1
        # Iteraremos mientras haya aspersores y la longitud del
        # aspersor actual con el que estamos trabajando no sea mayor
        # a la longitud ya regada exitosamente por otros aspersores
        while currentSprinkler < n and sprinklers[currentSprinkler][0] <= currentLong:
            # Revisaremos cada uno de los aspersores y eligiremos
            # aquelque tenga una zona de riego mayor sobre el cesped
            farther = max(farther, sprinklers[currentSprinkler][1])
            # Finalmente pasaremos a evaluar al siguiente aspersor
            currentSprinkler += 1
        # En caso que no se haya podido seleccionar ningun aspersor que
        # riege correctamente y en su totalidad a la franja o banda de
        # cesped. Entonces devolveremos un -1 indicando que no se pudo
        # regar la franja o banda de cesped con los asperores que se tiene
        if farther == -1:
            return -1
        # A partir de aqui podemos asegurarnos que hemos regado correctamente
        # nuestra franja o banda de cesped con el aspersor actual, entonces lo
        # agregamos a la cantidad de aspersores utilizados para el trabajo
        useAmount += 1
        # Tambien debemos igualar la area regada exitosamente a la area
        # mas alejada guardada despues de haber revisado todos los aspersores
        currentLong = farther
        # Finalmente debemos verificar que nuestra area o longitud regada sea
        # mayor o igual a 1. Esto debido a que existe el caso que no hayan
        # aspersores disponibles para regar nuestra franja o banda de cesped
        if currentLong >= l:
            # Devolvemos la cantidad de aspersores utilizados
            return useAmount

# Metodo principal del programa - Main

# En este caso usaremos la libreria Sys para ingresar los
# datos enviados por consola. Asi mismo tambien usaremos
# la funcion 'sqrt' o 'Raiz Cuadrada' de la Liberia Math

def main():
    # Empezamos con el contador de lineas a leer en 0
    linesAmount = 0
    # Por cada linea enviada al input iteraremos
    for line in sys.stdin:
        if linesAmount == 0:
            # Para la primera linea del input, debemos salvar los valores
            # que se nos explico en el enunciado, siendo estos valores 'n'
            # que es la cantidad de aspersores y los valores 'l' y 'w' que
            # son las dimensiones de la franja o banda de cesped
            n, l, w = map(int, line.split())
            # Entonces debemos registrar las posiciones de los 'n' aspersores
            # Para ello debemos leer las siguientes 'n' lineas de input
            linesAmount = n
            # Creamos la linea media horizontal donde se ubicaran todos los
            # aspersores (w / 2). Luego lo elevamos al cuadrado y de esta
            # manera, por teorema de Pitagoras, sabremos a que distancia
            # se encuentran los aspersores, apoyados en su zona de riego
            halfWideSquare = (w / 2) ** 2
            # Creamos el arreglo donde guardaremos posiciones de aspersores
            sprinklers = []
        else:
            # Una vez ya hemos ingresados los primeros datos 'n', 'l' y 'w'
            # Debemos recolectar los datos de cada aspersor y sus coordenadas
            # para esto decrementaremos el valor de la variable 'linesAmount'
            # en una unidad cada vez que registremos los datos de un aspersor
            linesAmount -= 1
            # Empezamos leyendo los datos sobre su posicion en el eje 'x' y 
            # su zona de riego o radio de operacion del input por consola
            x, r = map(int, line.split())
            # Si el diametro del aspersor supera al valor de 'w' entonces
            # que el aspersor tiene una zona de riego correcta o adecuada
            # para cubrir con la franja o banda de cesped que tenemos
            if (2 * r) > w:
                # Debemos encontrar la distancia en el eje de 'x' donde el
                # aspersor trabaja o riega. Esto se hace mediante el teorema
                # de Pitagoras. Una vez encontrada la distancia creamos el
                # intervalo donde opera dicho aspersor, siendo x +- d
                d = sqrt((r ** 2) - halfWideSquare)
                # Agregamos su area de riego a la lista de aspersores
                sprinklers.append((x - d, x + d))
            # Una vez agregados los aspersores y sus respectivas zonas de riego
            if linesAmount == 0:
                # No hay nada mas que leer, antes de empezar a elegir que
                # aspersores utilizaremos debemos arreglar estas coordenadas
                # o zonas de riego, para ellos utilizamos el metodo 'sorted'
                sprinklers = sorted(sprinklers) 
                # Imprimimos cuantos aspersores necesitamos encender o usar
                # para regar correctamente toda nuestra franja o banda de cesped
                print(turnOnSprinklers(sprinklers, l, len(sprinklers)))

# Ejecutamos el metodo principal del programa

if __name__ == "__main__":
    main()
