/**
 * Paquete que recoge los recursos en los que se apoyan los distintos m�dulos
 * del compilador.
 */
package utils.error;

/**
 * Tipo enumerado compuesto por:
 * LEXICO: Error l�xico.
 * SINTACTICO: Error sint�ctico.
 * SEMANTICO: Error sem�ntico.
 * EJECUCI�N: Error en tiempo de ejecuci�n.
 */
public enum TError {
	LEXICO,
	SINTACTICO,
	SEMANTICO,
	EJECUCION
}
