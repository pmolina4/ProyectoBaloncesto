package clases;

import Exceptions.EmptyNameException;
import Exceptions.RegExContraseñaException;

/*
 * Clase Usuario 
 * Unicamente usada en Login y Registro
 */
public class Usuario {
	private String nombre;
	private String apellidos;
	private String nickname;
	private String email;
	private String contraseña;

	// Constructor + Getters + Setters
	public Usuario(String nombre, String apellidos, String nickname, String email, String contraseña) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nickname = nickname;
		this.email = email;
		this.contraseña = contraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) throws EmptyNameException {
		if (nickname.isEmpty()) {
			throw new EmptyNameException("El Nickname no debe estar vacio, por favor, rellénalo!");
		} else {
			this.nickname = nickname;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	/*
	 * setContraseña throws RegExContraseñaException - Comprueba que la contraseña
	 * cumpla las características de la Expresion Regular
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

	// Constructor vacio para usar como Instancia General
	public Usuario() {

	}

}
