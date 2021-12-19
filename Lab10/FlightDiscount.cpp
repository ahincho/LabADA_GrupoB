
#include <bits/stdc++.h>
using namespace std;
#define lli long long int

/* 
    Autor: Hincho Jove, Angel Eduardo

    Descripcion del Problema: Tenemos un boleto de descuento
    el cual reduce el precio de un vuelo en su mitad o 50% y
    queremos recorrer las ciudades de tal manera que nuestra
    primera Ciudad o punto de partida es la Ciudad 1 Syrjala
    y debemos llegar a Ciudad 'n' o punto de destino Metsala

    Existen 'm' vuelos diferentes entre las 'n' ciudades que
    conforman la aerolinea, los vuelos se entregan de la forma
    [a, b, c] donde 'c' es el costo y los otros dos vertices

    Ojo: Podemos asumir que siempre podemos llegar desde la
    Ciudad Syrjala hacia la Ciudad Metsala en todos los casos
*/

/*
    Solucion del Problema: Como se trata de un problema de
    encontrar las distancias desde una ciudad hacia otra u
    otras en este caso, ademas de no existir ponderaciones
    o pesos negativos en las aristas asi como tampoco hay
    ciclos entre estas. Usaremos el Algoritmo Dijkstra.
*/

/*
    Creamos nuestras variables para los valores del enunciado
        n : Cantidad de ciudades que existen
        m : Cantidad de vuelos entre las ciudades
        a : Ciudad de Origen o Partida del vuelo
        b : Ciudad de Destino o Destino del vuelo
        c : Costo del vuelo para llegar de una ciudad a otra
    Finalmente establecemos el valor infinito para Dijkstra
*/

lli n, m;
const lli inf = 1e18;

/*
    Establecemos algunos parametros para resumir nuestra
    representacion del Grafo, siendo entonces:
        T : Parametro para una tupla [long, long] siendo
            estos parametros los Vertices 'b' y 'a'
        E : Parametro para una tupla [long, T] siendo estos
            parametros el costo 'c' y vertices o ciudades
*/

using T = pair<lli, lli>;
using E = pair<lli, T>;

// Creamos un arreglo bidimensional que representa un Grafo

vector<vector<T>> graph;

// Creamos un arreglo estandar para distancias o costos entre Ciudades
vector<lli> distances;

// Creamos un arreglo estandar para los posibles descuentos de vuelo

vector<lli> discounts;

/*
    Metodo Dijkstra. Utilizaremos el metodo Dijkstra
    debido a que trabajaremos con distancias las
    cuales no son negativas y no existe ningun ciclo
*/

void dijkstra() {
    
    // Creamos una Cola de Prioridad para nuestra tupla de Costos
    // y tuplas que describen los Vertices de Origen y Destino (T)

    priority_queue<E, vector<E>, greater<E>> pq;

    // Empezamos a rellenar los arreglos para las distancias y
    // costos entre ciudades con 'infinito' empezando en Ciudad 1

	for(int i = 2; i <= n; i++) {
		
        distances[i] = inf; 
		discounts[i] = inf;

	}

    /*
        Establecemos el Costo para llegar a la Ciudad 1 en 0 asi
        como sus Vertices de Origen en '0' y Vertice de Destino '1'
        Esto debido a la teoria vista en Dijkstra donde para llegar
        al punto de partida o hacia una misma ciudad su costo sera '0'
    */

	pq.push({0, {1, 0}});
    
    // Iteraremos mientras que la Cola de Prioridad no este vacia

	while(!pq.empty()) {
        
        /*
            Rescatamos algunos valores, siendo estos:
            d : Costo para llegar a la ciudad especificada
            u : Vertice o Ciudad de Origen
            f : Vertice o Ciudad de Destino
            Finalmente desencolamos la tupla usada o iterada
        */

        lli d = pq.top().first;
		lli u = pq.top().second.first;
		lli f = pq.top().second.second;
		pq.pop();

        /*
            Si la Ciudad de Destino es la Ciudad 1 solo evaluamos
            que su descuento registrado sea menor a su costo, que
            en este caso seria '0' para ambos. Continuamos con las
            otras Ciudades ya que Ciudad 1 tiene de costo fijo '0'
        */

		if(f == 1) {
			
            if(discounts[u] < d) continue;

		}

        /*
            De igual manera si la Ciudad de Origen es la Ciudad 0
            entonces es nuestra raiz o caso base para armar nuestro
            Grafo, al igual que Ciudad 1, continuamos con las demas
        */

		if(f == 0) {
			
            if(distances[u] < d) continue;

		}

        /*
            Para cada Ciudad que se pueda alcanzar desde la Ciudad
            de Origen o Ciudad 'u' entonces debemos evaluar su
            Vertice o Ciudad de Destino y su Costo para llegar
        */

		for(auto e: graph[u]) {
			
            lli v = e.first, c = e.second;

            /*
                El valor de 'f' indicara si hemos vistado o no la
                Ciudad de destino con la cual estamos trabajado y
                si ya hemos evaluado sus posible costos para llegar
            */

            if(f == 0)  {
                
                /*
                    En caso de no haber sido anteriormente entonces
                    establecemos la distancia segun el pseudocodigo
                    visto para Dijkstra y evaluamos su costo para 
                    llegar a dicha ciudad usando el descuento

                    PseudoCodigo de Dijkstra clausula IF
                        Si distancia[v] > distancia[u] + peso(u, v) entonces
                        distancia[v] = distancia[u] + peso(u, v)
                        padre[v] = u (Tambien conocido como predecesor)
                        adicionar a la Cola de Prioridad (v, distancia[v])
                */

                if(distances[v] > c + d) {
					
                    distances[v] = c + d;
					pq.push({distances[v], {v, 0}});

				}

                /*
                    El descuento se establece aplicando al ultimo viaje
                    registrado, visitado o sobre el cual estamos iterando
                */

				if(discounts[v] > d + c / 2)  {
					
                    discounts[v] = d + c / 2;
					pq.push({discounts[v], {v, 1}});

				}

			}

            /*
                Cuando el valor de 'f' es igual a '1' significa que ya
                hemos visitado dicha Ciudad y lo unico que debemos hacer
                es volver a evualuar los posibles costos para llegar a ella
            */

			if(f == 1) {
				
                /*
                    El descuento se establece aplicando al ultimo viaje
                    registrado, visitado o sobre el cual estamos iterando
                */

                if(discounts[v] > d + c) {
					
                    discounts[v] = d + c;
					pq.push({discounts[v], {v, 1}});

				}

			}
 
		}
	}

    /*
        Imprimimos el mejor precio que encontramos para llegar
        a la Ciudad 'n' desde la Ciudad 1 (Syrjala a Metsala)
    */

	cout << discounts[n] << endl;

}

// Metodo Main del programa

int32_t main() {

    // Recibimos o leemos valores para variables 'n' y 'm'

	cin >> n >> m;

    /*
        Redimensionamos el arreglo para representacion Grafo
        los arreglos que guardan las distancias y descuentos
    */

    graph.resize(n + 1);
	distances.resize(n + 1);
	discounts.resize(n + 1);

    // Leemos las siguiente 'm' lineas que describen los 'm'
    // vuelos que conectan las 'n' ciudades ya vistas antes

	for(int i = 0; i < m; i++) {
		
        lli u, v, c;
		cin >> u >> v >> c;
		graph[u].push_back({v, c});

	}

    // Resolvemos y damos respuesta usando Dijkstra
 
	dijkstra();

}
