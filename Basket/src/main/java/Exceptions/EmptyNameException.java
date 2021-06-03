package Exceptions;

/*
 * Excepcion EmptyNameException hereda de Exception - Utilizada unicamente para comprobar que el nombre no este vacio a la hora de registrarte
 */
public class EmptyNameException extends Exception {
	public EmptyNameException(String msg) {
		super(msg);
	}
}
