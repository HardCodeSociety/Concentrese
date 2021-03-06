package aplicacion;
import java.util.*;
/** 
*Clase Partida
**/
public class Partida{
    private ArrayList<Jugador> jugadores;
    private Jugador turno;
    public boolean ok;

    /**
    *Constructor de Partida
    **/
    public Partida(Jugador jugador1,Jugador jugador2){
        jugadores=new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        turno=jugador1;
        ok=false;
    }
    /**
    *Permite al jugador en turno escoger un par de figuras y valida si estas son iguales o no ,si lo son aumenta el puntaje
    *@param String ficha1
    *@param String ficha2
    *@return boolean respuesta 
    **/
    public void escoger(String ficha1,String ficha2){
        if (ficha1.equals(ficha2)){
            turno.aumentaPuntaje();
            ok=true;
        }else ok=false;
        int index=jugadores.indexOf(turno);
        if (index==0)turno=jugadores.get(1);
        else turno=jugadores.get(0);
        ficha1=null;
        ficha2=null;
    }
    /**
    *Revela el jugador ganador en el momento
    *@return Jugador
    **/
    public Jugador ganador(){
        Jugador ganador;
        if(jugadores.get(0).getPuntaje()>jugadores.get(1).getPuntaje())
            ganador=jugadores.get(0);
        else if (jugadores.get(0).getPuntaje()<jugadores.get(1).getPuntaje())
            ganador=jugadores.get(1);
        else ganador=null;
        return ganador;
    }
    /**
    *Permite cambiar el nombre de un jugador dado su nombre y numero
    *@param String nuevoNombre
    *@param int numero
    **/
    public void cambiarNombre(String nuevoNombre,int numero){
        String[] nombresActuales=nombres();
        if (nuevoNombre!=nombresActuales[0]&&nuevoNombre!=nombresActuales[1])
        jugadores.get(numero-1).setNombre(nuevoNombre);
    }
    /**
    *Retorna los nombres de los jugadores en una lista 
    *@return String[]
    **/
    public String[] nombres(){
        String[] nombres={jugadores.get(0).getNombre(),jugadores.get(1).getNombre()};
        return nombres;
    }
    /**Retorna el nombre del jugador en turno
    *@return String
    **/
    public String turno(){
        return turno.getNombre();
    }
    /**Retorna los puntajes de los jugadores en Partida
    *@return int[]
    **/
    public int[] puntajes(){
        int[] puntajes={jugadores.get(0).getPuntaje(),jugadores.get(1).getPuntaje()};
        return puntajes;
    }
}
