package aplicacion;
import java.util.*;
public class Partida{
    String ficha1;
    String ficha2;
    int puntaje1;
    int puntaje2;
    ArrayList<Jugador> jugadores;
    Jugador turno;
    public Partida(Jugador jugador1,Jugador jugador2){
        ficha1=null;
        ficha2=null;
        puntaje1=0;
        puntaje2=0;
        jugadores=new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        turno=jugador1;
    }
    public boolean escoger(String ficha1,String ficha2){
        boolean correcto=false;
        if (ficha1==ficha2){
            correcto=true;
            turno.aumentaPuntaje();
            int index=jugadores.indexOf(turno);
            if (index==0)turno=jugadores.get(1);
            else turno=jugadores.get(0);
        }
        return correcto;
    }
    public Jugador ganador(){
        return(jugadores.get(0).getPuntaje()>jugadores.get(1).getPuntaje()?jugadores.get(0):jugadores.get(1));
    }
    public void cambiarNombre(String nuevoNombre,int numero){
        jugadores.get(numero-1).setNombre(nuevoNombre);
    }
    public String[] nombres(){
        String[] nombres={jugadores.get(0).getNombre(),jugadores.get(1).getNombre()};
        return nombres;
    }
}
