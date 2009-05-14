/**
 * Paquete que recoge los recursos en los que se apoyan los distintos m�dulos
 * del compilador.
 */
package utils.error;

/**
 * Implementa la informaci�n y funciones para el control de un error
 * detectado en el c�digo fuente.
 */
public class Error {
	
	/**
	 * Mensaje de error a mostrar (principal causa del error).
	 */
	private String mensajeError;

	/**
	 * Tipo de error.
	 */
	private TError tipoError;
	
	/**
	 * Constructor principal, inicializa la componente a utilizar
     * en el objeto seg�n el valor del mensaje indicado y su tipo.
     * @param tipo Tipo del error.
     * @param mensaje Mensaje de error (causa).
	 */
	public Error(TError tipo, String mensaje){
		tipoError = tipo;
		if (tipo == TError.LEXICO){
			mensajeError = "Error l�xico - ";
		}
		else{
			if (tipo == TError.SINTACTICO){
				mensajeError = "Error sint�ctico - ";
			}else{
				if (tipo == TError.SEMANTICO){
					mensajeError = "Error sem�ntico - ";
				}else{
					mensajeError = "Error en tiempo de ejecuci�n - ";
				}
			}
		}
		mensajeError = mensajeError+mensaje;
	}
	
	/**
	 * Accesora para el atributo mensaje de error.
	 * @return Mensaje de error.
	 */
	public String getMensajeError(){
		return mensajeError;
	}
	
	/**
	 * Accesora para el atributo del tipo de error.
	 * @return Tipo del error.
	 */
	public TError getTipoError(){
		return tipoError;
	}
}
