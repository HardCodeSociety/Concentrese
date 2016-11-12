package aplicacion;
import java.util.*;

/** 
*Clase Concentrese
**/
public class Concentrese {
    private Jugador jugador1;
    private Jugador jugador2;
    private String ficha1;
    private String ficha2;
    private Partida partida;
    public boolean ok;
     /**
    *Constructor de Concentrese
    **/
    public Concentrese(){
        jugador1=new Jugador("Pardo");
        jugador2=new Jugador("Vaca");
        partida=new Partida(jugador1,jugador2);
        ficha1=null;
        ficha2=null;
        ok=false;
    }
    public void tomarFicha1(String nombreFicha){
        ficha1=nombreFicha;
    }
    public void tomarFicha2(String nombreFicha){
        if (ficha1!=null)
            ficha2=nombreFicha;
            escoger();
    }
    public boolean existeFicha1(){
        return(ficha1!=null?true:false);
    }
    /**
    *Permite al jugador en turno escoger un par de figuras y valida si estas son iguales o no ,si lo son aumenta el puntaje
    *@param String ficha1
    *@param String ficha2
    *@return boolean respuesta 
    **/
    private void escoger(){
         partida.escoger(ficha1,ficha2);
         ficha1=null;
         ficha2=null;
         this.ok=partida.ok;
    }
     /**
    *Revela el jugador ganador en el momento
    *@return Jugador
    **/
    public Jugador ganador(){
        return partida.ganador();
    }
    /**
    *Permite cambiar el nombre de un jugador dado su nombre y numero
    *@param String nuevoNombre
    *@param int numero
    **/
    public void cambiarNombre(String nuevoNombre,int numero){
        partida.cambiarNombre(nuevoNombre,numero);
    }
     /**
    *Retorna los nombres de los jugadores en una lista 
    *@return String[]
    **/
    public String[] nombres(){
        return partida.nombres();
    }
    /**Retorna el nombre del jugador en turno
    *@return String
    **/
    public String turno(){
        return partida.turno();
    }
    /**Retorna los puntajes de los jugadores en Partida
    *@return int[]
    **/
    public int[] puntajes(){
        return partida.puntajes();
    }
}
