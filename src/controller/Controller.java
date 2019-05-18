package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.opencsv.CSVReader;

import model.estructuras.Arco;
import model.estructuras.ColaPrioridadHeap;
import model.estructuras.Graph;
import model.estructuras.LinkedList;
import model.estructuras.NodoLinkedList;
import model.estructuras.Queue;
import model.estructuras.Vertice;
import model.violations.GraphInfo;
import model.violations.VOMovingViolation;
import view.View;

public class Controller<K, V, A> {

	Queue<VOMovingViolation> cola;
	// Componente vista (consola)
	private View view;

	private Graph grafo;

	LinkedList<VOMovingViolation> listaEncadenda;

	//TODO Definir los atributos de estructuras de datos del modelo del mundo del proyecto


	/**
	 * Metodo constructor
	 */
	public Controller()
	{
		view = new View();
		cola = new Queue<VOMovingViolation>();
		grafo = new Graph<>();
		listaEncadenda = new LinkedList<VOMovingViolation>();
	}

	/**
	 * Metodo encargado de ejecutar los  requerimientos segun la opcion indicada por el usuario
	 */
	public void run(){

		long startTime;
		long endTime;
		long duration;

		Scanner sc = new Scanner(System.in);
		boolean fin = false;


		while(!fin){
			view.printMenu();

			int option = sc.nextInt();
			int idVertice1 = 0;
			int idVertice2 = 0;


			switch(option){

			case 0:
				String RutaArchivo = "";
				view.printMessage("Escoger el grafo a cargar: (1) Downtown  o (2)Ciudad Completa.");
				int ruta = sc.nextInt();
				if(ruta == 0)
					RutaArchivo = "./data/finalGraph.json"; //TODO Dar la ruta del archivo de Downtown
				else
					RutaArchivo = "./data/finalGraph.json"; //TODO Dar la ruta del archivo de la ciudad completa

				startTime = System.currentTimeMillis();
				loadJSON(RutaArchivo);
				endTime = System.currentTimeMillis();
				duration = endTime - startTime;
				view.printMessage("Tiempo del requerimiento: " + duration + " milisegundos");
				// TODO Informar el total de vértices y el total de arcos que definen el grafo cargado

				System.out.println("Vertices"+grafo.darListaNodos().size());
				System.out.println("Arcos "+grafo.darListaArcos().size());
				break;


			case 1:

				view.printMessage("Ingrese El id del primer vertice (Ej. 901839): ");
				idVertice1 = sc.nextInt();
				view.printMessage("Ingrese El id del segundo vertice (Ej. 901839): ");
				idVertice2 = sc.nextInt();


				startTime = System.currentTimeMillis();
				caminoCostoMinimoA1(idVertice1, idVertice2);
				endTime = System.currentTimeMillis();
				duration = endTime - startTime;
				view.printMessage("Tiempo del requerimiento: " + duration + " milisegundos");
				/* 
				TODO Consola: Mostrar el camino a seguir con sus vértices (Id, Ubicación Geográfica),
				el costo mínimo (menor cantidad de infracciones), y la distancia estimada (en Km).

				TODO Google Maps: Mostrar el camino resultante en Google Maps 
				(incluyendo la ubicación de inicio y la ubicación de destino).
				 */
				break;

			case 2:
				view.printMessage("2A. Consultar los N v�rtices con mayor n�mero de infracciones. Ingrese el valor de N: ");
				int n = sc.nextInt();


				startTime = System.currentTimeMillis();
				mayorNumeroVerticesA2(n);
				endTime = System.currentTimeMillis();
				duration = endTime - startTime;
				view.printMessage("Tiempo del requerimiento: " + duration + " milisegundos");
				/* 
				TODO Consola: Mostrar la informacion de los n vertices 
				(su identificador, su ubicación (latitud, longitud), y el total de infracciones) 
				Mostra el número de componentes conectadas (subgrafos) y los  identificadores de sus vertices 

				TODO Google Maps: Marcar la localización de los vértices resultantes en un mapa en
				Google Maps usando un color 1. Destacar la componente conectada más grande (con
				más vértices) usando un color 2. 
				 */
				break;

			case 3:			

				view.printMessage("Ingrese El id del primer vertice (Ej. 901839): ");
				idVertice1 = sc.nextInt();
				view.printMessage("Ingrese El id del segundo vertice (Ej. 901839): ");
				idVertice2 = sc.nextInt();


				startTime = System.currentTimeMillis();
				caminoLongitudMinimoaB1(idVertice1, idVertice2);
				endTime = System.currentTimeMillis();
				duration = endTime - startTime;
				view.printMessage("Tiempo del requerimiento: " + duration + " milisegundos");

				/*
				   TODO Consola: Mostrar  el camino a seguir, informando
					el total de vértices, sus vértices (Id, Ubicación Geográfica) y la distancia estimada (en Km).

				   TODO Google Maps: Mostre el camino resultante en Google Maps (incluyendo la
					ubicación de inicio y la ubicación de destino).
				 */
				break;

			case 4:		
				double lonMin;
				double lonMax;
				view.printMessage("Ingrese la longitud minima (Ej. -87,806): ");
				lonMin = sc.nextDouble();
				view.printMessage("Ingrese la longitud m�xima (Ej. -87,806): ");
				lonMax = sc.nextDouble();

				view.printMessage("Ingrese la latitud minima (Ej. 44,806): ");
				double latMin = sc.nextDouble();
				view.printMessage("Ingrese la latitud m�xima (Ej. 44,806): ");
				double latMax = sc.nextDouble();

				view.printMessage("Ingrese el n�mero de columnas");
				int columnas = sc.nextInt();
				view.printMessage("Ingrese el n�mero de filas");
				int filas = sc.nextInt();


				startTime = System.currentTimeMillis();
				definirCuadriculaB2(lonMin,lonMax,latMin,latMax,columnas,filas);
				endTime = System.currentTimeMillis();
				duration = endTime - startTime;
				view.printMessage("Tiempo del requerimiento: " + duration + " milisegundos");
				/*
				   TODO Consola: Mostrar el número de vértices en el grafo
					resultado de la aproximación. Mostar el identificador y la ubicación geográfica de cada
					uno de estos vértices. 

				   TODO Google Maps: Marcar las ubicaciones de los vértices resultantes de la
					aproximación de la cuadrícula en Google Maps.
				 */
				break;

			case 5:

				startTime = System.currentTimeMillis();
				arbolMSTKruskalC1();
				endTime = System.currentTimeMillis();
				duration = endTime - startTime;
				view.printMessage("Tiempo del requerimiento: " + duration + " milisegundos");
				/*
				   TODO Consola: Mostrar los vértices (identificadores), los arcos incluidos (Id vértice inicial e Id vértice
					final), y el costo total (distancia en Km) del árbol.

				   TODO Google Maps: Mostrar el árbol generado resultante en Google Maps: sus vértices y sus arcos.
				 */

				break;

			case 6:

				startTime = System.currentTimeMillis();
				arbolMSTPrimC2();
				endTime = System.currentTimeMillis();
				duration = endTime - startTime;
				view.printMessage("Tiempo del requerimiento: " + duration + " milisegundos");
				/*
				   TODO Consola: Mostrar los vértices (identificadores), los arcos incluidos (Id vértice inicial e Id vértice
				 	final), y el costo total (distancia en Km) del árbol.

				   TODO Google Maps: Mostrar el árbol generado resultante en Google Maps: sus vértices y sus arcos.
				 */
				break;

			case 7:

				startTime = System.currentTimeMillis();
				caminoCostoMinimoDijkstraC3();
				endTime = System.currentTimeMillis();
				duration = endTime - startTime;
				view.printMessage("Tiempo del requerimiento: " + duration + " milisegundos");
				/*
				   TODO Consola: Mostrar de cada camino resultante: su secuencia de vértices (identificadores) y su costo (distancia en Km).

				   TODO Google Maps: Mostrar los caminos de costo mínimo en Google Maps: sus vértices
					y sus arcos. Destaque el camino más largo (en distancia) usando un color diferente
				 */
				break;

			case 8:
				view.printMessage("Ingrese El id del primer vertice (Ej. 901839): ");
				idVertice1 = sc.nextInt();
				view.printMessage("Ingrese El id del segundo vertice (Ej. 901839): ");
				idVertice2 = sc.nextInt();

				startTime = System.currentTimeMillis();
				caminoMasCortoC4(idVertice1, idVertice2);
				endTime = System.currentTimeMillis();
				duration = endTime - startTime;
				view.printMessage("Tiempo del requerimiento: " + duration + " milisegundos");
				/*
				   TODO Consola: Mostrar del camino resultante: su secuencia de vértices (identificadores), 
				   el total de infracciones y la distancia calculada (en Km).

				   TODO Google Maps: Mostrar  el camino resultante en Google Maps: sus vértices y sus arcos.	  */
				break;

			case 9: 	
				fin = true;
				sc.close();
				break;

			case 10:
				this.loadMovingViolations(1);
				System.out.println(cola.size());
				System.out.println(cola.dequeue().TOSTRING());
				break;
			}
		}
	}


	// TODO El tipo de retorno de los m�todos puede ajustarse seg�n la conveniencia


	/**
	 * Cargar el Grafo No Dirigido de la malla vial: Downtown o Ciudad Completa
	 * @param rutaArchivo 
	 */

	public void loadJSON(String rutaArchivo) 
	{
		Gson gson = new Gson();
		JsonReader reader;

		try {

			reader = new JsonReader(new FileReader(rutaArchivo));
			readFilesJson(gson, reader);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("termino");
	}



	private void readFilesJson(Gson pGson, JsonReader pReader){
		GraphInfo[] lista = pGson.fromJson(pReader, GraphInfo[].class);
		for(int i = 0; i<lista.length;i++){

			for(int j = 0; j<lista[i].getAdj().length;j++){
				double peso = 0;
				double latitud = lista[i].getLat();
				double longitud = lista[i].getLon();
				double latitud2 = 0;
				double longitud2 = 0;
				boolean encontro = false;
				int adyacente = 0;
				for(int k = 0; k<lista.length && !encontro;k++){
					if(lista[k].getId()==lista[i].getId()){
						latitud2 = lista[k].getLat();
						longitud2 = lista[k].getLon();
						encontro = true;
						adyacente = j;
					}

				}
				if(encontro){
					peso = distance(latitud, latitud2, longitud, longitud2, 0.0, 0.0);
					try {
						grafo.addEdge(lista[i].getId(), lista[i].getAdj()[adyacente],peso);
					} catch (Exception e) {
						
						e.printStackTrace();
					}
				}
			}

			try {
				grafo.addVertex(lista[i].getId(), lista[i]);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
		}
		
		System.out.println("error");
	}

	public static double distance(double lat1, double lat2, double lon1,
			double lon2, double el1, double el2) {

		final int R = 6371; // Radius of the earth

		double latDistance = Math.toRadians(lat2 - lat1);
		double lonDistance = Math.toRadians(lon2 - lon1);
		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
				+ Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
				* Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c * 1000000; // convert to km

		double height = el1 - el2;

		distance = Math.pow(distance, 2) + Math.pow(height, 2);

		return Math.sqrt(distance);
		
	}


	// TODO El tipo de retorno de los m�todos puede ajustarse seg�n la conveniencia
	/**
	 * Requerimiento 1A: Encontrar el camino de costo m�nimo para un viaje entre dos ubicaciones geogr�ficas.
	 * @param idVertice2 
	 * @param idVertice1 
	 */
	public void caminoCostoMinimoA1(int idVertice1, int idVertice2) {
		// TODO Auto-generated method stub
	}

	// TODO El tipo de retorno de los m�todos puede ajustarse seg�n la conveniencia
	/**
	 * Requerimiento 2A: Determinar los n v�rtices con mayor n�mero de infracciones. Adicionalmente identificar las
	 * componentes conectadas (subgrafos) que se definan �nicamente entre estos n v�rtices
	 * @param  int n: numero de vertices con mayor numero de infracciones  
	 */
	public void mayorNumeroVerticesA2(int n) {
		// TODO Auto-generated method stub

	}

	// TODO El tipo de retorno de los m�todos puede ajustarse seg�n la conveniencia
	/**
	 * Requerimiento 1B: Encontrar el camino m�s corto para un viaje entre dos ubicaciones geogr�ficas 
	 * @param idVertice2 
	 * @param idVertice1 
	 */
	public void caminoLongitudMinimoaB1(int idVertice1, int idVertice2) {
		// TODO Auto-generated method stub

	}

	// TODO El tipo de retorno de los m�todos puede ajustarse seg�n la conveniencia
	/**
	 * Requerimiento 2B:  Definir una cuadricula regular de N columnas por M filas. que incluya las longitudes y latitudes dadas
	 * @param  lonMin: Longitud minima presente dentro de la cuadricula
	 * @param  lonMax: Longitud maxima presente dentro de la cuadricula
	 * @param  latMin: Latitud minima presente dentro de la cuadricula
	 * @param  latMax: Latitud maxima presente dentro de la cuadricula
	 * @param  columnas: Numero de columnas de la cuadricula
	 * @param  filas: Numero de filas de la cuadricula
	 */
	public void definirCuadriculaB2(double lonMin, double lonMax, double latMin, double latMax, int columnas,
			int filas) {
		// TODO Auto-generated method stub
	}

	// TODO El tipo de retorno de los m�todos puede ajustarse seg�n la conveniencia
	/**
	 * Requerimiento 1C:  Calcular un �rbol de expansi�n m�nima (MST) con criterio distancia, utilizando el algoritmo de Kruskal.
	 * @return 
	 */
	public Stack<Arco<K, V, A>> arbolMSTKruskalC1() {
		ColaPrioridadHeap<Arco<K, V, A>> cola = new ColaPrioridadHeap<>();
		Stack<Arco<K, V, A>> ret = new Stack<>();
		int marcados=1;
		while(marcados<grafo.darListaNodos().size()){
			Arco<K, V, A> min = cola.delMax();
			if(!(grafo.getVertex(min.darVerticeOrigen()).estaMarcado())&&!(grafo.getVertex(min.darVerticeDestino()).estaMarcado())){
				ret.push(min);
				grafo.getVertex(min.darVerticeDestino()).marcar();
				marcados++;
				grafo.getVertex(min.darVerticeOrigen()).marcar();
				marcados++;
			}
			else if((grafo.getVertex(min.darVerticeOrigen()).estaMarcado())&&!(grafo.getVertex(min.darVerticeDestino()).estaMarcado())){
				ret.push(min);
				grafo.getVertex(min.darVerticeDestino()).marcar();
				marcados++;
			}
			else if(!(grafo.getVertex(min.darVerticeOrigen()).estaMarcado())&&(grafo.getVertex(min.darVerticeDestino()).estaMarcado())){
				ret.push(min);
				grafo.getVertex(min.darVerticeOrigen()).marcar();
				marcados++;
			}
			else{continue;}
			
		}
		return ret;
	}

	
	/**
	 * Requerimiento 2C: Calcular un �rbol de expansi�n m�nima (MST) con criterio distancia, utilizando el algoritmo de Prim. (REQ 2C)
	 * @return 
	 */
	public Stack<Arco<K, V, A>> arbolMSTPrimC2() {
		Stack<Arco<K, V, A>> ret = new Stack<>();
		ColaPrioridadHeap<Arco<K, V, A>> cola = new ColaPrioridadHeap<>();
		Vertice<K, V> prim = grafo.darRaiz();
		LinkedList<Arco<K, V, A>> gra1 = grafo.darArcos(prim);
		NodoLinkedList<Arco<K, V, A>> arco = gra1.darPrimero();
		for(int i=0;i<gra1.getSize();i++){
			cola.insert(arco.darElemento());
			arco = arco.darSiguiente();
		}
		grafo.darRaiz().marcar();
		int marcados=1;
		while(marcados<grafo.darListaNodos().size()){
			Arco<K, V, A> min = cola.delMax();
			ret.push(min);
			double n = (double) min.darVerticeDestino();
			if(grafo.getVertex(n).estaMarcado()){
				continue;
			}
			else{
				LinkedList<Arco<K, V, A>> gra2 = grafo.darArcos(n);
				NodoLinkedList<Arco<K, V, A>> arco2 = gra2.darPrimero();
				for(int i=0;i<gra1.getSize();i++){
					cola.insert(arco.darElemento());
					arco = arco.darSiguiente();
				}
				marcados++;
				grafo.getVertex(n).marcar();
			}
			if(cola.size()<=0){
				break;
			}
		}
		System.out.println("si el tamano es 0 esta mal"+cola.size());
		return ret;
	}

	
	public void caminoCostoMinimoDijkstraC3() {
		// TODO Auto-generated method stub

	}

	// TODO El tipo de retorno de los m�todos puede ajustarse seg�n la conveniencia
	/**
	 * Requerimiento 4C:Encontrar el camino m�s corto para un viaje entre dos ubicaciones geogr�ficas escogidas aleatoriamente al interior del grafo.
	 * @param idVertice2 
	 * @param idVertice1 
	 */
	public void caminoMasCortoC4(int idVertice1, int idVertice2) {
		// TODO Auto-generated method stub

	}
	@SuppressWarnings("deprecation")
	public void loadMovingViolations(int numeroSemestre) {
		List<String[]> list = new ArrayList<String[]>();
		int uno=0,dos=0,tres=0,cuatro=0,s=0,ss=0;
		String u = "",d= "",t= "",c= "",i= "",e= ""; 
		//CSVReader reader =null;
		CSVReader reader2 =null;

		try{
			switch(numeroSemestre)
			{

			case 1:

				reader2 = new CSVReader(new FileReader("./data/January_wgs84_corregido.csv"),';');
				//reader=new CSVReaderBuilder(new FileReader("./data/January_wgs84.csv")).withSkipLines(1).build();
				list = reader2.readAll();
				readFiles(list);
				uno=list.size();
				u="Enero";
				list.clear();

				reader2 = new CSVReader(new FileReader("./data/February_wgs84.csv"),';');
				//reader=new CSVReaderBuilder(new FileReader("./data/February_wgs84.csv")).withSkipLines(';').build();
				list = reader2.readAll();
				readFiles(list);
				dos=list.size();
				d="Febrero";
				list.clear();

				reader2 = new CSVReader(new FileReader("./data/March_wgs84.csv"),';');
				//reader=new CSVReaderBuilder(new FileReader("./data/March_wgs84.csv")).withSkipLines(';').build();
				list = reader2.readAll();
				readFiles(list);
				tres=list.size();
				t="Marzo";
				list.clear();

				reader2 = new CSVReader(new FileReader("./data/Abril_wgs84.csv"),';');
				//reader=new CSVReaderBuilder(new FileReader("./data/Abril_wgs84.csv")).withSkipLines(';').build();
				list = reader2.readAll();
				readFiles(list);
				cuatro=list.size();
				c="Abril";
				list.clear();

				reader2 = new CSVReader(new FileReader("./data/May_wgs84.csv"),';');
				//reader=new CSVReaderBuilder(new FileReader("./data/May_wgs84.csv")).withSkipLines(';').build();
				list = reader2.readAll();
				readFiles(list);
				s=list.size();
				i="Mayo";
				list.clear();

				reader2 = new CSVReader(new FileReader("./data/June_wgs84.csv"),';');
				//reader=new CSVReaderBuilder(new FileReader("./data/June_wgs84.csv")).withSkipLines(';').build();
				list = reader2.readAll();
				readFiles(list);
				ss=list.size();
				e="Junio";
				list.clear();

				break;



			case 2:

				reader2 = new CSVReader(new FileReader("./data/July_wgs84.csv"),';');
				//reader=new CSVReaderBuilder(new FileReader("./data/July_wgs84.csv")).withSkipLines(1).build();
				list = reader2.readAll();
				readFiles(list);
				uno=list.size();
				u="Julio";
				list.clear();

				reader2 = new CSVReader(new FileReader("./data/August_wgs84.csv"),';');
				//reader=new CSVReaderBuilder(new FileReader("./data/August_wgs84.csv")).withSkipLines(1).build();
				list = reader2.readAll();
				readFiles(list);
				dos=list.size();
				d="Agosto";
				list.clear();

				reader2 = new CSVReader(new FileReader("./data/September_wgs84.csv"),';');
				//reader=new CSVReaderBuilder(new FileReader("./data/September_wgs84.csv")).withSkipLines(1).build();
				list = reader2.readAll();
				readFiles(list);
				tres=list.size();
				t="Septiembre";
				list.clear();

				reader2 = new CSVReader(new FileReader("./data/October_wgs84.csv"),';');
				//reader=new CSVReaderBuilder(new FileReader("./data/October_wgs84.csv")).withSkipLines(1).build();
				list = reader2.readAll();
				readFiles(list);
				cuatro=list.size();
				c="Octubre";
				list.clear();

				reader2 = new CSVReader(new FileReader("./data/November_wgs84.csv"),';');
				//reader=new CSVReaderBuilder(new FileReader("./data/November_wgs84.csv")).withSkipLines(1).build();
				list = reader2.readAll();
				readFiles(list);
				s=list.size();
				i="Noviembre";
				list.clear();

				reader2 = new CSVReader(new FileReader("./data/December_wgs84.csv"),';');
				//reader=new CSVReaderBuilder(new FileReader("./data/December_wgs84.csv")).withSkipLines(1).build();
				list = reader2.readAll();
				readFiles(list);
				ss=list.size();
				e="Deciembre";
				list.clear();

				break;

			}
		}catch( Exception ee){

			ee.printStackTrace();

		}

		String[] infraccionesPorMes = {
				uno+" datos cargados en "+u+"."
				,dos+" datos cargados en "+d+"."
				,tres+" datos cargados en "+t+"."
				,cuatro+" datos cargados en "+c+"."
				,s+ " datos cargados en "+i+"."
				,ss+" datos cargados en "+e+"."};

		for(int j = 0; j<infraccionesPorMes.length;j++){
			System.out.println(infraccionesPorMes[j]);
		}



	}

	public void readFiles(List<String[]> list){

		for(int i = 0;i<list.size()/10;i++){

			VOMovingViolation infraccion = new VOMovingViolation(


					list.get(i)[1], //ID
					list.get(i)[3], //Loc
					list.get(i)[15], //Date
					list.get(i)[10], //TPaid
					list.get(i)[13], //Indicator
					list.get(i)[17], //desc
					list.get(i)[16], //VCOde
					list.get(i)[9], //fineatm
					list.get(i)[11], //penalty1
					list.get(i)[12], //penalty2
					list.get(i)[4], //address
					list.get(i)[5]); //Stre


			cola.enqueue(infraccion);


		}

	}

}