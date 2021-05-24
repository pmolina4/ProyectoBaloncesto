/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author pablo
 */
public class Entrenador extends CosaConNombre {
	private String nacionalidad;
	private Competicion titulosGanados;
	private byte calidad;
	private String equipo;

	public Entrenador(String nacionalidad, Competicion titulosGanados, byte calidad, String equipo, String nombre) {
		super(nombre);
		this.nacionalidad = nacionalidad;
		this.titulosGanados = titulosGanados;
		this.calidad = calidad;
		this.equipo = equipo;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Competicion getTitulosGanados() {
		return titulosGanados;
	}

	public void setTitulosGanados(Competicion titulosGanados) {
		this.titulosGanados = titulosGanados;
	}

	public byte getCalidad() {
		return calidad;
	}

	public void setCalidad(byte calidad) {
		this.calidad = calidad;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "Entrenador{" + "nacionalidad=" + nacionalidad + ", titulosGanados=" + titulosGanados + ", calidad="
				+ calidad + ", equipo=" + equipo + '}';
	}

}
