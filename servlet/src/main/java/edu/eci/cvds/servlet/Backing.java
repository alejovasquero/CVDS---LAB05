package edu.eci.cvds.servlet;

import java.util.Random;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "guessBean")
@ApplicationScoped
public class Backing {
	private int numeroA;
	private int intentos;
	private int puntos;
	private String estado;
	
	public void guess(int intento) {
		estado="No gano";
		if(intento==numeroA) {
			puntos=100000-(intentos*10000);
			estado="Gano con"+puntos;
			if(puntos<0) {puntos=0;}
		}
		intentos++;
	}
	
	public void restart() {
		Random a = new Random();
		numeroA = a.nextInt(21);
		puntos=0;
		estado = "No gano";
		intentos=0;
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
	
	public void setNumeroA(int a) {
		numeroA=a;
	}
	
}
