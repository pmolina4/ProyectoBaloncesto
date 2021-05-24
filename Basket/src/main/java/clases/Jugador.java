/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

import enumeration.mano;
import enumeration.tipo;

/**
 *
 * @author pablo
 */
public class Jugador extends CosaConNombre {
	private int iter = 0;
	private String posicion;
	private String manoDominante;
	private byte fuerza;
	private Contrato contrato;
	private byte velocidad;
	private byte inteligencia;
	private byte tecnica;
	private byte numero;

	
	
	public Jugador(String nombre) {
		super(nombre);
	}

	public Jugador(String posicion, String manoDominante, byte fuerza, byte velocidad, byte inteligencia, byte tecnica,
			String nombre, byte numero) {
		super(nombre);
		this.posicion = posicion;
		this.manoDominante = manoDominante;
		this.fuerza = fuerza;
		this.velocidad = velocidad;
		this.inteligencia = inteligencia;
		this.tecnica = tecnica;
		this.numero = numero;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getManoDominante() {
		return manoDominante;
	}

	public void setManoDominante(String manoDominante) {
		this.manoDominante = manoDominante;
	}

	public byte getFuerza() {
		return fuerza;
	}

	public void setFuerza(byte fuerza) {
		this.fuerza = fuerza;
	}

	public byte getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(byte velocidad) {
		this.velocidad = velocidad;
	}

	public byte getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(byte inteligencia) {
		this.inteligencia = inteligencia;
	}

	public byte getTecnica() {
		return tecnica;
	}

	public void setTecnica(byte tecnica) {
		this.tecnica = tecnica;
	}

	public byte getNumero() {
		return numero;
	}

	public void setNumero(byte numero) {
		this.numero = numero;
	}

	
	@Override
	public String toString() {
		return "Nombre"+super.getNombre()+"Jugador [iter=" + iter + ", posicion=" + posicion + ", manoDominante=" + manoDominante + ", fuerza="
				+ fuerza + ", contrato=" + contrato + ", velocidad=" + velocidad + ", inteligencia=" + inteligencia
				+ ", tecnica=" + tecnica + ", numero=" + numero + "]";
	}

	public final Jugador generRandomPlayer() {
		String[] nombres = { "Juan Cortes", "José Curry", "Miguel Flores", "Antonio Torres", "Johan Parra",
				"Pelé Povea", "Salvador Molina", "Fernando Gonzalez", "Ander Heredia", "Oscar Vargas", "John Salazar",
				"Steve Campos", "Makelele William", "Marcos William", "Davies Johnson", "Cristiano Smith",
				"Pablo Miller", "Eduardo Wilson", "Alvaro Lopez", "Stephen Lewis", "Manolo King", "Eugenio Adams",
				"Mario Baker", "Jose Manuel Green", "Benito Kimpembe", "Rashford Robert", "Rashe Simonl",
				"Marcus Dembele", "Lebron Martin", "Pau Duran" };

		byte nombreRan = (byte) Math.floor(Math.random() * (nombres.length));
		byte apellidoRan = (byte) Math.floor(Math.random() * (nombres.length));
		byte fuerzaRan = (byte) Math.floor(Math.random() * (100 - 1 + 1) + 1);
		byte velocidadRan = (byte) Math.floor(Math.random() * (100 - 1 + 1) + 1);
		byte inteligenciaRan = (byte) Math.floor(Math.random() * (100 - 1 + 1) + 1);
		byte tecnicaRan = (byte) Math.floor(Math.random() * (100 - 1 + 1) + 1);
		byte numeroRan = (byte) Math.floor(Math.random() * (20 - 1 + 1) + 1);
		byte enumRan = (byte) Math.floor(Math.random() * (2 - 0 + 0) + 0);
		String posicion = "";
		String mano = "";
		if (enumRan == 0) {
			mano = "Zurdo";
		} else if (enumRan == 1) {
			mano = "Diestro";
		} else if (enumRan == 2) {
			mano = "Ambidiestro";
		}
		if (iter == 5)
			iter = 0;
		if (iter == 0) {
			posicion = "Alapivot";
		} else if (iter == 1) {
			posicion = "Alero";
		} else if (iter == 2) {
			posicion = "Base";
		} else if (iter == 3) {
			posicion = "Escolta";
		} else if (iter == 4) {
			posicion = "Pivot";
		}
		iter++;

		Jugador j = new Jugador(posicion, mano, fuerzaRan, velocidadRan, inteligenciaRan, tecnicaRan,
				nombres[nombreRan], numeroRan);
		return j;
	}



}
