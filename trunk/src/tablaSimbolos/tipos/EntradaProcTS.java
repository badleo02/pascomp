/**
 * Paquete que engloba todas las clases referentes a la tabla de s�mbolos
 */
package tablaSimbolos.tipos;

import utils.TTipo;

/**
 * Clase que implementa el nodo procedimiento.
 *
 */
public class EntradaProcTS extends EntradaTS{
		
	/**
	 * Constructora de la clase.
	 * Inicializa el nodo con el tipo 'PROC' y un tama�o indicado
	 * @param tamanno Tama�o del nodo
	 */
	public EntradaProcTS(int tamanno){		
		super(TTipo.PROC, tamanno);
	}
}
