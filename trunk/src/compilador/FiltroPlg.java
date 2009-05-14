/**
 * Paquete que recoge los archivos que constituyen la interfaz 
 * gr�fica del compilador.
 */
package compilador;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * Clase que implementa un filtro para solo poder
 * seleccionar ficheros con la extensi�n ".txt" � ".plg"
 * que es la que nosotros utilizamos.
 */
public class FiltroPlg extends FileFilter{
	    
	/**
	 * Comprobador de extensi�n '.txt' � '.plg' en fichero.
	 * @param f es un fichero cualquiera
	 * @return si el fichero de entrada tiene la extensi�n
	 * ".txt" � ".plg"
	 */
	public boolean accept(File f){
	        return f.getName().toLowerCase().endsWith(".plg")||f.getName().toLowerCase().endsWith(".txt")||f.isDirectory();
	}
	
	/**
	 * M�todo que devuelve la descripci�n de los ficheros que se pueden 
	 * seleccionar.
	 * @return el tipo de ficheros que se pueden seleccionar.
	 */
	public String getDescription(){
	    return "Ficheros plg � txt" ;
	}
}
