/**
 * Paquete que engloba todas las clases pertenecientes a la M�quina Virtual
 */
package mVirtual;

//LIBRER�AS:
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

import mVirtual.instrucciones.ExcepcionEnEjecucion;
import mVirtual.instrucciones.Instruccion;
	
/**
 * Clase que implementa la m�quina virtual. Recibir� un conjunto de instrucciones y deber� ejecutarlas una a una
 * guardando los resultados intermedios y finales .
 * 
 */
public class MaquinaVirtualImp extends MaquinaVirtual{

	//ATRIBUTOS:
  	
	/**
	 * Pila de la m�quina virtual.
	 */
	private Stack<String> pila;	
	/**
	 * Tabla Hash que contiene la memoria de datos.
	 */
	private Hashtable<Integer,String> memoriaDatos;	
	/**
	 * Contador de Programa. N�mero de instrucci�n que se est� ejecutando.
	 */
	private int contadorPrograma;	
	/**
	 * Conjunto de instrucciones que ejecutar� la m�quina virtual.
	 */
	private CodigoObjeto memoriaInstrucciones;	

	//M�TODOS:
    
	/**
	 * Constructora de la clase MaquinaVirtual.
	 * @param instrucciones Conjunto de intrucciones que ejecutar� la m�quina virtual.
	 */
	public MaquinaVirtualImp()
	{
		
	}	
	
	/**
	 * M�todo accesor del atributo memoriaDatos.
	 * @return Hashtable con la memoria de datos (resultados).
	 */
	public Hashtable<Integer,String> getMemoriaDatos()
	{
		return memoriaDatos;
	}	
    
	/**
	 * Ejecuta el listado de instrucciones que se encuentran en la memoria de instrucciones.
	 */
	public void ejecutar()
	{
		try {
		while(contadorPrograma < memoriaInstrucciones.getCodigo().size())
		{
			Instruccion aux = memoriaInstrucciones.getCodigo().get(contadorPrograma);
			aux.Ejecutar();
			contadorPrograma++;
			System.out.println(printMemoria());
			System.out.println(printPila());
			System.out.println();
			

		}	
		} catch (ExcepcionEnEjecucion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}		
	/**
	 * Ejecuta un paso de la m�quina virtual
	 * 
	 */
	public boolean ejecutarPaso() {
		boolean ejecucion=false;
		try {
			if (contadorPrograma<memoriaInstrucciones.getCodigo().size())
			{
				Instruccion aux = memoriaInstrucciones.getCodigo().get(contadorPrograma);
				aux.Ejecutar();
				contadorPrograma++;
				ejecucion= true;
			}	
			else
				ejecucion= false;
			} catch (ExcepcionEnEjecucion e) {
				e.printStackTrace();
			}
		return ejecucion;
	}

	/**
	 * Crea una nueva memoria de datos y pila, y pone el contador de programa a cero.
	 */
	public void resetear()
	{
		pila = new Stack<String>();
		memoriaDatos = new Hashtable<Integer,String>();
		memoriaDatos.put(0,"CP");
		memoriaDatos.put(1,"7");
		memoriaDatos.put(2,"7");
		memoriaDatos.put(3,"7");
		memoriaDatos.put(4,"7");
		memoriaDatos.put(5,"7");
		memoriaDatos.put(6,"7");
		contadorPrograma = 0;
	}
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
	public Stack<String> getPila() {
		return pila;
	}
/**
 * Devuelve el contador de programa de la MV
 * @return contador del programa de la MV
 */
	public int getContadorPrograma() {
		return contadorPrograma;
	}
/**
 * Devuelve la memoria de instrucciones de la MV
 * @return memoria de instrucciones de la MV
 */
	public CodigoObjeto getMemoriaInstrucciones() {
		return memoriaInstrucciones;
	}

	public void setContadorPrograma(int contadorPrograma) {
		this.contadorPrograma = contadorPrograma;
	}
	
	public void setMemoriaInstrucciones(CodigoObjeto memoriaInstrucciones) {
		this.memoriaInstrucciones = memoriaInstrucciones;
	}
	
	public String printMemoria(){
		Set<Integer> keys = memoriaDatos.keySet();
		Iterator<Integer> keysIt = keys.iterator();
		String salida = "";	
		
		Integer pos;
		while (keysIt.hasNext()){
			pos = keysIt.next();
			salida += "Posici�n de memoria: "+ pos + " contiene: " + memoriaDatos.get(pos) + "\n";
		}
		return salida;	
	}
	
	public String printPila(){
		Iterator<String> pilaIt= pila.iterator();
		String salida = "";	
		while (pilaIt.hasNext()){
			String datoPila = pilaIt.next();
			salida += datoPila + "\n";
		}
		return salida;
		
	}
}

