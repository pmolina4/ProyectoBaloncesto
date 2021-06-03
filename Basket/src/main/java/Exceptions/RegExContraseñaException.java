package Exceptions;

/*
 * Excepcion RegExContraseñaException hereda de Exception - Usada unicamente para comprobar qe la contraseña cumpla ciertos parámetros comentados en setContraseña() -> usuario.class()
 */
public class RegExContraseñaException extends Exception {
	public RegExContraseñaException(String msg) {
		super(msg);
	}
}
