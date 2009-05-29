package mVirtual;

import java.util.Vector;

import mVirtual.instrucciones.FactoriaComandos;
import mVirtual.instrucciones.Instruccion;

/** 
 * Clase que contiene el codigo objeto (secuencia de instrucciones)
 * 
 */
public class CodigoObjeto {

	//ATRIBUTOS:
	/** instrucciones */
	Vector<Instruccion> codigo;	

	//M�TODOS:
	/** Constructor por defecto*/
	public CodigoObjeto(){
		codigo = new Vector<Instruccion>();
	}

	/** Constructor que crea un nuevo objeto a partir de otro
	 * de la misma clase
	 * @param co c�digo objeto existente.
	 */
	public CodigoObjeto(CodigoObjeto co){
		codigo = new Vector<Instruccion>();
		codigo.addAll(co.getCodigo());
	}

	/** Getter
	 * @return codigo
	 */
	public Vector<Instruccion> getCodigo(){
		return codigo;
	}
	
	/** Crea una nueva instruccion y la a�ade al vector de instrucciones
	 * @param nombre String: nombre de la instruccion.
	 * @param param String: parametro.
	 */
	public void a�adeInstruccion(String nombre, String param){
		Instruccion i = FactoriaComandos.obtenerInstancia().generarComando(nombre);
		i.setDatos(param);
		codigo.add(i);
	}
		
	/** Crea una nueva instruccion sin par�metro y la a�ade 
	 * al vector de instrucciones
	 * @param nombre String: nombre de la instruccion.
	 */
	public void a�adeInstruccion(String nombre){
		Instruccion i = FactoriaComandos.obtenerInstancia().generarComando(nombre);
		codigo.add(i);
	}
	

}