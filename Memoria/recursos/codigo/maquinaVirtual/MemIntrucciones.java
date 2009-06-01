package maquinaVirtual;

import java.util.Vector;

import maquinaVirtual.instrucciones.GeneradorInstr;
import maquinaVirtual.instrucciones.Instruccion;

/** 
 * Clase que contiene  y maneja el la memoria de instrucciones 
 * (codigo objeto)
 * 
 */
public class MemIntrucciones {

	/** instrucciones */
	Vector<Instruccion> codigoObjeto;	

	/** Constructor por defecto*/
	public MemIntrucciones(){
		codigoObjeto = new Vector<Instruccion>();
	}

	/** Constructor que crea un nuevo objeto a partir de otro
	 * de la misma clase
	 * @param co c�digo objeto existente.
	 */
	public MemIntrucciones(MemIntrucciones co){
		codigoObjeto = new Vector<Instruccion>();
		codigoObjeto.addAll(co.getCodigo());
	}

	/** Getter
	 * @return codigo
	 */
	public Vector<Instruccion> getCodigo(){
		return codigoObjeto;
	}
	
	/** Crea una nueva instruccion y la a�ade al vector de instrucciones
	 * @param nombre String: nombre de la instruccion.
	 * @param param String: parametro.
	 */
	public void a�adeInstruccion(String nombre, String param){
		Instruccion instr = GeneradorInstr.obtenerInstancia().generaInstr(nombre);
		instr.setParam(param);
		codigoObjeto.add(instr);
	}
		
	/** Crea una nueva instruccion sin par�metro y la a�ade 
	 * al vector de instrucciones
	 * @param nombre String: nombre de la instruccion.
	 */
	public void a�adeInstruccion(String nombre){
		Instruccion instr = GeneradorInstr.obtenerInstancia().generaInstr(nombre);
		codigoObjeto.add(instr);
	}
	

}