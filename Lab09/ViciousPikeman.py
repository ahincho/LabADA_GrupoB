
'''
    
    Autor: Hincho Jove, Angel Eduardo

    Descripcion del Problema:

    En la Edad Media se realizaron los primeros concursos de
    Programacion. El problema nos da los enunciados siguientes
    - El Concursante tiene una eficiencia del 100%
    - El Concursante sabe cuanto tiempo demorara por ejercicio
  
    Se nos entrega los siguientes datos en el enunciado
    - N: La cantidad de problemas del Concurso en curso
    - T: La cantidad de tiempo total que tomara el Concurso
    - A, B, C y T0: Son parametros que nos ayudaran a calcular
    cuanto tiempo tomara al Concursante resolver el ejercicio
    I (iteracion) en el cual estamos iterando o trabajando
    - Ecuacion de Recurrencia: Para poder calcular los tiempos
    para cada ejercicio, igual a Ti = ((A*Ti - 1) mod C) + 1
    Esta Ecuacion de Recurrencia rige a partir de I [1, N - 1]

    Finalmente el problema nos pide encontrar la cantidad 
    maxima de ejercicios que puede resolver el Concursante y
    la penalizacion que recibira al realizar los ejercicios

    Ojo: Al ser la penalizacion enorme, aplicar MOD 1000000007
    La penalizacion es igual al tiempo de inicio que es '0'
    mas el tiempo que se tomo para resolver el ejercicio

''' 

# Metodo 'solveProblems' - Solucion del problema

'''

    Explicacion de la Solucion: Un problema muy parecido o rela-
    cionado con Job Scheduling y el concepto de Costo Aplazado
    de una tarea. En Job Scheduling se calcula segun la cantidad
    de tiempo que aplazamos una actividad y su costo (i * ci)

    En este caso nuestro Costo por Aplazamiento o conocida como
    Penalidad dentro del ejercicio. Es el tiempo durante el cual
    un ejercicio no pudo ser resuelto, siendo aplazado ya que
    preferiremos resolver aquellos que demanden menos tiempo

    Lo primero que debemos hacer es recibir los datos, sobretodo
    los valores de A, B, C y T0 ya que a partir de ellos podemos
    calcular los tiempos de resolucion de los demas ejercicios.
    
    Una vez calculado el tiempo de cada ejercicio lo que debemos
    hacer es ordenan nuestro arreglo de tiempo ya que preferimos
    resolver aquellos ejercicios que demanden menos tiempo y asi
    evitar una mayor penalidad al resolver. Tener en cuenta el
    tiempo maximo del Concurso que se nos da para los ejercicios

'''

def solveProblems(n, givenTime, timeSolve):
    # Iniciamos variables auxiliares para el tiempo
    # que tomaremos y la penalidad que recibiremos
    totalTime, penalty = 0, 0
    # Empezamos a iterar sobre los ejercicios y sus
    # tiempos para ser resueltos (t) en la lista
    for i, t in enumerate(timeSolve):
        # Analizamos si el tiempo total mas el tiempo que
        # tomaremos para resolver el ejercicio es mayor
        # al tiempo maximo o dado dentro del  Concurso
        if (totalTime + t) > givenTime:
            # Cuando es mayor entonces llegamos al limite
            # del tiempo dado para el Concurso y devolvemos
            # la cantidad de ejercicios resultos y penalidad
            return i, penalty
        # En caso no se mayor entonces debemos agregar el
        # tiempo para resolver el ejercicio actual al total
        totalTime += t
        # Agregamos el tiempo que ha pasado hasta resolver
        # el ejercicio a la penalidad antigua y el resultado
        # de esta suma, una vez aplicado el modulo, sera el
        # nuevo valor para la penalidad recibida al ejercicio
        penalty = (penalty + totalTime) % 1000000007
    # Si el ciclo 'for' se completo sin ningun problema o 
    # retorno significa que resolvimos todos los ejercicios
    # Entonces devolvemos la cantidad y penalidad recibida
    return n, penalty

# Metodo principal del programa - Main

def main():
    # Recibimos los valores de N y T
    n,t = map(int, input().split())
    # Recibimos los valores de A, B, C y T0
    a,b,c,t0 = map(int, input().split())
    # Creamos la lista con los tiempos que tomara
    # resolver cada ejercicio al Concursante
    timeSolve = [t0]
    # Empezamos a llenar los tiempos de los demas
    # problemas con ayuda de A, B, C y T0 dados
    for x in range(1, n):
        value = ((a * timeSolve[-1] + b) % c) + 1
        timeSolve.append(value)
    # Una vez llenada la lista con los tiempos de
    # cada ejercicio, debemos ordenar esta lista
    # ya que preferiremos resolver y priorizar los
    # ejercicios que demanden menos tiempo
    timeSolve = sorted(timeSolve)
    # Imprimimos por consola cantidad de ejercicios
    # resueltos y la penalizacion recibida por estos
    print(*solveProblems(n, t, timeSolve))

# Ejecutamos el metodo principal del programa

if __name__ == "__main__":
    main()
