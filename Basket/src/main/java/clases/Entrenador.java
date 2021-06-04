package clases;

import java.util.ArrayList;
import java.util.Random;

import Exceptions.EmptyNameException;
import interfaces.Ventana;

/**
 * @author pablo
 * @version 1.0
 * Clase Entrenador extiende de CosaConNombre
 */
public class Entrenador extends CosaConNombre {
	private String nacionalidad;
	private byte calidad;
	private String equipo;

	/**
	 * to string de la calse Entrenador
	 */
	@Override
	public String toString() {
		return "Entrenador [nacionalidad=" + nacionalidad + ", calidad=" + calidad + ", equipo=" + equipo + "]";
	}

	/**
	 * constructor de la clase entrenador 
	 * @param nombre de el entrenador
	 * @param nacionalidad de el entrenador
	 * @param calidad de ele entrenador
	 * @param equipo de el entrenador
	 */
	public Entrenador(String nombre, String nacionalidad, byte calidad, String equipo) {
		super(nombre);
		this.nacionalidad = nacionalidad;
		this.calidad = calidad;
		this.equipo = equipo;
	}

	/**
	 * get de la nacionalidad de el entrenador
	 * @return nacinalidad de el entrenador
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}
	/**
	 * asgina la nacionalidad de el entrenador
	 * @param nacionalidad de el entrenador
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	/**
	 * recoge la calidad de el entrendor
	 * @return dela calidad de el entrenador
	 */
	public byte getCalidad() {
		return calidad;
	}
	/**
	 * asigna la calidad a el entrendor
	 * @param calidad de el entrenador
	 */
	public void setCalidad(byte calidad) {
		this.calidad = calidad;
	}
	/**
	 * recoge el equipo de el entrenador
	 * @return equipo de el entrenador
	 */
	public String getEquipo() {
		return equipo;
	}
	/**
	 * asigna el equipo de el entrenador
	 * @param equipo de el entrenador
	 */
	public void setEquipo(String equipo){
		this.equipo = equipo;
	}

	/**
	 * Funcion que genera nombre y nacionalidad de entrenadores de manera aleatoria,
	 * implementándolos en un ArrayList<Entrenadores>
	 */
	public void generarEntrenadores() {
		String[] nombre = { "Perico Conde", "Yuseppe Pedrerol", "Julio Iglesias", "El Bicho", "Mariano Rajoy",
				"Echenique aka RayoMcQueen", "Pablo Iglesias", "Fernando Cinta de Lomo", "Edu Chope", "Perri lol" };
		String[] nacionalidades = { "Español", "Africano", "Americano", "Aleman", "Frances", "Ruso", "Belga",
				"Brasileño", "Neocelandes", "Noruego" };

		for (int i = 0; i < Ventana.equipos.size(); i++) {
			Entrenador a = new Entrenador(nombre[i], nacionalidades[i], (byte) Math.floor(Math.random() * 100 + 1),
					Ventana.equipos.get(i));
			Ventana.Entrenadores.add(a);
		}

	}

	/**
	 *  Constructor sin Parametros para crear instancia general
	 */
	public Entrenador() {

	}

}
