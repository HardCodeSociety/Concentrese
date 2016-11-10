package presentacion;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import java.io.*;
import java.util.*;

//import aplicacion.*;
public class ConcentreseGUI extends JFrame{
	//Menu
	private JMenuBar barMenu;
	
	
	//Componentes de Menu
	private JMenu archivo;
	private JFileChooser abrirArchivo;
	private JFileChooser salvar;
	
	
	//Componentes Archivo
	private JMenuItem abrir;
	private JMenuItem guardar;
	private JMenuItem importar;
	private JMenuItem exportar;
	private JMenuItem salir;
	
	
	//Componentes Nivel 1
	private JPanel panelJugadores;
	private JPanel panelTablero;
	private JPanel panelBotones;
	
	//ELementos Jugadores
	private String nombreJugador1="Pardo";
	private String nombreJugador2="Vaca";
	private JLabel jugador1;
	private JLabel jugador2;
	private JTextField puntaje1;
	private JTextField puntaje2;
	private Color color1=Color.red;
	private Color color2=Color.blue;
	
	//Elementos Tablero
	private JPanel tablero;
	private int filas=8;
	private int columnas=8;
	private ArrayList<JButton> botones;
	
	//Elementos Botones
	private JButton reiniciar;
	private JButton modificar;
	private JButton redimensionar;
	
	private ConcentreseGUI(){
		prepareElementos();
		prepareAcciones	();
		//concentrese= new Concentrese();
		//inicie();
	}

	//main
	public static void main(String[] args){
		ConcentreseGUI concen= new ConcentreseGUI();
		concen.setVisible(true);
	}

	//elementos visuales

	private void prepareElementos(){
		setLayout(new BorderLayout(3,3));
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		setTitle("Concentrese");
		setSize(screen.width/2,screen.height/2);
		centre();
		elementosMenu();
		elementosPanelJugadores();
		elementosPanelTablero();
		elementosPanelBotones();

	}

	//oyentes

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
		abrir.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					abrir();
				} 
			}
		);
		guardar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						salvar();
					} 
				}
			);
	}


	public void cerrarVentana(){
			if(JOptionPane.showConfirmDialog(null, "Estas seguro?")== JOptionPane.OK_OPTION){
							setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}else{
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
	}
	public void salir(){
		if(JOptionPane.showConfirmDialog(null, " Estas seguro?")== JOptionPane.OK_OPTION)
			System.exit(0);
		}
	public void abrir(){
		abrirArchivo= new JFileChooser();
		int desicion = abrirArchivo.showOpenDialog(this);
		if (desicion == JFileChooser.APPROVE_OPTION) {
            File file = abrirArchivo.getSelectedFile();
            JOptionPane.showMessageDialog(null,"Abrir esta en construccion. El archivo seleccionado es:  "+file.getName() );
		}	
	}
	public void salvar(){
		salvar= new JFileChooser();
		int desicion = salvar.showSaveDialog(this);
		if (desicion == JFileChooser.APPROVE_OPTION) {
            File file = salvar.getSelectedFile();
            JOptionPane.showMessageDialog(null,"Guardar esta en construccion. El archivo seleccionado es:  "+file.getName() );
		}	
	}
	
	private void elementosPanelJugadores(){
		panelJugadores= new JPanel();
		panelJugadores.setBorder(BorderFactory.createEmptyBorder(10,320,10,320));
		panelJugadores.setLayout(new GridLayout(1,4,7,7));
		jugador1= new JLabel(nombreJugador1,JLabel.CENTER);
		jugador1.setForeground(color1);
		jugador2= new JLabel(nombreJugador2,JLabel.CENTER);
		jugador2.setForeground(color2);
		puntaje1= new JTextField("0");
		puntaje1.setEditable(false);
		puntaje2= new JTextField("0");
		puntaje2.setEditable(false);
		panelJugadores.add(jugador1);
		panelJugadores.add(puntaje1);
		panelJugadores.add(jugador2);
		panelJugadores.add(puntaje2);
		add(panelJugadores, BorderLayout.NORTH);
	}
	private void elementosPanelTablero(){
		panelTablero= new JPanel();
		panelTablero.setLayout(new BorderLayout(10,10));
		tablero= new JPanel();
		tablero.setBorder(BorderFactory.createEmptyBorder(5,300,5,300));
		tablero.setLayout(new GridLayout(filas,columnas,1,1));
		refresque();
		panelTablero.add(tablero);
		add(panelTablero,BorderLayout.CENTER);
	}
	private void elementosPanelBotones(){
		panelBotones= new JPanel();
		panelBotones.setLayout(new GridLayout(1,3,3,3));
		panelBotones.setBorder(BorderFactory.createEmptyBorder(5,100,5,100));
		modificar =new JButton("Modificar Jugadores");
		redimensionar=new JButton("Modificar Tablero");
		reiniciar=new JButton("Reiniciar Juego");
		panelBotones.add(modificar);
		panelBotones.add(redimensionar);
		panelBotones.add(reiniciar);
		add(panelBotones,BorderLayout.SOUTH);
		
	}
	private void refresque(){
		botones = new ArrayList<JButton>();
		for(int j=0;j<columnas;j++)
			for (int i=0;i<filas;i++){
				JButton boton=new JButton();
				tablero.add(boton);
				botones.add(boton);
		}
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


