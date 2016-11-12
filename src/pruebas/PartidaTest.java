package pruebas;

import aplicacion.*;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * Test para la clase partida
 */
public class PartidaTest {

    public  PartidaTest () {       
    }
    @Test
    public void deberiaPermitirCrearUnaPartida(){
        Jugador pardo=new Jugador("Pardo");
        Jugador vaca=new Jugador("Vaca");
        Partida partida=new Partida(pardo,vaca);
        String[] jugadores={"Pardo","Vaca"};
        String[] resultado=partida.nombres();
        assertEquals("No esta Pardo",jugadores[0],resultado[0]);
        assertEquals("No esta Vaca",jugadores[1],resultado[1]);
        assertEquals("No existe el turno",jugadores[0],partida.turno());
    }
    @Test
    public void deberiaRetornarTrueSiLasFichaSonCorrectas(){
        Jugador pardo=new Jugador("Pardo");
        Jugador vaca=new Jugador("Vaca");
        Partida partida=new Partida(pardo,vaca);
        boolean respuesta=partida.escoger("casa","casa");
        assertTrue("Si son iguales",respuesta);
    }
    @Test
    public void deberiaRetornarFalseSiLasNoFichaSonCorrectas(){
        Jugador pardo=new Jugador("Pardo");
        Jugador vaca=new Jugador("Vaca");
        Partida partida=new Partida(pardo,vaca);
        boolean respuesta=partida.escoger("casa","carro");
        assertTrue("Si son iguales",!respuesta);
    }
    @Test
    public void deberiaCambiarDeTurnoDespuesDeCadaIntento(){
        Jugador pardo=new Jugador("Pardo");
        Jugador vaca=new Jugador("Vaca");
        Partida partida=new Partida(pardo,vaca);
        boolean respuesta=partida.escoger("casa","casa");
        assertEquals("No cambia turno","Vaca",partida.turno());
        respuesta=partida.escoger("casa","casa");
        assertEquals("No cambia turno","Pardo",partida.turno());
    }
    @Test
    public void deberiaAumentarPuntajeSiLaParejaEsCorrecta(){
        Jugador pardo=new Jugador("Pardo");
        Jugador vaca=new Jugador("Vaca");
        Partida partida=new Partida(pardo,vaca);
        boolean respuesta=partida.escoger("casa","casa");
        assertEquals("No aumenta puntaje",1,pardo.getPuntaje());
    }
    @Test
    public void NoDeberiaAumentarPuntajeSiLaParejaEsIncorrecta(){
        Jugador pardo=new Jugador("Pardo");
        Jugador vaca=new Jugador("Vaca");
        Partida partida=new Partida(pardo,vaca);
        boolean respuesta=partida.escoger("casa","carro");
        assertEquals(" aumenta puntaje",0,pardo.getPuntaje());
    }
    @Test
    public void deberiaRetornarElGanador(){
        Jugador pardo=new Jugador("Pardo");
        Jugador vaca=new Jugador("Vaca");
        Partida partida=new Partida(pardo,vaca);
        boolean respuesta=partida.escoger("casa","casa");
        assertEquals("No es el ganador",pardo,partida.ganador());
        respuesta=partida.escoger("casa","casa");
        respuesta=partida.escoger("perro","perro");
        assertEquals("No es el ganador","Vaca",partida.turno());
    }
    @Test
    public void deberiaRetornarNullEnCasoDeEmpate(){
        Jugador pardo=new Jugador("Pardo");
        Jugador vaca=new Jugador("Vaca");
        Partida partida=new Partida(pardo,vaca);
        boolean respuesta=partida.escoger("casa","casa");
        assertEquals("No es el ganador",pardo,partida.ganador());
        respuesta=partida.escoger("casa","casa");
        assertEquals("prueba",1,partida.puntajes()[0]);
        assertEquals("prueba",1,partida.puntajes()[1]);
        assertEquals("No es el ganador",null,partida.ganador());
    }
    @Test
    public void deberiaCambiarElNombreAUnJugador(){
        Jugador pardo=new Jugador("Pardo");
        Jugador vaca=new Jugador("Vaca");
        Partida partida=new Partida(pardo,vaca);
        partida.cambiarNombre("Andres",1);
        assertEquals("No cambia nombre","Andres",partida.nombres()[0]);
    }
    @Test
    public void deberiaRetornarElNombreDeLosJugadores(){
        Jugador pardo=new Jugador("Pardo");
        Jugador vaca=new Jugador("Vaca");
        Partida partida=new Partida(pardo,vaca);
        assertEquals("No cambia nombre","Pardo",partida.nombres()[0]);
        assertEquals("No cambia nombre","Vaca",partida.nombres()[1]);
    }
    @Test
    public void deberiaRetornarLosPuntajes(){
        Jugador pardo=new Jugador("Pardo");
        Jugador vaca=new Jugador("Vaca");
        Partida partida=new Partida(pardo,vaca);
        boolean respuesta=partida.escoger("casa","casa");
        assertEquals("No es el ganador",pardo,partida.ganador());
        assertEquals("prueba",1,partida.puntajes()[0]);
        assertEquals("prueba",0,partida.puntajes()[1]);  
    }
}