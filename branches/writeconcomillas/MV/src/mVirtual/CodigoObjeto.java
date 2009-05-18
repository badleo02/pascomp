package mVirtual;

//LIBRER�AS
import java.util.Vector;
import java.io.*;

import mVirtual.instrucciones.FactoriaComandos;
import mVirtual.instrucciones.Instruccion;

/** 
 * Clase que implementa el c�digo objeto que estar� compuesto por una secuencia 
 * de instrucciones.
 * 
 */
public class CodigoObjeto {

	//ATRIBUTOS:
	/** Vector de Instruccion que va a contener las instrucciones. */
	Vector<Instruccion> codigo;	

	//M�TODOS:
	/** Constructora por defecto de la clase. */
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
	
	/** M�todo que crea una instruccion con los atributos indicados y la inserta.
	 * @param nombre String con el nombre de la instruccion.
	 * @param valor String con el valor que toma la instruccion.
	 */
	public void a�adirInstruccion(String nombre, String valor){
		Instruccion i = FactoriaComandos.obtenerInstancia().generarComando(nombre);
		i.setDatos(valor);
		codigo.add(i);
	}
		
	/** Crea una instruccion con el atributo indicado y la inserta pero en esta caso
	 * la instrucci�n no tiene valores.
	 * @param nombre String con el nombre de la instruccion.
	 */
	public void a�adirInstruccion(String nombre){
		Instruccion i = FactoriaComandos.obtenerInstancia().generarComando(nombre);
		codigo.add(i);
	}
	
	/** Escribe sobre el fichero indicado las instrucciones contenidas en el vector.
	 * @param nombreFichero String que contiene el nombre del fichero donde se van a 
	 * 			almacenar las instrucciones.
	 */
	public void volcarEnFichero(String nombreFichero){
		//Abrimos el fichero y su correspondiente FileWriter
		File fich = new File(nombreFichero);
		try{
			FileWriter out = new FileWriter(fich);
			
			//Recorremos elemento a elemento nuestro vector y lo vamos poniendo
			//en el fichero de salida.
			Instruccion elem;
			for(int i = 0; i<codigo.size(); i++){
				elem = codigo.elementAt(i);
				out.write(elem.toString()+" \r\n");
			}
			out.close();
		}
		catch(IOException e){
			//Tratar excepci�n
			
		}
	}
	/**
	 * Recorremos elemento a elemento nuestro vector y lo vamos poniendo
	 *	en el fichero de salida.
	 */
	public String toString(){
		String s="";
		
		Instruccion elem;
		for(int i = 0; i<codigo.size(); i++){
			elem = codigo.elementAt(i);
			s+=(elem.toString()+" \r\n");
		}
		return s;
	}
}