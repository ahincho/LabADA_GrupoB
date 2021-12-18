
#include <bits/stdc++.h>
using namespace std;
#define lli long long int

/* 
    Autor: Hincho Jove, Angel Eduardo

    Descripcion del Problema: Se nos hace entrega de una
    cantidad 'n' de ciudades y las rutas 'm' que conectan
    a las mismas. Se nos pide hallar las distancias desde
    Syrjala (Ciudad 1) hacia el resto o las demas ciudades
*/

/*
    Solucion del Problema: Como se trata de un problema de
    encontrar las distancias desde una ciudad hacia otra u
    otras en este caso, ademas de no existir ponderaciones
    o pesos negativos en las aristas asi como tampoco hay
    ciclos entre estas. Usaremos el Algoritmo Dijkstra
*/

vector<pair<int, int>> graph[100000];

/*
    Lista de Adyancencia del Grafo para el
    par [Vecino, Peso de Arista]
*/

/*
    Creamos un arreglo para los 'n' Vertices
    donde guardaremos las distancias desde el
    Vertice Inicial (Ciudad Syrjala) hacia el
    resto de las ciudades mediante los vuelos
*/

lli distances[100000];

// Variable 'n', cantidad de Vértices o ciudades

int n;

/*
    Metodo Dijkstra. Utilizaremos el metodo Dijkstra
    debido a que trabajaremos con distancias las
    cuales no son negativas y no existe ningun ciclo
*/

void dijkstra(int origin) {

    /*
        Primero estableceremos las distancias hacia las
        'n' Vertices o ciudades como infinito ya que aun
        no han sido visitados desde el primer Vertice
    */

    for(int i = 0; i < n; i++) {

        distances[i] = LLONG_MAX;

    }

    /*
        Declaramos el parametro T que es un par que une
        o contiene un numero long 'lli' y un entero. Este
        parametro representa una distancia y el Vertice
        desde el cual se calcula la dicha distancia.
        Despues, ordenamos estos pares segun el peso o
        distancia que existe entre los Vertices usando
        una Cola de Prioridad implementada dentro de C++
    */

    using T = pair<lli, int>;
    priority_queue<T, vector<T>, greater<T>> pq;

    /*
        Establecemos la distancia del Vertice de origen
        donde partiremos en el Algoritmo Dijkstra en 0
        Esto debido a que la distancia del Vertice de
        origen hacia el mismo en un Grafo es de 0
    */
    
    distances[origin] = 0;

    /*
        Agregamos a la Cola de Prioridad el Vertice de
        origen donde empezamos el Algoritmo Dijkstra con
        un valor de distancia o peso de Arista igual a 0
    */

    pq.push({0, origin});

    // Iteraremos mientras la Cola de Prioridad no este vacia

    while(pq.size()) {

        /*
            Declaramos unas variables auxiliares para almacenar
            el valor de la distancia y el nodo o Vertice origen
            en una tupla ya que al desencolar un valor de la
            Cola de prioridad devolvera un valor de tipo tupla
        */

        lli dist;
        int node;

        tie(dist, node) = pq.top();
        
        pq.pop();

        /*
            Obviaremos cuando tengamos que establecer la distancia
            desde Vertice origen hacia el mismo Vertice de origen
        */

        if(dist != distances[node]) continue;

        /*
            Finalmente iteraremos por todos los pares o tuplas del
            Grafo que generamos revisando si encontramos un camino
            de menor coste segun la teoria vista en Dijkstra. De
            esta manera devemos evaluar el resultado de:
            
            PseudoCodigo de Dijkstra clausula IF
            Si distancia[v] > distancia[u] + peso(u, v) entonces
                distancia[v] = distancia[u] + peso(u, v)
                padre[v] = u (Tambien conocido como predecesor)
                adicionar a la Cola de Prioridad (v, distancia[v])

        */

        for(pair<int, int> i : graph[node]) {

            if(dist + i.second < distances[i.first]) {

                pq.push({distances[i.first] = dist + i.second, i.first});

            }

        }
        

    }

}

// Metodo Main del programa

int main() {

    // Creamos la variable 'm' para los caminos a las ciudades

    int m;

    // Recibimos o leemos los valores para variables 'n' y 'm'

    cin >> n >> m;

    /*
        Iteraremos sobre las siguientes 'm' lineas ya que segun
        el enunciado. Se nos entregaran los datos de las Aristas
        en las siguiente 'm' lineas a leer, datos tales como
        punto de origen, punto de destino y costo de la Arista
    */

    for(int i = 0; i < m; i++) {
        
        int a, b, c;
        cin >> a >> b >> c;
        graph[a - 1].push_back({b - 1, c});

    }
    
    /*
        Ejecutamos el metodo 'dijkstra' desde '0' ya que el
        enunciado menciona que los datos de la ciudad Syrjala es
        la primera ciudad en nuestra lista o conjunto de ciudades
    */

    dijkstra(0);

    /*
        Finalmente imprimimos los resultados obtenidos despues
        de utilizar el Algoritmo Dijkstra para resolver el
        problema sobre las rutas desde Syrjala hacia el resto
    */

    for(int i = 0; i < n; i++) {

        cout << distances[i] << " ";

    }

}
