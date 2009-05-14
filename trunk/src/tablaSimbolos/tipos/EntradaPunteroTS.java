/**
 * Paquete que engloba todas las clases referentes a la tabla de s�mbolos
 */
package tablaSimbolos.tipos;

import utils.*;

/**
 * Clase que implementa el nodo de tipo puntero. 
 */
public class EntradaPunteroTS extends EntradaTS {
	
	/**
	 * Informaci�n asocidada al nodo.
	 */
	private EntradaTS tipo;
	
	/**
	 * Constructora de la clase con par�metros.
	 * @param nombreTipo Nombre del tipo referenciado.
	 * @param tamanno Tama�o que ocupa.
	 * @param tipo Informaci�n asociada al nodo.
	 */
	public EntradaPunteroTS(TTipo nombreTipo, int tamanno, EntradaTS tipo) {
		super(nombreTipo, tamanno);
		this.tipo = tipo;
	}
	
	/**
	 * Accesor para el atributo tipo.
	 * @return Informaci�n asocidada al nodo.
	 */
	public EntradaTS getTipo() {
		return tipo;
	}

	/**
	 * Mutador para el atributo tipo.
	 * @param tipo Informaci�n asocidada al nodo.
	 */
	public void setTipo(EntradaTS tipo) {
		this.tipo = tipo;
	}
}
