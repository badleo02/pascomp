/**
 * Paquete que engloba las distintas clases que componen el m�dulo de la
 * m�quina virtual del compilador.
 */
package mVirtual;

/**
 * Instrucci�n del lenguaje que est� compuesta por su nombre
 * y por el valor que toma. Puede que la instrucci�n no tome
 * ning�n valor.
 */
public class Instruccion {
		
	/**
	 * Nombre de la instrucci�n.
	 */
	private	String nombre;	
	
	/**
	 * Valor de la instrucci�n.
	 */
	private String valor;	
	
	/**
	 * Valor para los procedimientos.
	 */
	private String valor2;
		
	/**
	 * Constructora por defecto de la instrucci�n.
	 */
	 public Instruccion (){
		
	 }
	 
	/**
	 * Contructora de la instrucci�n que inicializa
	 * el nombre y el valor.
	 * @param nombre Nombre de la instrucci�n.
	 * @param valor  Valor que toma la instrucci�n.
	 */
	public Instruccion(String nombre, String valor) {
		this.nombre = nombre;
		this.valor = valor;
	}
	
	/**
	 * Constructora de la instrucci�n, que s�lo inicializa
	 * el nombre.
	 * @param nombre Nombre de la instrucci�n.
	 */
	public Instruccion(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Contructora de la instrucci�n que inicializa
	 * el nombre, el valor y el valor para los procedimientos.
	 * @param nombre Nombre de la instrucci�n.
	 * @param valor1  Valor que toma la instrucci�n.
	 * @param valor2 valor para los procedimientos
	 */
	public Instruccion(String nombre, String valor1, String valor2){
		this.nombre = nombre;
		this.valor = valor1;
		this.valor2 = valor2;
	}

	/**
	 * Accesor para el atributo nombre de la instrucci�n.
	 * @return Nombre de la instrucci�n.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Mutador para el nombre de la instrucci�n.
	 * @param nombre Nombre de la instrucci�n.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Accesor para el atributo valor de la instrucci�n.
	 * @return Valor de la instrucci�n.
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * Le asigna un valor a la instrucci�n.
	 * @param valor Valor de la instrucci�n.
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	/**
	 * M�todo que devuelve el nombre y el valor de
	 * una instrucci�n o s�lo el nombre en caso de 
	 * est� no tenga ning�n valor.
	 * @return String con el nombre y el valor de instrucci�n.
	 */
	public String toString(){		
		if(valor !=null){
			return nombre + "(" + valor + ");";
		}
		return nombre + ";";
	}

	/**
	 * Accesor para el atributo valor de los procedimientos.
	 * @return valor2 Valor para el procedimiento.
	 */
	public String getValor2() {
		return valor2;
	}
	
	/**
	 * Mutador para el atributovalor de los procedimientos.
	 * @param valor2 Valor para el procedimiento.
	 */
	public void setValor2(String valor2) {
		this.valor2 = valor2;
	}
}
