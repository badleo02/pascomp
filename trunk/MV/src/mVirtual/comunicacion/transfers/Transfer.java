package mVirtual.comunicacion.transfers;

import java.util.Vector;

/**
 * Comportamiento que presentan los transfers de nuestro sistema
 * 
 *
 */
public interface Transfer {

	/**
	 * Devuelve el texto del transfer
	 * @return Texto del transfer
	 */
	public abstract Vector<String> getTexto();
	/**
	 * Devuelve el booleano que indica si hay que ejecutar en modo traza
	 * @return Booleano que indica el modo traza
	 */
	public abstract boolean getTraza();
	/**
	 * Devuelve el booleano que indica si se ejecuta una sola instrucci�n
	 * @return Booleano que indica si se ejecuta una sola instrucci�n
	 */
	public abstract boolean getSoloInstruccion();
	/**
	 * Devuelve el booleano que indica si hay que setear la ruta
	 * @return Booleano que indica el estado de ruta
	 */
	public abstract boolean getRuta();
	/**
	 * Devuelve el booleano que indica el estado de comunicaci�n interna
	 * @return booleano que indica el estado de comunicaci�n interna
	 */
	public abstract boolean getComunicacionInterna();
	/**
	 * Setea el texto con un string y una l�nea por par�metro
	 * @param texto Texto a setear
	 * @param linea L�nea donde se setea
	 */
	public abstract void setTexto(String texto, int linea);
	/**
	 * Activa el modo traza
	 * @param modoTraza Booleano que indica si se activa el modo traza
	 */
	public abstract void setModoTraza(boolean modoTraza);
	/**
	 * Modo ejecuta una sola instrucci�n
	 * @param instruccion Booleano que indica si se activa una sola instrucci�n
	 */
	public abstract void setSoloInstruccion(boolean instruccion);
	/**
	 * Setea la ruta del programa
	 * @param ruta Booleano para setear la ruta del programa
	 */
	public abstract void setRuta(boolean ruta);
	/**
	 * Setea la comunicaci�n interna del programa
	 * @param comunicacion Booleano que indica si hay que setear la comunciaci�n interna del programa
	 */
	public abstract void setComunicacionInterna(boolean comunicacion);
}