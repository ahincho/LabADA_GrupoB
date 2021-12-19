
#include <bits/stdc++.h>
using namespace std;
const int maxValueN = 1e5+1;

/* 
    Autor: Hincho Jove, Angel Eduardo

    Descripcion del Problema: Se nos presente a Uolevi quien
    acabada de ganar un concurso y el premio consiste en un
    viaje de uno o mas vuelos entre ciudades. De esta manera
    a Uolevi le conviene el viaje que abarque la mayor cantidad
    de ciudades visite como sea posible. Empezando desde de la
    Ciudad 1 (Syrjala) hasta la Ciudad n (Lehmla)

    Ojo: Para este problema las vias o rutas son en una sola
    direccion o sea se trata de un Grafo Dirigido ademas que
    no existen ciclos dirigidos en las lineas de aerovuelos
*/

/*
    Solucion del Problema: Como se trata de un problema de
    encontrar el camino mas largo desde una Ciudad o Vertice
    dentro de un Grafo, podemos utilizar el Algoritmo DFS que
    nos ayuda a recorrer el Grafo tomando en cuenta primero
    aquellos vertices que sean 'mas profundos' o nivel 'n'
*/

/*
    Creamos nuestras variables para los valores del enunciado
        n : Cantidad de ciudades de cuiudades
        m : Cantidad de rutas o vuelos entre las ciudades
*/

int n, m;

/*
    Creando arreglo booleano para verificar si un Vertice fue
    visitado anteriomente o no aun no ha sido descubierto por ahora
*/

bool visitedVertexs[maxValueN];

// Arreglo adicionales para poder dar respuesta a nuestro problema

int in[maxValueN], p[maxValueN], l[maxValueN], answer[maxValueN];

// Creamos nuestro Grafo con un areglo de nuestro Vertices

vector<int> graph[maxValueN];

// Creamos una cola de Prioridad para poder desplazarnos

queue<int> q;

/*
    Metodo DFS. Utilizaremos el algoritmo DFS
    debido a que necesitamos hallar el nodo mas
    profundo o camino mas largo dentro del Grafo
*/

void dfs(int son, int father) {

    // Revisamos que el hijo no haya sido visitado

    visitedVertexs[son] = true;
    
    /*
        Para los Vertices que nacen o salen de 'son'
        iteraremos mientras que sean diferentes al
        padres y dicho Vertice no haya sido visitado
    */

    for(int v : graph[son]) {

        if(v != father && !visitedVertexs[v]) {

            dfs(v, son);

        }

    }
    
}

// Metodo Main del programa

int main() {

    // Leemos o recibimos los valores para 'n' y 'm'

    cin >> n >> m;
    
    // Creamos variables auxiliar 'a' y 'b' para leer

    int a, b;

    // Leemos las siguientes 'm' lineas con las Aristas
    // o conexiones que existen dentro de nuestro Grafo

    for(int i = 0; i < m; i++) {

        cin >> a >> b;

        // Agregamos las Arista desde el Origen hasta el Destino

        graph[a].push_back(b);

        /*
            Asi mismo tambien agregamos la Arista o camino entre
            las dos ciudades para la Ciudad 'a'. Esta parte es la
            Lista de Adyacencia para representar caminos en Grafo
        */

        in[b]++;

    }

    dfs(1, 0);
    
    /*
        Debemos revisar el arreglo o vector para los Vertices
        ya visitados dentro del Grafo, si el Vertice 'n' o la
        Ciudad 'n' no ha sido visitada entonces no existe una
        ruta o forma de llegar de Vertice '1' hacia Vertice 'n'
    */

    if(!visitedVertexs[n]) {

        printf("IMPOSSIBLE\n");
        return 0;

    }

    /*
        Rellenamos desde la Ciudad 2 hasta la Ciudad 'n' con
        -1 para indicar que aun no se han visitado o descubierto
    */

    fill(l + 2, l + maxValueN, -1);
    
    // Iteraremos sobre todas nuestras Ciudades del Grafo

    for(int i = 1; i <= n; i++) {

        /*
            Agregaremos las Ciudades a la Cola y su Lista de
            Adyacencia con los destinos que podemos llegar
        */

        if(in[i] == 0) {

            q.push(i);

        }

    }

    // Iteraremos mientras la Cola de Prioridad tenga elementos

    while(!q.empty()) {
        
        // Recuperamos el dato o Ciudade de Origen donde partiremos

        int u = q.front();
        q.pop();

        // Iteraremos sobre su Lista de Adyacencia y sus Hijos

        for(int v : graph[u]) {
            
            // Si aun no ha sido Visitado lo marcamos como visitado

            if(l[u] != -1 && l[v] < l[u] + 1) {
                
                l[v] = l[u] + 1;
                p[v] = u;

            }

            // Reducimos la cantidad de caminos en la Lista de Adyacencia

            in[v]--;

            /*
                Finalmente si el vertice ya no tiene mas caminos para evaluar
                lo devolveremos a la Cola de Prioridad para seguir trabajando
            */

            if(in[v] == 0) {

                q.push(v);

            }

        }

    }

    /*
        Asi mismo creamos la variables 'routes' o caminos desde
        Ciudad 1 hasta la Ciudad N desde Syrjala hasta Lehmala
    */

   /*
        Restamos las rutas para llegar al Vertice 'n' menos las
        rutas para llegar al vertice para llegar a la Ciudad 1
   */

    int routes = l[n] - l[1];
    
    /*
        Imprimimos la cantidad de rutas a recorrer para llegar desde
        el Vertice o Ciudad 1 hasta la Ciudad 'n' o Vertice 'n' final
    */

    cout << routes + 1 << endl;

    /*
        Iteraremos sobre las rutas de manera inversa para almacenarlas
        en el arreglo auxiliar answer, guardaremos el valor o nombre
        del Vertice donde estamos iterando en arreglo auxiliar 'answer'
    */

    for(int i = routes, u = n; i >= 0; i--) {
        
        answer[i] = u;
        u = p[u];

    }

    /*
        Finalmente una vez guardada la respuesta en orden inverso, desde
        la Ciudad o Vertice 1 hacia la Ciudad 'n' o Vertice 'n' menos
    */

    for(int i = 0; i <= routes; i++) {

        cout << answer[i] << " ";

    }

}
