package traductor;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;

import mVirtual.MaquinaVirtualImpl;
import mVirtual.MaquinaVirtual;
import mVirtual.excepciones.MVException;
import main.Traductor;

import traductor.excepciones.CompiladorException;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

;
public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	JMenuBar menu;
	JMenu archivo, compilar, informacion;
	JMenuItem abrir, guardar, salir, normal, paso, integrantes;
	JLabel etiqueta1, etiqueta2, etiqueta3, etiqueta4;
	JButton boton1, boton2, boton3;
	JPanel panel;
	JTextArea texto1, texto2, texto3, texto4;
	File archivoAux;
	Traductor compi;
	enum Estados {INI, COMPILADO, PASO}
	Estados estado = Estados.INI;

	public Ventana() {

		menu = new JMenuBar();
		archivo = new JMenu("Archivo");
		abrir = new JMenuItem("Abrir");
		abrir.addActionListener(new OyenteAbrir());
		guardar = new JMenuItem("Guardar");
		// guardar.addActionListener(new OyenteGuardar());
		salir = new JMenuItem("Salir");
		salir.addActionListener(new OyenteSalir());
		archivo.add(abrir);
		archivo.add(guardar);
		archivo.add(new JSeparator());
		archivo.add(salir);
		menu.add(archivo);
		compilar = new JMenu("Compilar");
		normal = new JMenuItem("Normal");
		normal.addActionListener(new OyenteNormal());
		paso = new JMenuItem("Paso a Paso");
		paso.addActionListener(new OyentePaso());
		compilar.add(normal);
		compilar.add(paso);
		menu.add(compilar);
		informacion = new JMenu("Infomaci�n");
		integrantes = new JMenuItem("Integrantes del grupo");
		integrantes.addActionListener(new OyenteIntegrantes());
		informacion.add(integrantes);
		menu.add(informacion);

		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		etiqueta1 = new JLabel("Cuadro de c�digo");
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		panel.add(etiqueta1, constraints);

		etiqueta2 = new JLabel("C�digo objeto generado");
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		panel.add(etiqueta2, constraints);

		etiqueta3 = new JLabel("Errores de compilaci�n");
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		panel.add(etiqueta3, constraints);

		etiqueta4 = new JLabel("Estado de la memoria");
		constraints.gridx = 2;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		panel.add(etiqueta4, constraints);

		texto1 = new JTextArea("program HolaMundo");
		texto1.setEditable(false);
		JScrollPane pScroll1 = new JScrollPane(texto1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 3;
		constraints.gridheight = 2;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weighty = 1.0;
		constraints.weightx = 1.0;
		panel.add(pScroll1, constraints);

		texto2 = new JTextArea("");
		texto2.setEditable(false);
		JScrollPane pScroll2 = new JScrollPane(texto2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weighty = 1.0;
		constraints.weightx = 1.0;
		panel.add(pScroll2, constraints);

		texto3 = new JTextArea("");
		texto3.setEditable(false);
		JScrollPane pScroll3 = new JScrollPane(texto3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		constraints.gridx = 1;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weighty = 1.0;
		constraints.weightx = 1.0;
		panel.add(pScroll3, constraints);

		texto4 = new JTextArea("");
		texto4.setEditable(false);
		JScrollPane pScroll4 = new JScrollPane(texto4, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		constraints.gridx = 2;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weighty = 1.0;
		constraints.weightx = 1.0;
		panel.add(pScroll4, constraints);

		constraints.weighty = 0.0;
		constraints.weightx = 0.0;

		boton1 = new JButton("Compilar");
		boton1.addActionListener(new OyenteNormal());
		constraints.gridx = 0;
		constraints.gridy = 9;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		panel.add(boton1, constraints);

		boton2 = new JButton("Paso a Paso?");
		boton2.addActionListener(new OyentePaso());
		constraints.gridx = 2;
		constraints.gridy = 9;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		panel.add(boton2, constraints);
		
		boton3 = new JButton("Ejecutar");
		boton3.addActionListener(new OyenteEjecutar());
		constraints.gridx = 1;
		constraints.gridy = 9;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		panel.add(boton3, constraints);

		getContentPane().add(panel);
		setJMenuBar(menu);
	}

	// ==================== oyentes ==============================

	class OyenteAbrir implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			String Text = "";
			FileReader fichero = null;
			try {
				JFileChooser abrir = new JFileChooser(System.getProperty("user.dir"));
				FileFilter filter1 = new ExtensionFileFilter("SRC", new String[] { "src" });
				abrir.setFileFilter(filter1);
				abrir.showOpenDialog(null);
				archivoAux = abrir.getSelectedFile(); // Devuelve el File que
														// vamos a leerName
				if (archivo != null) {
					texto1.setText("");
					fichero = new FileReader(archivoAux);
					BufferedReader leer = new BufferedReader(fichero);
					int cont=1;
					while ((Text = leer.readLine()) != null) {
						texto1.append(cont+".  "+Text + "\n"); // append Concatena la linea
						cont++;							// leida
					}
					leer.close();
	
				}
			} catch (IOException ioe) {
				System.out.println(ioe);
			} finally {
				try {
					fichero.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * class OyenteGuardar implements ActionListener{ public void
	 * actionPerformed(ActionEvent evento){ try{ System.getProperty("user.dir");
	 * //Abre el JFileChooser JFileChooser guardar=new
	 * JFileChooser(System.getProperty("user.dir")); FileFilter filter1 = new
	 * ExtensionFileFilter("PAS", new String[] { "pas"});
	 * guardar.setFileFilter(filter1); guardar.showSaveDialog(null); //Muestra
	 * el di�logo File archivo = guardar.getSelectedFile(); String nombre= "/" +
	 * archivo.getName()+ ".pas"; File archivoNuevo = new
	 * File(archivo.getParent()+nombre);
	 * 
	 * if(archivoNuevo !=null){ FileWriter Guardx=new FileWriter(archivoNuevo);
	 * Guardx.write(texto1.getText()); Guardx.close(); //Cierra el fichero } }
	 * catch(IOException ioe){ System.out.println(ioe); //Muestra por consola
	 * los errores } } }
	 */
	class OyenteIntegrantes implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			// JOptionPane inf = new JOptionPane();
			JOptionPane
					.showMessageDialog(
							null,
							"Carlos Fern�ndez Ag�ero\n Daniel �lvarez Ram�rez\n Javier Mart�nez Puentes\n Antonio Ariza Guerrero\n Isamu Takebe Heras\n Carla Margalef Bentabol\n V�ctor Abascal Pelayo\n Jes�s De Lara Gimeno\n Andr�s Jim�nez S�nchez\n Ignacio Fern�ndez Cuesta\n",
							"Integrantes del grupo", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	class OyenteSalir implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			System.exit(0);
		}
	}

	class OyenteNormal implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			compi = new Traductor();
			compi.reset();
			compi.setEntrada(archivoAux.getPath());
			compi.setSalida(archivoAux.getPath().substring(0, archivoAux.getPath().length() - 4));
			try {
				compi.ejecutar();
				estado = Estados.COMPILADO;
			} catch (CompiladorException e) {
				System.out.println("Se produjeron errores al compilar:");
				System.out.println(e.getMensajeError());
				texto3.setText("Se produjeron errores al compilar:\n");
				texto3.setText(e.getMensajeError());
			} catch (Exception e) {
				System.out.println("Se produjeron errores desconocidos al compilar:");
				e.printStackTrace();
				texto3.setText("Se produjeron errores desconocidos al compilar:\n");
				texto3.setText(e.getStackTrace().toString());
			}
			texto2.setText("");
			try {
				FileReader Fichero = new FileReader(compi.getSalida() + ".mv");
				BufferedReader leer = new BufferedReader(Fichero);
				String temp;
				int cont=1;
				while ((temp = leer.readLine()) != null) {
					texto2.append(cont+".  "+temp + "\n"); // append Concatena la linea
					cont++;							// leida
				}
				leer.close();
			} catch (Exception e) {
				texto3.setText("Fichero no encontrado.");
			}
			// llamada a nuestro metodo con el archivo aux

		}
	}

	class OyentePaso implements ActionListener {

		public void actionPerformed(ActionEvent evento) {
			if(estado != Estados.INI){
				try {
					MaquinaVirtualImpl mv = (MaquinaVirtualImpl) MaquinaVirtual.obtenerInstancia();
					String result;
					if(estado != Estados.PASO){
						String[] args = new String [2];
						args[0] = compi.getSalida() + ".mv";
						args[1] = "-b";
						result = mv.crearTransfer(args);
						estado = Estados.PASO;
					}else{
						result = mv.ejecutarPaso();
					}
					texto4.setText(result);
				} catch (MVException e) {
					System.out.println("[MV] Error en linea " + e.getNumLinea() + ": " + e.getError());
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				texto3.setText("No se ha compilado ning�n fichero.");
			}
		}
	}


	class OyenteEjecutar implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			if(estado != Estados.INI){	
				try {
					MaquinaVirtualImpl mv = (MaquinaVirtualImpl) MaquinaVirtual.obtenerInstancia();
					String result;
					String[] args = new String [1];
					args[0] = compi.getSalida() + ".mv";
					result = mv.crearTransfer(args);
					texto4.setText(result);
					estado = Estados.COMPILADO;
				} catch (MVException e) {
					System.out.println("[MV] Error en linea " + e.getNumLinea() + ": " + e.getError());
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				texto3.setText("No se ha compilado ning�n fichero.");
			}
		}
	}

	
	class ExtensionFileFilter extends FileFilter {
		String description;

		String extensions[];

		public ExtensionFileFilter(String description, String extension) {
			this(description, new String[] { extension });
		}

		public ExtensionFileFilter(String description, String extensions[]) {
			if (description == null) {
				this.description = extensions[0];
			} else {
				this.description = description;
			}
			this.extensions = (String[]) extensions.clone();
			toLower(this.extensions);
		}

		private void toLower(String array[]) {
			for (int i = 0, n = array.length; i < n; i++) {
				array[i] = array[i].toLowerCase();
			}
		}

		public String getDescription() {
			return description;
		}

		public boolean accept(File file) {
			if (file.isDirectory()) {
				return true;
			} else {
				String path = file.getAbsolutePath().toLowerCase();
				for (int i = 0, n = extensions.length; i < n; i++) {
					String extension = extensions[i];
					if ((path.endsWith(extension) && (path.charAt(path.length() - extension.length() - 1)) == '.')) {
						return true;
					}
				}
			}
			return false;
		}
	}
}