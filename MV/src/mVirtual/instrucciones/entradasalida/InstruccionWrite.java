package mVirtual.instrucciones.entradasalida;


import comunicacion.Controlador;
import comunicacion.transfers.FactoriaTransfers;
import comunicacion.transfers.Transfer;

import mVirtual.MaquinaVirtual;
import mVirtual.instrucciones.ExcepcionEnEjecucion;
import mVirtual.instrucciones.Instruccion;
/**
 * Esta clase implementa la ejecuci�n en la pila de la instrucci�n write de la m�quina virtual
 *
 */
public class InstruccionWrite implements Instruccion {

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
	/* (non-Javadoc)
	 * @see maquinaVirtual.repertorio.Instruccion#Ejecutar(java.util.Stack, java.util.Hashtable)
	 */
	public void Ejecutar() throws ExcepcionEnEjecucion {
		Transfer t =FactoriaTransfers.obtenerInstancia().generarTransfer();
		t.setComunicacionInterna(true);
		t.setTexto(MaquinaVirtual.obtenerInstancia().getPila().pop()+"",0);
		Controlador.obtenerInstancia().actualizarVistas(t);
	}

	/* (non-Javadoc)
	 * @see maquinaVirtual.repertorio.Instruccion#getDatos()
	 */
	public String getDatos() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see maquinaVirtual.repertorio.Instruccion#setDatos(java.lang.String)
	 */
	public void setDatos(String datos) {
		// TODO Auto-generated method stub
		
	}

}
