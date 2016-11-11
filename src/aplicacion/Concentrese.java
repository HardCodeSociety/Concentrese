package aplicacion;
import java.util.*;

/**
 * name
 */
public class Concentrese {
    Jugador jugador1;
    Jugador jugador2;
    Partida partida;
    public Concentrese(){
        jugador1=new Jugador("Pardo");
        jugador2=new Jugador("Vaca");
        partida=new Partida(jugador1,jugador2);
    }
    public boolean escoger(String ficha1,String ficha2){
        return partida.escoger(ficha1,ficha2);
    }
    public Jugador ganador(){
        return partida.ganador();
    }
    public void cambiarNombre(String nuevoNombre,int numero){
        partida.cambiarNombre(nuevoNombre,numero);
    }
    public String[] nombres(){
        return partida.nombres();
    }
}
