package clases;

import Exceptions.EmptyNameException;
import Exceptions.RegExContraseñaException;

/**
 * 
 * @version 1.0
 * @author pablo
 * Clase Usuario 
 * Unicamente usada en Login y Registro
 */
public class Usuario {
	private String nombre;
	private String apellidos;
	private String nickname;
	private String email;
	private String contraseña;

	/**
	 * CONSTRUCTOR DE LA  clase usuario
	 * @param nombre de el usuario
	 * @param apellidos de el usuario
	 * @param nickname de el usuario
	 * @param email de el usuario
	 * @param contraseña de el usuario
	 */
	public Usuario(String nombre, String apellidos, String nickname, String email, String contraseña) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nickname = nickname;
		this.email = email;
		this.contraseña = contraseña;
	}
	/**
	 * recoge el nombre de el Usuario
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * asigna el nombre a el usuario
	 * @param nombre de el usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * recoge el apellido de el usuario
	 * @return apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * asigna los apellidos a el usuario
	 * @param apellidos de el usuario
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * recoge el nick de el usuario
	 * @return nickname de el usuario
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * asignamos el nick a el usuario
	 * nos aseguramos que el nick no pueda estar vacío si lo está lanzamos una excepcion
	 * @param nickname de el usuario
	 * @throws EmptyNameException de el usuario
	 */
	public void setNickname(String nickname) throws EmptyNameException {
		if (nickname.isEmpty()) {
			throw new EmptyNameException("El Nickname no debe estar vacio, por favor, rellénalo!");
		} else {
			this.nickname = nickname;
		}
	}
	/**
	 * recoge el email de el usuario
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * asigna el email a el usuario
	 * @param email de el usuario
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * recoge la contraseña de el susuario
	 * @return contraseña 
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 * setContraseña throws RegExContraseñaException - Comprueba que la contraseña
	 * cumpla las características de la Expresion Regular
	 * @param contraseña de el usuario
	 * @throws RegExContraseñaException excepcion propia 
	 */
	public void setContraseña(String contraseña) throws RegExContraseñaException {
		// Mayuscula, minuscula, y de 8-16 caracteres
		String pattern = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$";
		if (contraseña.matches(pattern)) {
			this.contraseña = contraseña;
		} else {
			// Lanzamiento de Excepcion Propia
			throw new RegExContraseñaException(
					"<html> La contraseña debe cumplir los siguientes caracteristicas: <br> </br> Entre 8 y 16 Carácteres <br> Una letra minúscula <br> Una letra mayúscula <br> Un digito");
		}
	}

	/**
	 *  Constructor vacio para usar como Instancia General
	 */
	public Usuario() {

	}

}
