package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Plaza es la clase que esta dentro de los lugares creados.
 *
 * @author Edwin Camargo
 * @version 2017
 */
@Entity
@Table(name = "PLAZA", uniqueConstraints = {
@UniqueConstraint(columnNames = "IdPlaza")})
public class Plaza implements Serializable {
 // Atributos de la clase Plaza
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idPlaza;
    @ManyToOne
    @JoinColumn(name="IdLugar", nullable=false)
    private Lugar lugar;
    @Column(name="Numero")
    private int numero; // numero que tendraa cada plaza en un lugar[1-...]
    @Column(name="Precio")
    private double precio; // precio que tiene la reserva por unidad de tiempo.
    @Column(name="Estado")
    private boolean estado; // true = disponible y false= ocupado.
    private static int x = 0;
   
    
  /**
  * Constructor,se crea un objeto Plaza sin parametros
  */    
    public Plaza(){
    }

  /**
  * Constructor,se crea un objeto Plaza con parametros
  *
  * @param numero el numero irrepetible que tendra cada plaza creada.
  */
    public Plaza(Lugar lugar,int numero) {
        this.lugar= lugar;
        this.numero = numero;
        estado = true;
        x++;
    }
    
 // Metodos GET Y SET de los atributos
    
    public int getIdPlaza() {
        return idPlaza;
    }

    public void setIdPlaza(int idPlaza) {
        this.idPlaza = idPlaza;
    }
    
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean getEstado() {
        return estado;
    }


    public void setEstado(boolean estado) {    
        this.estado = estado;
    }
 // Fin de los metodos GET y SET
    
 //Inicio de los metodos de la clase Plaza
    
  /**
  * Es el numero de plazas que tendra un lugar.
  */
    public void numeroPlazas() {
        System.out.println("Plaza creada: " + x);
    }
    
  /**
  * Es la disponibilidad que tendra cada plaza
  * @param fecha es la fecha y hora de disponibilidad de la plaza
  */
    public boolean disponibilidad(Date fecha) {
       return true; 
    }
    
  /**
  * Reservar una plaza
  * @param fecha es la fecha y hora para reservar una plaza
  */
    public boolean reservar (Date fecha){    
       return true;
    }
  //Fin de los metodos de la clase Plaza  
}



