/**
 * Paquete que engloba las distintas clases que componen el m�dulo de la
 * m�quina virtual del compilador.
 */
package mVirtual;

import java.util.Vector;
import java.io.*;

/** 
 * Clase que implementa el c�digo objeto que estar� compuesto por una secuencia 
 * de instrucciones.
 */
public class CodigoObjeto {

	/** 
	 * Vector de Instruccion que va a contener las instrucciones. 
	 */
	Vector<Instruccion> codigo;

	/** 
	 * Constructora por defecto de la clase.
	 */
	public CodigoObjeto(){
		codigo = new Vector<Instruccion>();
	}

	/** Constructora de la clase, que crea un nuevo Codigo Objeto a partir
	 * de uno existente.
	 * @param cO c�digo objeto existente.
	 */
	public CodigoObjeto(CodigoObjeto cO){
		codigo = new Vector<Instruccion>();
		codigo.addAll(cO.getCodigo());
	}

	/** M�todo accesor para el atributo c�digo.
	 * @return Devuelve el atributo codigo.
	 */
	public Vector<Instruccion> getCodigo(){
		return codigo;
	}
	
	/** M�todo que crea una instrucci�n con los atributos indicados
	 *  y la inserta.
	 * @param nombre String con el nombre de la instruccion.
	 * @param valor String con el valor que toma la instruccion.
	 */
	public void a�adirInstruccion(String nombre, String valor){
		Instruccion i = new Instruccion(nombre, valor);
		codigo.add(i);
	}
		
	/** Crea una instrucci�n con el atributo indicado y la inserta
	 *  pero en este caso la instrucci�n no tiene valores.
	 * @param nombre String con el nombre de la instruccion.
	 */
	public void a�adirInstruccion(String nombre){
		Instruccion i = new Instruccion(nombre);
		codigo.add(i);
	}
	
	/** Escribe sobre el fichero indicado las instrucciones contenidas
	 *  en el vector.
	 * @param nombreFichero String que contiene el nombre del fichero
	 *  donde se van a almacenar las instrucciones.
	 */
	public void volcarEnFichero(String nombreFichero){
		File fich = new File(nombreFichero);
		try{
			FileWriter out = new FileWriter(fich);
			Instruccion elem;
			for(int i = 0; i<codigo.size(); i++){
				elem = codigo.elementAt(i);
				out.write(elem.toString()+" \r\n");
			}
			out.close();
		}
		catch(IOException e){
			
		}
	}
	
	/**
	 * Pasa a String el c�digo objeto.
	 * @param cp Se utiliza para mostrar d�nde se encuentra 
	 * el contador del programa en cada momento.
	 * @return Cadena de caracteres con el c�digo objeto 
	 * de la instrucci�n que se encuentra en la posici�n cp.
	 */
	public String toString(int cp){
		String s="";
		Instruccion elem;
		for(int i = 0; i<codigo.size(); i++){
			elem = codigo.elementAt(i);
			if (cp == i)
				s+="==> "+i+"  - "+(elem.toString()+" \r\n");
			else
				s+="    "+i+"  - "+(elem.toString()+" \r\n");	
		}
		return s;
	}
	
	/**
	 * Actualiza las direcciones de salto en el c�digo objeto.
	 * @param etiq1 n�mero de instrucci�n que hay que actualizar.
	 * @param etiq2 valor nuevo de destino de salto.
	 */
	public void parchea(Integer etiq1, Integer etiq2){
		Instruccion aux = codigo.elementAt(etiq1);
		aux.setValor(etiq2.toString());
		codigo.setElementAt(aux, etiq1);
	}
}