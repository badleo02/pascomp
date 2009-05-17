package mVirtual.instrucciones;
/**
 * 
 * Lanza una excepci�n en tiempo de ejecucion del codigo maquina con un string motivo
 *
 */
public class ExcepcionEnEjecucion extends Exception {

	/**
	 * Numero de serializacion para el guardado de excepciones
	 */
	private static final long serialVersionUID = -4288795821514051474L;
	/**
	 * Lanza una excepci�n en ejecuci�n con un motivo pasado por par�metro
	 * @param motivo String que indica el motivo del lanzamiento de la excepci�n
	 */
	public ExcepcionEnEjecucion(String motivo){
		super(motivo);	
	}
}
