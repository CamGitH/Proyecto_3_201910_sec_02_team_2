package view;

import java.beans.VetoableChangeListener;

import com.teamdev.jxmaps.LatLng;

import model.estructuras.Queue;
import model.estructuras.Vertice;
import model.violations.GraphInfo;

public class View {

	public void printMenu() {
		System.out.println("---------ISIS 1206 - Estructuras de datos----------");
		System.out.println("---------------------Proyecto 3----------------------");
		System.out.println("0. Cargar el Grafo No Dirigido de la malla vial: Downtown o Ciudad Completa");
		
		System.out.println("1. Encontrar el camino de costo m�nimo para un viaje entre  dos vertices.. (REQ 1A)");
		System.out.println("2. Determinar los n v�rtices con mayor n�mero de infracciones y sus componentes conectadas (REQ 2A)");
		
		System.out.println("3. Encontrar el camino m�s corto para un viaje entre  dos vertices. (REQ 1B)");		
		System.out.println("4. Definir una cuadricula regular de N columnas por M filas.  (REQ 2B)"); 
		
		System.out.println("5. Calcular un �rbol de expansi�n m�nima (MST) con criterio distancia, utilizando el algoritmo de Kruskal (REQ 1C)");
		System.out.println("6. Calcular un �rbol de expansi�n m�nima (MST) con criterio distancia, utilizando el algoritmo de Prim. (REQ 2C)");
		System.out.println("7. Calcular los caminos de costo m�nimo con criterio distancia que conecten los v�rtices resultado "
				+ "de la aproximaci�n de las ubicaciones de la cuadricula N x M encontrados en el punto 5. (REQ 3C)");
		System.out.println("8. Encontrar el camino m�s corto para un viaje entre dos vertices. (REQ 4C)");
		
		System.out.println("9. Salir");
		System.out.println("Digite el numero de opcion para ejecutar la tarea, luego presione enter: (Ej., 1):");
		
	}

	public void printMessage(String string) {
		System.out.println(string);
		
	}
//	Muestre en la consola de texto el n�mero de v�rtices en el grafo
//	resultado de la aproximaci�n. Mostar el identificador y la ubicaci�n geogr�fica de cada
//	uno de estos v�rtices.
//	Visualizaci�n mapa: Marque las ubicaciones de los v�rtices resultantes de la
//	aproximaci�n de la cuadr�cula en Google Maps.
	public void printB1(Queue<Vertice<Long, GraphInfo>> cola){
		System.out.println("Numero de vertices de la aproximaci�n: "+ cola.size());
		int n = 0;
		for (int i = 0; i < cola.size(); i++) {
			Vertice<Long, GraphInfo> vertice = cola.dequeue();
			System.out.println("ID: "+vertice.darID());
			System.out.println("Latitud: "+vertice.darInfo().getLat());
			System.out.println("Longitud: "+vertice.darInfo().getLon());
			System.out.println("String con el poligono a dibujar en el mapa:\n");
			Vertice<Long, GraphInfo> verticeSacado = cola.dequeue();
			System.out.println("{new LatLng("+verticeSacado.darInfo().getLat()+", "+verticeSacado.darInfo().getLon()+")");
			for(int j = 0; j< cola.size()-1;j++){
				verticeSacado = cola.dequeue();
				System.out.println(",{new LatLng("+verticeSacado.darInfo().getLat()+", "+verticeSacado.darInfo().getLon()+")");
			}
			verticeSacado = cola.dequeue();
			System.out.println(",{new LatLng("+verticeSacado.darInfo().getLat()+", "+verticeSacado.darInfo().getLon()+")}");
//			{new LatLng(25.774, -80.190),
//                new LatLng(18.466, -66.118),
//                new LatLng(32.321, -64.757),
//                new LatLng(25.774, -80.190)};
		}
	}
	
}