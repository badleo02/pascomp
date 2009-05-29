package traductor.tablaSimbolos;
import java.util.*;

import excepciones.CompiladorException;

/**
 * Implementacion de la Tabla de Simbolos
 * 
 */
public class TablaSimbolosImp extends TablaSimbolos {

	private ArrayList<Hashtable<String, TInfo>> TS;

	public TablaSimbolosImp() {
		TS = new ArrayList<Hashtable<String, TInfo>>();
		Hashtable<String, TInfo> nivelini = new Hashtable<String, TInfo>();
		TS.add(nivelini);
		PropTipos p = new PropTiposInt();
		TInfo inf = new TInfo(TElemento.TIPOBASICO, 0, p);
		TS.get(0).put("integer", inf);

		p = new PropTiposBool();
		inf = new TInfo(TElemento.TIPOBASICO, 0, p);
		TS.get(0).put("boolean", inf);
	}

	public void a�adeTipo(String id, PropTipos p, int nivel) throws Exception {

		TInfo inf = new TInfo(TElemento.TIPOCONSTRUIDO, 0, p);
		TS.get(nivel).put(id, inf);
	}

	public void a�adeVariable(String id, int dir, PropTipos p, int nivel) throws Exception {
		TInfo inf = new TInfo(TElemento.VAR, dir, p);
		TS.get(nivel).put(id, inf);
	}

	public boolean existeTipo(String id, int nivel) {

		int lvl = nivel;
		boolean esta = false;
		while (!esta && lvl >= 0) {
			esta = TS.get(lvl).containsKey(id);
			esta = (esta && ((TS.get(lvl).get(id).dameElemento() == TElemento.TIPOBASICO) || (TS.get(lvl).get(id).dameElemento() == TElemento.TIPOCONSTRUIDO)));
			lvl--;
		}
		lvl++;
		return esta;
	}

	public boolean existeConstante(String id, int nivel) {

		int lvl = nivel;
		boolean esta = false;
		while (!esta && lvl >= 0) {
			esta = TS.get(lvl).containsKey(id);
			esta = (esta && (TS.get(lvl).get(id).dameElemento() == TElemento.CONST));
			lvl--;
		}
		lvl++;
		return esta;

	}

	public boolean existeVariable(String id, int nivel) {
		int lvl = nivel;
		boolean esta = false;
		while (!esta && lvl >= 0) {
			esta = TS.get(lvl).containsKey(id);
			esta = (esta && (TS.get(lvl).get(id).dameElemento() == TElemento.VAR));
			lvl--;
		}
		lvl++;
		return esta;
	}

	public TInfo obtenerInfo(String id, int nivel) throws Exception {

		int lvl = nivel;
		boolean esta = false;
		// buscamos el nivel en el que est�, y lo almacenamos en lvl
		while (!esta && lvl >= 0) {
			esta = TS.get(lvl).containsKey(id);
			lvl--;
		}
		lvl++;
		return TS.get(lvl).get(id);
	}

	public PropTipos dameTipoNivel(String id, int nivel) {

		return TS.get(nivel).get(id).getProp();
	}

	public PropTipos dameTipo(String id, int nivel) {
		int lvl = nivel;
		boolean esta = false;
		// buscamos el nivel en el que est�, y lo almacenamos en lvl
		while (!esta && lvl >= 0) {
			esta = TS.get(lvl).containsKey(id);
			lvl--;
		}
		lvl++;
		return TS.get(lvl).get(id).getProp();
	}

	public void a�adeConstante(String id, int dir, PropTipos p, int nivel) throws Exception {
		// hacer bien con nivel y mirar el nivel antes de insertar
		TInfo inf = new TInfo(TElemento.CONST, dir, p);
		TS.get(nivel).put(id, inf);
	}

	public void a�adeIdenProgram(String id, int nivel, PropTiposPro p) throws Exception {

		TInfo inf = new TInfo(TElemento.VACIO, 0, p);
		TS.get(nivel).put(id, inf);
	}

	public void a�adeProcedimiento(String id, int nivel, PropTiposPro p, int dir) throws Exception {

		TInfo inf = new TInfo(TElemento.PROCEDIMIENTO, dir, p);
		TS.get(nivel).put(id, inf);
	}

	public void liberarNivel(int nivel) {

		TS.remove(nivel);
	}

	public void crearNivel(int nivel) {
		Hashtable<String, TInfo> tablanivel = new Hashtable<String, TInfo>();
		TS.add(nivel, tablanivel);
	}

	public boolean existeVariableNivel(String id, int nivel) {

		boolean existe = TS.get(nivel).containsKey(id);

		return existe && (TS.get(nivel).get(id).dameElemento() == TElemento.VAR);

	}

	public boolean existeConstanteNivel(String id, int nivel) {
		boolean existe = TS.get(nivel).containsKey(id);

		return existe && (TS.get(nivel).get(id).dameElemento() == TElemento.CONST);
	}

	public boolean existeProcedimiento(String id, int nivel) {
		int lvl = nivel;
		boolean esta = false;
		while (!esta && lvl >= 0) {
			esta = TS.get(lvl).containsKey(id);
			esta = (esta && (TS.get(lvl).get(id).dameElemento() == TElemento.PROCEDIMIENTO));
			lvl--;
		}
		lvl++;
		return esta;
	}

	public boolean existeProcedimientoNivel(String id, int nivel) {
		boolean existe = TS.get(nivel).containsKey(id);

		return existe && (TS.get(nivel).get(id).dameElemento() == TElemento.PROCEDIMIENTO);
	}

	public boolean existeTipoNivel(String id, int nivel) {

		return TS.get(nivel).containsKey(id);
	}

	public boolean ambitoConstante(String id, int nivel) throws Exception {
		int lvl = nivel;
		boolean esConst = false;
		boolean esta = false;
		while (!esta && lvl >= 0) {
			esta = TS.get(lvl).containsKey(id);
			if (esta) {
				esConst = (TS.get(lvl).get(id).dameElemento() == TElemento.CONST);
			}
			lvl--;
		}
		lvl++;
		if (!esta) {
			throw new CompiladorException("No existe Identificador en la tabla de s�mbolos");

		}
		return esConst;
	}

	@Override
	public int dameNivel(String id, int nivel) {
		int lvl = nivel;
		boolean esta = false;
		while (!esta && lvl >= 0) {
			esta = TS.get(lvl).containsKey(id);
			lvl--;
		}
		lvl++;
		return lvl;
	}

}
