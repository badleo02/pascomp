/**
 * Paquete que recoge todas las clases pertenecientes a la tabla de s�mbolos.
 */
package tablaSimbolos.tipos;

import utils.TTipo;

/**
 * Clase que implementa la informaci�n referente a los tipos. 
 */
public class EntradaTS {
	
	/**
	 * Nombre del tipo.
	 * Puede ser 
	 * ENT: Entero.
	 * LOG: L�gico.
	 * PUNTERO: Puntero
	 * REGISTRO: Registro
	 * PROC: Procedimiento
	 */
	private TTipo nombreTipo;
	
	/**
	 * Tama�o que ocupa el Nodo con la informaci�n.
	 */
	private int tamanno;

	/**
	 * Constructora con par�metros
	 * @param nombreTipo Nombre del tipo.
	 * @param tamanno Tama�o del tipo.
	 */
	public EntradaTS(TTipo nombreTipo, int tamanno){
		this.nombreTipo = nombreTipo;	
		this.tamanno = tamanno;
	}

	/**
	 * Acesor para el atributo nombreTipo.
	 * @return El nombre del tipo.
	 */
	public TTipo getNombreTipo() {
		return nombreTipo;
	}

	/**
	 * Mutador para el atributo nombreTipo.
	 * @param nombreTipo Nombre del tipo.
	 */
	public void setNombreTipo(TTipo nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

	/**
	 * Accesor para el atributo tamanno.
	 * @return El tama�o del tipo.
	 */
	public int getTamanno() {
		return tamanno;
	}

	/**
	 * Mutador para el atributo tamanno.
	 * @param tamanno Tama�o del tipo.
	 */
	public void setTamanno(int tamanno) {
		this.tamanno = tamanno;
	}
	
	/**
	 * M�todo que devuelve el nombre del tipo en forma de String.
	 * @return Nombre del tipo.
	 */
	public String toString(){
		return nombreTipo.toString();
	}
	
}
