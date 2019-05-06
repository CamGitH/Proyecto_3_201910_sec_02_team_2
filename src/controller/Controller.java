package controller;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import model.estructuras.Queue;
import model.violations.VOMovingViolation;
import view.View;

public class Controller {
	
	Queue<VOMovingViolation> cola;
	
	View view;
	
	public Controller() {
		cola = new Queue<VOMovingViolation>();
		view = new View();
	}
	
	
	public void run(){

		Scanner sc = new Scanner(System.in);
		boolean fin = false;

		while(!fin){
			view.printMenu();

			int option = sc.nextInt();

			switch(option){

			case 0:
				view.printMessage("Ingrese semestre a cargar (1 o 2)");
				int semestre = sc.nextInt();
				
				this.loadMovingViolations(semestre);
				break;
				
			case 1:	
				fin = true;
				sc.close();
				break;
			}


			}
		}



	public void loadMovingViolations(int numeroSemestre) {
		List<String[]> list = new ArrayList<String[]>();
		int uno=0,dos=0,tres=0,cuatro=0,s=0,ss=0;
		String u = "",d= "",t= "",c= "",i= "",e= ""; 
		CSVReader reader =null;
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
				u="January";
				list.clear();

				reader2 = new CSVReader(new FileReader("./data/February_wgs84.csv"),';');
				//reader=new CSVReaderBuilder(new FileReader("./data/February_wgs84.csv")).withSkipLines(';').build();
				list = reader2.readAll();
				readFiles(list);
				dos=list.size();
				d="February";
				list.clear();

				reader2 = new CSVReader(new FileReader("./data/March_wgs84.csv"),';');
				//reader=new CSVReaderBuilder(new FileReader("./data/March_wgs84.csv")).withSkipLines(';').build();
				list = reader2.readAll();
				readFiles(list);
				tres=list.size();
				t="March";
				list.clear();

				reader2 = new CSVReader(new FileReader("./data/Abril_wgs84.csv"),';');
				//reader=new CSVReaderBuilder(new FileReader("./data/Abril_wgs84.csv")).withSkipLines(';').build();
				list = reader2.readAll();
				readFiles(list);
				cuatro=list.size();
				c="April";
				list.clear();

				reader2 = new CSVReader(new FileReader("./data/May_wgs84.csv"),';');
				//reader=new CSVReaderBuilder(new FileReader("./data/May_wgs84.csv")).withSkipLines(';').build();
				list = reader2.readAll();
				readFiles(list);
				s=list.size();
				i="May";
				list.clear();

				reader2 = new CSVReader(new FileReader("./data/June_wgs84.csv"),';');
				//reader=new CSVReaderBuilder(new FileReader("./data/June_wgs84.csv")).withSkipLines(';').build();
				list = reader2.readAll();
				readFiles(list);
				ss=list.size();
				e="June";
				list.clear();
				
				break;



			case 2:

				reader2 = new CSVReader(new FileReader("./data/July_wgs84.csv"),';');
				//reader=new CSVReaderBuilder(new FileReader("./data/July_wgs84.csv")).withSkipLines(1).build();
				list = reader2.readAll();
				readFiles(list);
				uno=list.size();
				u="July";
				list.clear();

				reader2 = new CSVReader(new FileReader("./data/August_wgs84.csv"),';');
				//reader=new CSVReaderBuilder(new FileReader("./data/August_wgs84.csv")).withSkipLines(1).build();
				list = reader2.readAll();
				readFiles(list);
				dos=list.size();
				d="Agust";
				list.clear();

				reader2 = new CSVReader(new FileReader("./data/September_wgs84.csv"),';');
				//reader=new CSVReaderBuilder(new FileReader("./data/September_wgs84.csv")).withSkipLines(1).build();
				list = reader2.readAll();
				readFiles(list);
				tres=list.size();
				t="September";
				list.clear();

				reader2 = new CSVReader(new FileReader("./data/October_wgs84.csv"),';');
				//reader=new CSVReaderBuilder(new FileReader("./data/October_wgs84.csv")).withSkipLines(1).build();
				list = reader2.readAll();
				readFiles(list);
				cuatro=list.size();
				c="October";
				list.clear();

				reader2 = new CSVReader(new FileReader("./data/November_wgs84.csv"),';');
				//reader=new CSVReaderBuilder(new FileReader("./data/November_wgs84.csv")).withSkipLines(1).build();
				list = reader2.readAll();
				readFiles(list);
				s=list.size();
				i="November";
				list.clear();
				
				reader2 = new CSVReader(new FileReader("./data/December_wgs84.csv"),';');
				//reader=new CSVReaderBuilder(new FileReader("./data/December_wgs84.csv")).withSkipLines(1).build();
				list = reader2.readAll();
				readFiles(list);
				ss=list.size();
				e="December";
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
					
					
					list.get(i)[1],
					list.get(i)[3],
					list.get(i)[15],
					list.get(i)[10],
					list.get(i)[13],
					list.get(i)[17],
					list.get(i)[5],
					list.get(i)[4],
					list.get(i)[6],
					list.get(i)[7],
					list.get(i)[15],
					list.get(i)[17],
					list.get(i)[18]);  


			cola.enqueue(infraccion);
			

		}

	}
	
}
