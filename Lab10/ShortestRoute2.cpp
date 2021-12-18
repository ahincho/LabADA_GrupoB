
#include <bits/stdc++.h>
using namespace std;
#define lli long long int

/* 
    Autor: Hincho Jove, Angel Eduardo

    Descripcion del Problema: Se nos hace entrega de una 'n'
    cantidad de ciudades y 'm' cantidad de rutas entre estas
    Se nos pide encontrar las rutas de coste minimo entre 2
    ciudades dadas. Asi mismo se nos hace entrega de un 'q'
    que es la cantidad de consultas que se realizaran sobre
    la ruta de minimo coste entre dos ciudades dadas

    Ojo: Para este problema las vias o rutas son de ida y
    vuelta osea se trata de un Grafo No Dirigido
*/

/*
    Solucion del Problema: Como se trata de un problema de
    encontrar las distancias desde una ciudad hacia otra u
    otras en este caso, ademas de no existir ponderaciones
    o pesos negativos en las aristas asi como tampoco hay
    ciclos entre estas. Usaremos el Algoritmo Dijkstra, en
    este caso en su version de Programacion Dinamica ya
    que el Grafo es No Dirigido ademas que necesitamos las 
    distancias que existen entre todas las ciudades dadas
*/

/*
    Creamos nuestras variables para los valores del enunciado
        n : Cantidad de ciudades que existen
        m : Cantidad de rutas o carreteras entre las ciudades
        q : Cantidad de consultas que se realizaran
*/

lli n, m , q;

/*
    Como usaremos la version de Programacion Dinamica de
    Dijkstra necesitamos crear un arreglo bidimensional
    como se le conoce en Java. En este caso en C++ este
    arreglo bidimensional seria un vector de vectores
*/

vector<vector<lli>> graph;

// Tambien establecemos el valor infinito

lli inf = 1e18;

// Metodo 'createArray', recibe los valores para 'n', 'm' y 'q'
// a partir de ellos crea el arreglo bidimensional para Dijkstra

void createArray() {

    // Recibimos o leemos los valores para 'n', 'm' y 'q'
    
    cin >> n >> m >> q;

    // Redimensionamos las filas del Grafo en 'n + 1'

	graph.resize(n + 1);

    /*
        Para cada una de las filas, esta contendran 'n + 1'
        cantidades de variables de tipo long. De esta manera
        obtenemos un arreglo bidimensional de [n + 1][n + 1]
    */

	for(int i = 0; i <= n; i++) {
		
        graph[i].resize(n + 1);

	}

    /*
        Finalmente antes de pasar a resolver establecemos las
        distancias entre todas las ciudades como infinito a
        excepto de la diagonal del arreglo bidimensional. Es
        decir la distancia de la Ciudad X hacia la Ciudad X
        sera igual a 0, respetando lo visto en teoria anterior
    */

	for(int i = 1; i <= n; i++) {
		
        for(int j = i + 1; j <= n; j++) {
			
            // Tener en cuenta que es un Grafo No Dirigido

            graph[i][j] = graph[j][i] = inf;
 
		}

	}

}

// Metodo 'dijkstraDP', trabaja con el arreglo bidimensional una
// vez ingresado los valores para las Aristas y sus pesos entre

void dijkstraDP() {

    /*
        Iteraremos sobre las posiciones del arreglo bidimensional
        sobre sus filas y columnas. Usaremos la parte vista en teoria
        para evaluar las rutas minimas entre los vertices del grafo.
        Para ello utilizamos el siguiente pseudocodigo de Dijkstra

        Pseudocodigo parA Dijkstra:
        Si distancia[v] > distancia[u] + peso(u, v) entonces
            distancia[v] = distancia[u] + peso(u, v)
            padre[v] = u (Tambien conocido como predecesor)
            adicionar a la Cola de Prioridad (v, distancia[v])
    */

    for(int k = 1; k <= n; k++) {
		
        for(int i = 1; i <= n; i++) {
			
            for(int j = 1; j <= n; j++) {
				
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j]);

			}

		}

	}
    
    /*
        Finalmente, recibimos la cantidad de consultas que se desean
        realizar sobre nuestro arreglo bidimensional con las rutas de
        minimo coste entre las ciudades entregadas y sus carreteras
    */

	for(int i = 0; i < q; i++) {
		
        /*
            Creamos las variables 'u' y 'v' para la consulta que en
            este caso 'u' seria el Vertice o Ciudad de Origen y 'v'
            seria nuestro Vertice o Ciudad de destino a llegar
        */

        lli u, v;

        // Leemos o recibimos sus valores del input ingresado

		cin >> u >> v;
		
        // Finalmente debemos evaluar algunos casos

        if(graph[u][v] == inf) {
            
            /*
                En caso el costo para llegar desde la Ciudad 'u'
                hacia la Ciudad 'v' sea de infinito significa que
                no existe una ruta entre las Ciudades 'u' y 'v'
                Devolvemos -1 debido a la premisa del enunciado
            */

            graph[u][v] = -1;

        }

        /*
            En caso ser diferente de infinito, significa que existe
            una ruta entre ambas Ciudades 'u' y 'v' de coste minimo
            Devolvemos el valor o coste para llegar desde 'u' a 'v'
        */

		cout << graph[u][v] << endl;

	}

}

// Metodo Main del Programa

int32_t main() {

    // Creamos el arreglo bidimensional para Dijkstra Dinamico

    createArray();
    
    /*
        Empezamos a leer los valores de 'u', 'v' y 'c' siendo
        los valores para el Vertice de Origen, Destino y Costo
        de la Arista, respectivamente. Leemos las 'm' lineas
    */

	for(int i = 0; i < m; i++) {
		
        lli u, v, c;

		cin >> u >> v >> c;

        /*
            Establecemos los valores de Costo o Peso de Arista
            eligiendo el minimo entre el valor anterior y el
            nuevo valor 'c' recibido al leer el input recibido

            Tener en cuenta que es un Grafo No Dirigido
        */

		graph[u][v] = graph[v][u] = min(graph[u][v], c);

	}

    /*
        Con los datos del arreglo bidimensional calculamos las
        rutas de minimo coste entre las ciudades y respondemos
        a las 'q' consultas que se hacen sobre las ciudades
    */

    dijkstraDP();

}
