package mVirtual.instrucciones.pila;


import mVirtual.instrucciones.Instruccion;
import mVirtual.excepciones.MVException;

/**
 * 
 * Esta clase implementa la ejecuci�n en la pila de la instrucci�n apiladir de la m�quina virtual
 *
 */
public class InstruccionBurbuja implements Instruccion {

	/**
	 * Los datos con los cuales debe trabajar
	 */
	private String datos;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.getClass().getSimpleName()+"("+datos+")";
	}
	
	/* (non-Javadoc)
	 * @see maquinaVirtual.repertorio.Instruccion#Ejecutar(java.util.Stack, java.util.Hashtable)
	 */
	public void Ejecutar() throws MVException {
		//try{
		//	MaquinaVirtual.obtenerInstancia().getPila().pop();
		//}catch (Exception e){
		//	throw new ExcepcionEnEjecucion("Error de acceso a memoria");
		//} 
	}

	/* (non-Javadoc)
	 * @see maquinaVirtual.repertorio.Instruccion#getDatos()
	 */
	public String getDatos() {
		return datos;
	}

	/* (non-Javadoc)
	 * @see maquinaVirtual.repertorio.Instruccion#setDatos(java.lang.String)
	 */
	public void setDatos(String datos) {
		this.datos=datos;		
	}

}
