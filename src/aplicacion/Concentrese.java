package aplicacion;
import java.util.*;

/** 
*Clase Concentrese
**/
public class Concentrese {
    Jugador jugador1;
    Jugador jugador2;
    Partida partida;
     /**
    *Constructor de Concentrese
    **/
    public Concentrese(){
        jugador1=new Jugador("Pardo");
        jugador2=new Jugador("Vaca");
        partida=new Partida(jugador1,jugador2);
    }
    /**
    *Permite al jugador en turno escoger un par de figuras y valida si estas son iguales o no ,si lo son aumenta el puntaje
    *@param String ficha1
    *@param String ficha2
    *@return boolean respuesta 
    **/
    public boolean escoger(String ficha1,String ficha2){
        return partida.escoger(ficha1,ficha2);
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
