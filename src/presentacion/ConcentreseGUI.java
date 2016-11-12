package presentacion;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.net.URL;
import aplicacion.*;
public class ConcentreseGUI extends JFrame{
	private Concentrese concentrese;
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
	private ArrayList<JButton> elegidos;
	private JButton ficha1;
	private HashMap<Integer,String> imagenes;
	private ArrayList<JButton> botonesElegir;
	
	//Elementos Botones
	private JButton reiniciar;
	private JButton modificar;
	private JButton redimensionar;
	
	//Elementos modificar
	private JColorChooser cambiarColores;
	
	private ConcentreseGUI(){
		prepareElementos();
		prepareAcciones	();
		concentrese= new Concentrese();
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
		modificar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						modificar();
					}
				}	
			);
		for(JButton i:botones){
			i.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						jugando(i);
					}
				}
			);

		};
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
	
	public void modificar(){
		cambiarColores= new JColorChooser();
		String[] options={"Pardo","Vaca","Cancelar"};
		int desicion = JOptionPane.showOptionDialog(null, "Cual jugador desea modificar ?","Elige una opcion",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,null); 
		if (desicion ==0){ 
			Color originalColor=color1;
			color1=cambiarColores.showDialog(null,"selecione un color",Color.gray);
			if(color1==null)color1=originalColor;
			if (!color1.equals(color2)){
				jugador1.setForeground(color1);
			}else{
				JOptionPane.showMessageDialog(null,"El jugador "+nombreJugador2+" ya tiene asignado este color");
			}
		}else if(desicion==1){
			Color originalColor=color1;
			color2=cambiarColores.showDialog(null,"selecione un color",Color.gray);
			if(color1==null)color1=originalColor;			
			if (!color1.equals(color2)){
				jugador2.setForeground(color2);
			}else{
				JOptionPane.showMessageDialog(null,"El jugador "+nombreJugador1+" ya tiene asignado este color");
			}
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
		imagenes();
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
		elegidos= new ArrayList<JButton>();
		botones = new ArrayList<JButton>();
		botonesElegir= new ArrayList<JButton>();
		for(int j=0;j<columnas;j++)
			for (int i=0;i<filas;i++){
				JButton boton=new JButton();
				tablero.add(boton);
				botones.add(boton);
				botonesElegir.add(boton);
		}
	}
	private void imagenes(){
		Random rnd = new Random();
		imagenes =new HashMap<Integer,String>();
		for (int i=0;i<(filas*columnas/2);i++){
			int indice=(int) (rnd.nextDouble() * (botonesElegir.size()-1));
			imagenes.put(botones.indexOf(botonesElegir.get(indice)),"imagenes/"+Integer.toString(i)+".jpg");
			botonesElegir.remove(indice);
			indice=(int) (rnd.nextDouble() * (botonesElegir.size()-1));
			imagenes.put(botones.indexOf(botonesElegir.get(indice)),"imagenes/"+Integer.toString(i)+".jpg");
			botonesElegir.remove(indice);
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
	private void jugando(JButton i){ 
		if (!elegidos.contains(i)&&ficha1!=i){
			JLabel panel=new JLabel();
			ImageIcon icono=new ImageIcon(imagenes.get(botones.indexOf(i)));
			panel.setIcon(icono);
			i.add(panel);
			String nombreTurno=concentrese.turno();
			if (nombreTurno==nombreJugador1){
				i.setBackground(color1);
			}else{
				i.setBackground(color2);
			}
			if (concentrese.existeFicha1()){
				concentrese.tomarFicha2(imagenes.get(botones.indexOf(i)));
				if(!concentrese.ok){
					ficha1.removeAll();
					ficha1.setBackground(null);
					i.removeAll();	
					i.setBackground(null);
				}else{
					puntaje1.setText(Integer.toString(concentrese.puntajes()[0]));
					puntaje1.setEditable(false);
					puntaje2.setText(Integer.toString(concentrese.puntajes()[1]));
					puntaje2.setEditable(false);
					botones.remove(ficha1);
					botones.remove(i);
					elegidos.add(ficha1);
					elegidos.add(i);
				}
			}else{
				concentrese.tomarFicha1(imagenes.get(botones.indexOf(i)))	;
				ficha1=i;
			}
		}else if(ficha1==i){
			
		}
	}
}


