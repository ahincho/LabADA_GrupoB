
'''

    Autor: Hincho Jove, Angel Eduardo
    
    Descripcion del Problema:
    
    El problema consiste en recibir 100 grupos de palabras que
    estan separadas por saltos de linea en blanco. Estos bloques
    de palabras deben ser organizados alfabeticamente desde la
    letra o caracter del final hacia el caracter de adelante.
    Asi mismo se tiene que tener en cuenta que esta organizacion
    debe estar justificada, es decir se imprimira de izquierda a
    derecha las palabras una vez hayan sido ordenadas

    Retornar el diccionario de palabra ordenadas al reves

''' 

# Metodo 'sortAndPrint' - Imprime el grupo o bloque
# de palabras ordenadas alfabeticamente al reves y
# ademas agrega un padding o justificado pedido

def sortAndPrint(longest, words):
    
    # Recibimos la longitud de la palabra mas larga
    # en nuestro bloque y el bloque de palabras

    # Posteriormente iteraremos sobre nuestro bloque
    # de palabras. Pero antes debemos ordenarlas
    # alfabeticamente desde el caracter del final

    # Para ello utilizaremos una funcion anonima que
    # ordenara nuestro bloque de palabras desde atras

    for w in sorted(words, key = lambda w: w[::-1]):
        
        # Debemos crear un padding o justificado para
        # la palabra sobre la cual estamos iterando
        # Este justificado se obtendra restando la
        # longitud de la palabra mas larga menos la
        # longitud de la palabra en iteracion

        padding = ' ' * (longest - len(w))
        
        # Imprimimos la palabra justificada

        print(f'{padding}{w}')

# Metodo Main del programa

def main():
    
    # Declaramos nuestras variables
    # Siendo:
    # Longest = Longitud de la palabra mas larga
    # Words = Bloque de palabras a ordenar desde atras

    longest, words = -1, []
    
    # Empezamos leyendo nuestro input mandado

    while True:
        
        try:
            
            # Leemos una linea o una palabra del bloque
            word = input()

            # En caso de ser un espacio en blanco o
            # salto de linea pasaremos a otro bloque

            if not word:
                
                # Ordenamos nuestro bloque desde atras
                # e imprimos nuestro bloque almacenado

                sortAndPrint(longest, words)
                
                # Imprimimos un salto de linea para poder
                # pasar hacia otro bloque de palabras
                
                print()

                # Reiniciamos nuestras variables

                longest, words = -1, []
            
            # En caso ser una palabra y no un espacio en
            # blanco entonces debemos agregarla a nuestro
            # arreglo de palabras y recalcular nuestra
            # longitud maxima para el justificado del bloque

            else:
                
                # Recalcular longitud maxima de las palabras
                
                longest = max(longest, len(word))

                # Agregar nuestra palabra al bloque actual

                words.append(word)
        
        # En caso de presentarse un error en nuestro ingreso
        # de palabras al bloque entonces romperemos el ciclo

        except EOFError:

            # Ordenamos e imprimimos ultimo bloque ingresado

            sortAndPrint(longest, words)
            
            # Rompemos el ciclo para recibir datos o input
            
            break

if __name__ == "__main__":
    main()
