package view;

import java.util.Stack;

import model.estructuras.Queue;
import model.estructuras.Vertice;


public class View<K, V, A> {

	public void printMenu() {
		System.out.println("---------ISIS 1206 - Estructuras de datos----------");
		System.out.println("---------------------Proyecto 3----------------------");
		System.out.println("0. Cargar el Grafo No Dirigido de la malla vial: Downtown o Ciudad Completa");
		
		System.out.println("1. Encontrar el camino de costo mínimo para un viaje entre  dos vertices.. (REQ 1A)");
		System.out.println("2. Determinar los n vértices con mayor número de infracciones y sus componentes conectadas (REQ 2A)");
		
		System.out.println("3. Encontrar el camino más corto para un viaje entre  dos vertices. (REQ 1B)");		
		System.out.println("4. Definir una cuadricula regular de N columnas por M filas.  (REQ 2B)"); 
		
		System.out.println("5. Calcular un árbol de expansión mínima (MST) con criterio distancia, utilizando el algoritmo de Kruskal (REQ 1C)");
		System.out.println("6. Calcular un árbol de expansión mínima (MST) con criterio distancia, utilizando el algoritmo de Prim. (REQ 2C)");
		System.out.println("7. Calcular los caminos de costo mínimo con criterio distancia que conecten los vértices resultado "
				+ "de la aproximación de las ubicaciones de la cuadricula N x M encontrados en el punto 5. (REQ 3C)");
		System.out.println("8. Encontrar el camino más corto para un viaje entre dos vertices. (REQ 4C)");
		
		System.out.println("9. Salir");
		System.out.println("Digite el numero de opcion para ejecutar la tarea, luego presione enter: (Ej., 1):");
		
	}

	public void printMessage(String string) {
		System.out.println(string);
		
	}
//	Muestre en la consola de texto el número de vértices en el grafo
//	resultado de la aproximación. Mostar el identificador y la ubicación geográfica de cada
//	uno de estos vértices.
//	Visualización mapa: Marque las ubicaciones de los vértices resultantes de la
//	aproximación de la cuadrícula en Google Maps.
	public void printB2(Queue<Vertice<K, V>> queue){
		System.out.println("Numero de vertices de la aproximación: "+ queue.size());
		for (int i = 0; i < queue.size(); i++) {
			Vertice<K, V> vertice = queue.dequeue();
			System.out.println("ID: "+vertice.darID());
			System.out.println("Latitud: "+vertice.darInfo().getLat());
			System.out.println("Longitud: "+vertice.darInfo().getLon());
			System.out.println("String con el poligono a dibujar en el mapa:\n");
			Vertice<K, V> verticeSacado = queue.dequeue();
			System.out.println("{new LatLng("+verticeSacado.darInfo().getLat()+", "+verticeSacado.darInfo().getLon()+")");
			for(int j = 0; j< queue.size()-1;j++){
				verticeSacado = queue.dequeue();
				System.out.println(",{new LatLng("+verticeSacado.darInfo().getLat()+", "+verticeSacado.darInfo().getLon()+")");
			}
			verticeSacado = queue.dequeue();
			System.out.println(",{new LatLng("+verticeSacado.darInfo().getLat()+", "+verticeSacado.darInfo().getLon()+")}");
//			{new LatLng(25.774, -80.190),
//                new LatLng(18.466, -66.118),
//                new LatLng(32.321, -64.757),
//                new LatLng(25.774, -80.190)};
		}
	}
	
	public void printB1(Queue<Vertice<K, V>> queue){
		System.out.println("Numero de vertices de la aproximación: "+ queue.size());
		for (int i = 0; i < queue.size(); i++) {
			Vertice<K, V> vertice = queue.dequeue();
			System.out.println("ID: "+vertice.darID());
			System.out.println("Latitud: "+vertice.darInfo().getLat());
			System.out.println("Longitud: "+vertice.darInfo().getLon());
			System.out.println("String con el poligono a dibujar en el mapa:\n");
			Vertice<K, V> verticeSacado = queue.dequeue();
			System.out.println("{new LatLng("+verticeSacado.darInfo().getLat()+", "+verticeSacado.darInfo().getLon()+")");
			for(int j = 0; j< queue.size()-1;j++){
				verticeSacado = queue.dequeue();
				System.out.println(",{new LatLng("+verticeSacado.darInfo().getLat()+", "+verticeSacado.darInfo().getLon()+")");
			}
			verticeSacado = queue.dequeue();
			System.out.println(",{new LatLng("+verticeSacado.darInfo().getLat()+", "+verticeSacado.darInfo().getLon()+")}");
//			{new LatLng(25.774, -80.190),
//                new LatLng(18.466, -66.118),
//                new LatLng(32.321, -64.757),
//                new LatLng(25.774, -80.190)};
		}
	}
	public void printC3(Stack<Vertice<K, V>> stack){
		System.out.println("Numero de vertices de la aproximación: "+ stack.size());
		for (int i = 0; i < stack.size(); i++) {
			Vertice<K, V> vertice = stack.pop();
			System.out.println("ID: "+vertice.darID());
			System.out.println("Latitud: "+vertice.darInfo().getLat());
			System.out.println("Longitud: "+vertice.darInfo().getLon());
			System.out.println("String con el poligono a dibujar en el mapa:\n");
			Vertice<K, V> verticeSacado = stack.pop();
			System.out.println("{new LatLng("+verticeSacado.darInfo().getLat()+", "+verticeSacado.darInfo().getLon()+")");
			for(int j = 0; j< stack.size()-1;j++){
				verticeSacado = stack.pop();
				System.out.println(",{new LatLng("+verticeSacado.darInfo().getLat()+", "+verticeSacado.darInfo().getLon()+")");
			}
			verticeSacado = stack.pop();
			System.out.println(",{new LatLng("+verticeSacado.darInfo().getLat()+", "+verticeSacado.darInfo().getLon()+")}");
//			{new LatLng(25.774, -80.190),
//                new LatLng(18.466, -66.118),
//                new LatLng(32.321, -64.757),
//                new LatLng(25.774, -80.190)};
		}
	}
	
	
}