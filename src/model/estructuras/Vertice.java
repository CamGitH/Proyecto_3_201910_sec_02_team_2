package model.estructuras;

import model.violations.GraphInfo;

public class Vertice<K, V> {

	private K id;
	private GraphInfo infoVertice;
	boolean marcado;
	int numeroArcos =0;
	
	
	
	
	public void Vertice( K pId , GraphInfo pInfoVertice)
	{
	id = pId;
	numeroArcos=0;
	infoVertice = pInfoVertice;
//	info2 = pinfo2;
	marcado = false;
	}
	
	public K darID(){
		return id;
	}
	
	public GraphInfo darInfo(){
		return infoVertice;
	}
	
//	public V darInfo2(){
//		return info2;
//	}
	
	public void cambiarInfo(GraphInfo pInf){
		infoVertice = pInf;
	}
	
//	public void cambiarInfo2(V pInf){
//		info2 = pInf;
//	}
	
	public void setId(K pId){
		id = pId;
	}
	
	public int darNumeroArcos(){
		return numeroArcos;
	}
	
	public boolean estaMarcado(){
		return marcado;
	}
	
	public void marcar(){
		marcado=true;
	}
	
	public void desMarcar(){
		marcado=false;
	}
}
