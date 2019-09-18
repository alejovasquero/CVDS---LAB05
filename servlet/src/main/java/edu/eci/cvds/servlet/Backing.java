package edu.eci.cvds.servlet;

import java.util.Random;
import java.util.ArrayList;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(name = "guessBean")
@SessionScoped
public class Backing {
	private int numeroA;
	private int intentos=0;
	private int puntos=0;
	private String estado="No gano";
	private ArrayList<Integer> fallos=new ArrayList<>();
	{
		Random a = new Random();
		numeroA = a.nextInt(21);
	}
	
	public void guess(int intento) {
		estado="No gano";
		if(intento >= 0 && intento<=20 && !fallos.contains(intento)){
			if(intento==numeroA) {
				puntos=100000-(intentos*10000);
				if(puntos<0) {puntos=0;}
				estado="Gano con"+puntos;
			}
			else{
				fallos.add(intento);
			}
			intentos++;
		}
	}
	
	public void restart() {
		Random a = new Random();
		numeroA = a.nextInt(21);
		puntos=0;
		estado = "No gano";
		intentos=0;
		fallos=new ArrayList<>();
	}
	
	
	public int getNumeroA(){
		return numeroA;
	}
	
	public int getIntentos(){
		return intentos;
	}
	
	public int getpuntos(){
		return puntos;
	}
	
	public String getEstado(){
		return estado;
	}
	
	public ArrayList<Integer> getFallos(){
		return fallos;
	}
	
	public void setNumeroA(int a) {
		numeroA=a;
	}
	
}
