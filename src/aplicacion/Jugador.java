package aplicacion;
import java.util.*;
/**
*Clase Jugador 
**/
public class Jugador{
    private String nombre;
    private int puntaje;
    /**
    *Creador de objeto de la clase Jugador
    **/
    public Jugador(String nombre){
        this.nombre=nombre;
        puntaje=0;
    }
    /**
    *Permite cambiar el nombre del Jugador
    *@param String nuevo nombre
    **/
    public void setNombre(String nuevoNombre){
        if(nuevoNombre!=nombre){
            nombre=nuevoNombre;
        }
    }
    /**
    *Retorna el nombre del Jugador
    *@return String nombre
    **/ 
    public String getNombre(){
        return nombre;
    }
    /**
    *Aumenta el puntaje del jugador en uno
    **/
    public void aumentaPuntaje(){
        puntaje+=1;
    }
    /**
    *Retorna el puntaje del jugador
    **/
    public int getPuntaje(){
        return puntaje;
    }
}