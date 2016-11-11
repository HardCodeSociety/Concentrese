package pruebas;

import aplicacion.*;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * Test para la clase jugador
 */
public class JugadorTest {

    public  JugadorTest () {       
    }
    @Test
    public void deberiaCrearUnJugador(){
        String nombre="Felipe";
        Jugador nuevoJugador=new Jugador(nombre);
        assertEquals("No es el nombre",nombre,nuevoJugador.getNombre());
        assertEquals("No es el puntaje",0,nuevoJugador.getPuntaje());
    }
    @Test
    public void deberiaCambiarElNombreDeUnJugador(){
        String nombre="Felipe";
        Jugador nuevoJugador=new Jugador(nombre);
        assertEquals("No es el nombre",nombre,nuevoJugador.getNombre());
        nuevoJugador.setNombre("David");
        nombre="David";
        assertEquals("No es el nombre",nombre,nuevoJugador.getNombre());
    }
    @Test
    public void deberiaRetornarElNombreDeUnJugador(){
        String nombre="Felipe";
        Jugador nuevoJugador=new Jugador(nombre);
        assertEquals("No es el nombre",nombre,nuevoJugador.getNombre());
    }
    @Test
    public void deberiaAumentarElPuntajeDeUnJugador(){
        String nombre="Felipe";
        Jugador nuevoJugador=new Jugador(nombre);
        nuevoJugador.aumentaPuntaje();
        assertEquals("No es el puntaje",1,nuevoJugador.getPuntaje());
    }
    @Test
    public void deberiaRetornarElPuntajeDeUnJugador(){
        String nombre="Felipe";
        Jugador nuevoJugador=new Jugador(nombre);
        assertEquals("No es el puntaje",0,nuevoJugador.getPuntaje());
    }
}