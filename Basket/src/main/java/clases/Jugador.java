/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

import enumeration.mano;
import enumeration.tipo;

/**
 * 
 * @version 1.0
 * @author pablo
 * Clase Jugador extiende de CosaConNombre
 */
public class Jugador extends CosaConNombre {

	private String posicion;
	private String manoDominante;
	private byte fuerza;
	private byte velocidad;
	private byte inteligencia;
	private byte tecnica;
	private byte numero;
	private byte mediaAtaque;
	private byte mediaDefensa;
	private String equipo;

	public Jugador(String nombre) {
		super(nombre);
	}
	/**
	 * constructor de la clase jugador
	 * @param nombre de el jugador
	 * @param equipo de el jugador
	 * @param posicion de el jugador
	 * @param manoDominante de el jugador
	 * @param fuerza de el jugador
	 * @param velocidad de el jugador
	 * @param inteligencia de el jugador
	 * @param tecnica de el jugador
	 * @param numero de el jugador
	 * @param mediaAtaque de el jugador
	 * @param mediaDefensa de el jugador
	 */
	public Jugador(String nombre, String equipo, String posicion, String manoDominante, byte fuerza, byte velocidad,
			byte inteligencia, byte tecnica, byte numero, byte mediaAtaque, byte mediaDefensa) {
		super(nombre);
		this.equipo = equipo;
		this.posicion = posicion;
		this.manoDominante = manoDominante;
		this.fuerza = fuerza;
		this.velocidad = velocidad;
		this.inteligencia = inteligencia;
		this.tecnica = tecnica;
		this.numero = numero;
		this.mediaAtaque = mediaAtaque;
		this.mediaDefensa = mediaDefensa;
	}
	/**
	 * recoge el equipo de el jugador
	 * @return equipo
	 */
	public String getEquipo() {
		return equipo;
	}
	/**
	 * asigan el equipo al jugador
	 * @param equipo de el jugador
	 */
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	/**
	 * recoge la posicion de el jugador
	 * @return posicion
	 */
	public String getPosicion() {
		return posicion;
	}
	/**
	 * asigna la posicion de el jugador
	 * @param posicion de el jugador
	 */
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	/**
	 * recoge la mano dominante de el jugador
	 * @return manoDominante
	 */
	public String getManoDominante() {
		return manoDominante;
	}
	/**
	 * asigna la mano dominante a el jugador
	 * @param manoDominante de el jugador
	 */
	public void setManoDominante(String manoDominante) {
		this.manoDominante = manoDominante;
	}
	/**
	 * coge la fuerza de el jugador
	 * @return fuerza 
	 */
	public byte getFuerza() {
		return fuerza;
	}
	/**
	 * asigna la fuerza a el jugador
	 * @param fuerza de el jugador
	 */
	public void setFuerza(byte fuerza) {
		this.fuerza = fuerza;
	}
	/**
	 * recoge la velocidad de el jugador
	 * @return velocidad 
	 */
	public byte getVelocidad() {
		return velocidad;
	}
	/**
	 * asigna la velocidad a el jugador
	 * @param velocidad de el jugador
	 */
	public void setVelocidad(byte velocidad) {
		this.velocidad = velocidad;
	}
	/**
	 * recoge la inteligencia de el jugador
	 * @return inteligencia
	 */
	public byte getInteligencia() {
		return inteligencia;
	}
	/**
	 * asigna la inteligencia a el jugador
	 * @param inteligencia de el jugador
	 */
	public void setInteligencia(byte inteligencia) {
		this.inteligencia = inteligencia;
	}
	/**
	 * recoge la tecnica de el jugador
	 * @return tenica
	 */
	public byte getTecnica() {
		return tecnica;
	}	
	/**
	 * asigna la tecnica de el ejugador
	 * @param tecnica de el jugador
	 */
	public void setTecnica(byte tecnica) {
		this.tecnica = tecnica;
	}
	/**
	 * recoge el numero de el jugador
	 * @return numero
	 */
	public byte getNumero() {
		return numero;
	}
	/**
	 * asigna el numero a el jugador
	 * @param numero de el jugador
	 */
	public void setNumero(byte numero) {
		this.numero = numero;
	}

	// FUNCION SIN USABILIDAD
//	public Jugador() {	
//		super();
//		String[] nombres = { "Juan Cortes", "José Curry", "Miguel Flores", "Antonio Torres", "Johan Parra",
//				"Pelé Povea", "Salvador Molina", "Fernando Gonzalez", "Ander Heredia", "Oscar Vargas", "John Salazar",
//				"Steve Campos", "Makelele William", "Marcos William", "Davies Johnson", "Cristiano Smith",
//				"Pablo Miller", "Eduardo Wilson", "Alvaro Lopez", "Stephen Lewis", "Manolo King", "Eugenio Adams",
//				"Mario Baker", "Jose Manuel Green", "Benito Kimpembe", "Rashford Robert", "Rashe Simonl",
//				"Marcus Dembele", "Lebron Martin", "Pau Duran", "Jaime Terron", "Paco sales", "Antonio Miranda",
//				"Vicente Salas", "Manolo Donaire", "Andres ojeda", "Pepe serrano", "David farried", "Sergio Conde",
//				"Jhon Cortes", "Felipe Reyes", "Sergio Llul", "Pau cortes", "Juampi Maroto", "Javier reyes",
//				"Pepe Varo", "Benji Amstrom", "Alejandro alvarez", "Fran cuesta", "Enrrique ferrer", "Alex gordo",
//				"Manolo cortes", "Joselito Perez", "Pepe Conde", "Miguel Lopez", "Fernando Molina" };
//
//		int iter = 0;
//		Random rnd = new Random();
//		this.setNombre(nombres[(byte) Math.floor(Math.random() * (nombres.length))]);
//		this.setFuerza((byte) (Math.random() * (65 - 100 + 1) + 100));
//		this.setVelocidad((byte) (Math.random() * (65 - 100 + 1) + 100));
//		this.setInteligencia((byte) (Math.random() * (65 - 100 + 1) + 100));
//		this.setTecnica((byte) (Math.random() * (65 - 100 + 1) + 100));
//		this.setNumero((byte) (Math.random() * (1 - 20 + 1) + 20));
//		byte enumRan = (byte) Math.floor(Math.random() * (2 - 0 + 0) + 0);
//
//		if (enumRan == 0) {
//			this.setManoDominante("Zurdo");
//		} else if (enumRan == 1) {
//			this.setManoDominante("Diestro");
//		} else if (enumRan == 2) {
//			this.setManoDominante("Ambidiestro");
//		}
//		if (iter == 5)
//			iter = 0;
//		if (iter == 0) {
//			posicion = "Alapivot";
//		} else if (iter == 1) {
//			posicion = "Alero";
//		} else if (iter == 2) {
//			posicion = "Base";
//		} else if (iter == 3) {
//			posicion = "Escolta";
//		} else if (iter == 4) {
//			posicion = "Pivot";
//		}
//		iter++;
//	}

	/**
	 * asignamos la media de ataque que depoende de la velocidad y la fuerza
	 * Seteamos mediaAtaque  
	 */
	public void setMediaAtaque() {
		this.mediaAtaque = (byte) ((this.getFuerza() + this.getVelocidad()) / 2);
	}

	/**
	 * asignamos la mediaDefensa que depende de la inteligencia y la técnica
	 *  Seteamos mediaDefensa
	 */
	public void setMediaDefensa() {
		this.mediaDefensa = (byte) (this.getInteligencia() + this.getTecnica() / 2);
	}
	/**
	 * recogemos la media de ataque
	 * @return mediaAtaque
	 */
	public byte getMediaAtaque() {
		return mediaAtaque;
	}
	/**
	 * recogemos la media defensa
	 * @return MediaDefensa
	 */
	public byte getMediaDefensa() {
		return mediaDefensa;
	}


}
