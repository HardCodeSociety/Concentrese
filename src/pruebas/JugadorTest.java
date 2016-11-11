package pruebas;

import aplicacion.*;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * Test para la clase Jugador
 */
public class JugadorTest {

    public  public JugadorTest () {       
    }
    @Test
    public void deberiaCrearUnJugador(){
        String nombre="Felipe";
        Jugador nuevoJugador=new Jugador(nombre);
        AssertEquals("No es el nombre",nombre,nuevoJugador.getNombre());
    }
}