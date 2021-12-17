
#include <bits/stdc++.h>
#define lli long long int
using namespace std;

/* 
    Autor: Hincho Jove, Angel Eduardo

    Descripcion del Problema: Se nos hace entrega de una
    cantidad 'n' de ciudades y las 'm' carreteras o rutas
    que unen estas ciudades. Se nos pide entregrar el peso
    o coste minimo para poder recorrer todas las ciudades
    y de esta manera hallar el costo minimo de repacion
*/

/*
    Solucion del Problema: Se resolvio utilizando lo visto
    en el Algoritmo de Kruskal, recibimos las Aristas y que
    Vertices unen estas. Establecemos un arreglo o cola de
    prioridad segun el coste o peso de las Aristas y vamos
    seleccionando de una en una. Elegimos aquellas Aristas
    que conecten dos Vertices o ciudades no visitadas
*/

/*
    Creamos la Estructura Arista o Edge para representar
    nuestro Grafo dento del problema. Struct es como una
    clase de Java, luego definimos sus atributos de Clase
*/

struct Edge {

    // Atributo Origin, Vertice de Origen
    int origin;

    // Atributo Destiny, Vertice de Destino
    int destiny;

    // Atributo Weight, Peso de la Arista
    lli weight;

};

// Variables Globales edgeArray y path

/*
    Luego creamos un arreglo estandar o vector, como se
    se le conoce centro de C++ para nuestras Aristas o
    Caminos que recibiremos dentro del problema propuesto
*/

vector<Edge> edgeArray;

/*
    Creamos el arreglo path que representara los posibles
    caminos o rutas 'm' que se generaran dentro del Grafo
*/

int path[200001];

/*
    Metodo compareTo, como se conoce en Java para poder
    establecer un orden o prioridad en la clase Arista
*/

bool compareTo(Edge a, Edge b) {

    // Comparamos los pesos de ambas Aristas

    return a.weight < b.weight;

}

/*
    Metodo Find, recibe un Vertice de origen y devuelve
    el Vertice maximo donde se puede llegar o Vertice de
    Destino maximo asociado a ese Origen en el Path
*/

int find(int a) {

    /* 
        En caso el valor en el Path para el Vertice 'a'
        sea igual a '-1' significa que hallamos el mayor
        Vertice donde podemos llegar a partir de 'a'
    */

    if(path[a] == -1) {
        
        return a;

    }

    /*
        En caso sea diferente de '-1' signfica que podemos
        llegar mas lejos desde el Vertice inicial 'a' y
        debemos seguir revisando en busqueda del Vertice
        de Destino mas alejado posible que podemos llegar
    */

    return path[a] = find(path[a]);

}

/*
    Metodo mergeEdge que une los Vertices de Origen
    y Destino de una Arista dentro del Grafo y tambien
    los guarda dentro del Path en caso que una dos
    Vertices o puntos diferentes. No se admiten Aristas
    que unan un Vertice consigo mismo ya que seria un bucle 
*/

bool mergeEdge(int a, int b) {

    /*
        Encontramos los Vertices mas alejados para los
        Vertices dentro del Path con la funcion o metodo
        Find tanto para el Vertice de Origen y Destino
        de la Arista, siendo 'a' y 'b' respectivamente
    */

    a = find(a);
    b = find(b);

    /*
        En caso de ser una Ruta hacia el mismo Vertice
        no se aceptara ya que podria, o genera, un bucle
    */

    if(a == b) {
        
        return false;

    }

    // Unimos los Vertices de Origen y Destino en Path

    path[a] = b;

    return true;

}

// Metodo Main del programa

int main() {

    /*
        Variables entregadas en el enunciado del problema
        siendo 'n' cantidad de ciudades y 'm' cantidad de
        carreteras o rutas entre las ciudades. El valor
        auxiliar 'visitedEdges' nos ayudara a ver las
        Aristas que visitaremos para unir los Vertices
    */

    int n, m, visitedEdges = 0;
    
    // Variable auxiliar para el costo minimo del recorrido
    
    lli minimalCost = 0;

    // Variable auxiliar para ingresos de Objetos tipo Edge

    Edge temp;

    // Recibimos el valor de las ciudades y las rutas

    cin >> n >> m;

    // Iniciamos nuestro Path con -1 para las ciudades

    for(int i = 1; i <= n; i++) {

        path[i] = -1;

    }

    // Ingresamos las carreteras de las siguiente 'm' lineas

    for(int i = 0; i < m; i++) {

        cin >> temp.origin;
        cin >> temp.destiny;
        cin >> temp.weight;

        edgeArray.push_back(temp);

    }

    // Ordenamos el arreglo de Aristas usando compareTo()

    sort(edgeArray.begin(), edgeArray.end(), compareTo);

    // Iteraremos por las Aristas que tenemos en el arreglo

    for(Edge e : edgeArray) {
        
        // Si los Vertices de la Arista se pueden unir

        if(mergeEdge(e.origin, e.destiny)) {

            /*
                En caso puedan ser unidos entonces aumentamos
                el peso de la Arista en interacion a variable
                auxiliar 'minimalCost' Incrementamos variable
                'visitedEdges' en una unidad ya que en esta
                clausula 'if' hemos seleccionado una Arista
            */

            minimalCost += e.weight;
            visitedEdges++;

        }

    }

    /*
        Finalmente para dar nuestra respuesta debemos verificar
        haber recorrido todas las Aristas y unido todas estas
    */

    /*
        En caso de haber unido todas las Aristas entonces el
        valor de 'visitedEdges' debe ser igual a 'n - 1' esto
        debido a que segun el lema: Para unir 'n' Vertices 
        necesitaremos 'n - 1' Aristas entre estos Vertices
    */

    if(visitedEdges == n - 1) {

        // En caso haber unido todos los Vertices o Ciudades

        cout << minimalCost;

    } else {

        // En caso de no haber unido todos los Vertices

        cout << "IMPOSSIBLE";

    }

}
