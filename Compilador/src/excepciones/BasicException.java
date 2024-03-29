
package excepciones;

import java.util.HashMap;

/**
 * Clase base de las excepciones del compilador
 *
 */
public class BasicException extends Exception{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Mapa que asocia a un codigo a un mensaje de error
     */
    protected static final HashMap<Integer,String> errorMap = new HashMap<Integer,String>();
    
    /**
     * Codigo de error, es la clave del hash errorMap.
     * Gracias a ello obtenemos los mensajes de error
     */
    protected int codigo;
    
    /** Creates a new instance of BasicException */
    public BasicException(String txt) {
        super(txt);
    }
    
    /**
     * Obtiene el codigo de error de la excepcion
     * @return el codigo de error
     */
    public int getCodigoError(){
        return codigo;
    }
}
