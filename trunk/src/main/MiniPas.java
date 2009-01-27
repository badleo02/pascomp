package main;

import java.io.IOException;

import mepa.Mepa;
import aSintactico.AnalizadorSintactico;

/**
 * COMPILADOR
 * 
 * @see aSintactico.AnalizadorSintactico
 * @see mepa.Mepa
 * @since 1.5
 */
public final class MiniPas implements Testeable {
	/** Analizador sintactico */
	private AnalizadorSintactico as = null;

	/** Maquina virtual */
	private Mepa mepa = null;

	/** Archivo a analizar */
	private String strFile;

	/**
	 * Constructor
	 */
	public MiniPas() {
		as = new AnalizadorSintactico();
	}

	/** */
	public void finish() {
		// nada para hacer
	}

	/**
	 * Compila y ejecuta
	 * 
	 * @throws java.lang.Exception
	 *             si ocurre error en la compilacion o en la ejecucion
	 */
	public void run() throws Exception {
		/** ETAPA DE COMPILACION Y GEN DE CODIGO */
		try {
			as.setSourceFile(strFile);
			as.run();
			as.finish();
		} catch (Exception ex) {
			as.finish();
			throw ex;
		}

		/** ETAPA DE EJECUCION */
		try {
			// OBTENGO EL ARCHIVO .mep GENERADO
			java.io.File f = as.getOutputFile();

			// PUEDE SER NULL SI COMPILO SIN GENERACION DE CODIGO
			if (f == null)
				return;

			// CREO LA MEPA Y EJECUTO EL ARCHIVO
			mepa = new Mepa();
			mepa.setSourceFile(f.getAbsolutePath());
			mepa.run();
			mepa.finish();

		} catch (Exception ex) {
			mepa.finish();
			throw ex;
		}
	}

	/**
	 * Setea el archivo a compilar
	 * 
	 * @param strFile
	 *            nombre de archivo
	 * @throws java.io.IOException
	 *             En este caso no ocurre excepcion
	 */
	public void setSourceFile(String strFile) throws IOException {
		this.strFile = strFile;
	}

	/**
	 * Verifica que el archivo tenga la extension correcta
	 * 
	 * @param strFile
	 *            nombre de archivo a compilar
	 * @return true si el archivo soporta la extension correcta
	 * @see config.conf
	 */
	public boolean validaExtension(String strFile) {
		return as.validaExtension(strFile);
	}

}