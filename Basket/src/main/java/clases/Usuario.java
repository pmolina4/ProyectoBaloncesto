package clases;

import Exceptions.EmptyNameException;
import Exceptions.RegExContraseñaException;

public class Usuario {
	private String nombre;
	private String apellidos;
	private String nickname;
	private String email;
	private String contraseña;

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

	public void setContraseña(String contraseña) throws RegExContraseñaException {
		String pattern = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$";
		if (contraseña.matches(pattern)) {
			this.contraseña = contraseña;
		} else {
			throw new RegExContraseñaException(
					"<html> La contraseña debe cumplir los siguientes caracteristicas: <br> </br> Entre 8 y 16 Carácteres <br> Una letra minúscula <br> Una letra mayúscula <br> Un digito");

		}
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", nickname=" + nickname + ", email=" + email
				+ ", Contraseña=" + contraseña + "]";
	}

	// Constructor vacio para usar como Instancia General
	public Usuario() {

	}

}
