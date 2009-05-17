package mVirtual;

import java.util.Hashtable;
import java.util.Stack;

public abstract class MaquinaVirtual {
	private static MaquinaVirtual instancia;
	
	public static MaquinaVirtual obtenerInstancia(){
		if (instancia==null)
			instancia=new MaquinaVirtualImp();
		return instancia;
	}
	/**
	 * M�todo accesor del atributo memoriaDatos.
	 * @return Hashtable con la memoria de datos (resultados).
	 */
	public abstract Hashtable<Integer, String> getMemoriaDatos();

	/**
	 * Ejecuta el listado de instrucciones que se encuentran en la memoria de instrucciones.
	 */
	public abstract void ejecutar();

	/**
	 * Ejecuta un paso de la m�quina virtual
	 * 
	 */
	public abstract boolean ejecutarPaso();

	/**
	 * Crea una nueva memoria de datos y pila, y pone el contador de programa a cero.
	 */
	public abstract void resetear();

	//prueba de la m�quina virtual
	/*public static void main(String[] args){
	 CodigoObjeto co= new CodigoObjeto();
	 co.a�adirInstruccion("Apila","1");
	 co.a�adirInstruccion("Apila","2");
	 co.a�adirInstruccion("Apila","3");
	 co.a�adirInstruccion("Apila","4");
	 co.a�adirInstruccion("Apila","5");
	 co.a�adirInstruccion("Apila","6");
	 co.a�adirInstruccion("Desapila");
	 co.a�adirInstruccion("Desapila");
	 co.a�adirInstruccion("Suma");
	 co.a�adirInstruccion("Suma");
	 co.a�adirInstruccion("DesapilaDireccion","1");
	 co.a�adirInstruccion("Apila","7");
	 co.a�adirInstruccion("Resta");
	 MaquinaVirtual mv= new MaquinaVirtual(co);
	 mv.ejecutar();
	 }*/
	/**
	 * Devuelve la pila actual de la MV
	 */
	public abstract Stack<String> getPila();

	/**
	 * Devuelve el contador de programa de la MV
	 * @return contador del programa de la MV
	 */
	public abstract int getContadorPrograma();

	/**
	 * Devuelve la memoria de instrucciones de la MV
	 * @return memoria de instrucciones de la MV
	 */
	public abstract CodigoObjeto getMemoriaInstrucciones();
	public abstract void setContadorPrograma(int contadorPrograma);
	public abstract void setMemoriaInstrucciones(CodigoObjeto memoriaInstrucciones);

}