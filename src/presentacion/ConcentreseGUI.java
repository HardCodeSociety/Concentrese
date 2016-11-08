package presentacion;

import javax.swing.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import java.io.*;


//import aplicacion.*;
public class ConcentreseGUI extends JFrame{
	//Menu
	private JMenuBar barMenu;
	
	
	//Componentes de Menu
	private JMenu archivo;
	
	
	//Componentes Archivo
	private JMenuItem abrir;
	private JMenuItem guardar;
	private JMenuItem importar;
	private JMenuItem exportar;
	private JMenuItem salir;
	
	
	//Componentes Nivel 1
	private JPanel panelPrincipal;
	private JPanel panelJugadores;
	private JPanel panelTablero;
	private JPanel panelBotones;
	
	//Elementos Tablero
	private JPanel tablero;
	
	
	private ConcentreseGUI(){
		prepareElementos();
		prepareAcciones	();
		//concentrese= new Concentrese();
		//inicie();
	}
	public static void main(String[] args){
		ConcentreseGUI concen= new ConcentreseGUI();
		concen.setVisible(true);
	}
	private void prepareElementos(){
		setLayout(new BorderLayout(20,20));
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		setTitle("Concentrese");
		setSize(screen.width/2,screen.height/2);
		centre();
		elementosMenu();
		elementosPanelPrincipal();

	}
	private void prepareAcciones(){
		this.addWindowListener (
			new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					cerrarVentana();
				}
			}
		);
		salir.addActionListener(
			new  ActionListener(){
			public void actionPerformed(ActionEvent e){
				salir();
				}
			}
		);
	}
	public void cerrarVentana(){
			if(JOptionPane.showConfirmDialog(null, "¿Estas seguro?")== JOptionPane.OK_OPTION){
							setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}else{
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
	}
	public void salir(){
		if(JOptionPane.showConfirmDialog(null, "¿Estas seguro?")== JOptionPane.OK_OPTION)
			System.exit(0);
		}
	private void elementosPanelPrincipal(){
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout(20,20));
		elementosPanelJugadores();
		elementosPanelTablero();
		elementosPanelBotones();
		add(panelPrincipal);
	}
	private void elementosPanelJugadores(){
		panelJugadores= new JPanel();
		Border redline = BorderFactory.createLineBorder(Color.red);
		panelJugadores.setBorder(redline);
		panelJugadores.setLayout(new BorderLayout());
		panelPrincipal.add(panelJugadores, BorderLayout.NORTH);
	}
	private void elementosPanelTablero(){
		panelTablero= new JPanel();
		Border redline = BorderFactory.createLineBorder(Color.red);
		panelTablero.setBorder(redline);
		panelTablero.setLayout(new BorderLayout(70,70));
		tablero= new JPanel();
		tablero.setLayout(new GridLayout(8,8,1,1));
		tablero.setBorder(redline);
		JButton no= new JButton("pru");
		JButton nso= new JButton("prus");
		tablero.add(no);
		tablero.add(nso);
		panelTablero.add(tablero);
		panelPrincipal.add(panelTablero,BorderLayout.CENTER);
	}
	private void elementosPanelBotones(){
		panelBotones= new JPanel();
		Border redline = BorderFactory.createLineBorder(Color.red);
		panelBotones.setBorder(redline);
		panelBotones.setLayout(new GridLayout(1,3,3,3));
		panelPrincipal.add(panelBotones,BorderLayout.SOUTH);
	}
	
	
	
	private void elementosMenu(){
		barMenu= new JMenuBar();
		archivo= new JMenu("Archivo");
		abrir = new JMenuItem("Abrir");
		guardar = new JMenuItem("Guardar");
		importar = new JMenuItem("Importar");
		exportar = new JMenuItem("Exportar");
		salir = new JMenuItem("Salir");
		barMenu.add(archivo);
		archivo.add(abrir);
		archivo.addSeparator();
		archivo.add(guardar);
		archivo.addSeparator();
		archivo.add(importar);
		archivo.add(exportar);
		archivo.addSeparator();
		archivo.add(salir);
		setJMenuBar(barMenu);	
	}	
	private void centre(){
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		int xEsquina=(screen.width - getSize().width)/2;
		int yEsquina= (screen.height - getSize().height) /2;
		setLocation(xEsquina, yEsquina);
	}
}


