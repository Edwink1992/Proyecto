package Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Lugar es la clase conformada por una fila y varias columnas en las cuales se agregaran plazas.
 *
 * @author Edwin Camargo
 * @version 2017
 */
@Entity
@Table(name = "LUGAR", uniqueConstraints = {
@UniqueConstraint(columnNames = "IdLugar")})
public class Lugar implements Serializable {
 // Atributos de la clase Lugar  
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "IdLugar", nullable = false)
    private int idLugar;
    @ManyToOne
    @JoinColumn(name="IdContenedor", nullable=false)
    private Contenedor contenedor;
    @Column(name="Letra")
    private char letra; // letra es el nombre que tendra cada lugar[A-Z]
    @Column(name="CantidadPlazas")
    private int cantidadPlazas; // Cantidad de plazas que tendra el lugar.
    private int numero = 1; // Numero es el nombre que tendra cada plaza en un lugar y que inicia desde 1.
    @OneToMany(mappedBy="lugar")
    private List<Plaza> plazas; // Lista de objetos Plaza con el nombre de plazas.
   
  /**
  * Constructor,se crea un objeto Lugar sin parametros
  */ 
    public Lugar (){
    }
  
  /**
  * Constructor,se crea un objeto Lugar con parametros
  *
  * @param letra La letra irrepetible que tendra cada lugar creado
  */
    public Lugar( Contenedor contenedor,char letra) {
        this.contenedor = contenedor;
        this.letra = letra; 
        ///////////insercion en la base de datos
    }

  //Metodos GET Y SET de los atributos
    
    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }
    
    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getCantidadPlazas() {
        return cantidadPlazas;
    }

    public void setCantidadPlazas(int cantidadPlazas) {
        this.cantidadPlazas = cantidadPlazas;
    }
  // Fin de los metodos GET Y SET
    
  //Inicio de los metodos de la clase Lugar    
    
  /**
  * Permite crear Plazas de una en una.
  */
    public boolean crearPlaza() {
        Plaza plaza1 = new Plaza(this,this.numero);
        plazas.add(plaza1);
        numero++;
        return true;
    }

  /**
  * Permite crear todas las plazas que desee
  *  @param nplaza El nplaza es el numero de plazas que quiere crear.
  */
    public void crearPlazas(int nplaza) {
        for (int i = 0; i < nplaza; i++) {
            Plaza plaza1 = new Plaza(this,this.numero);
            plazas.add(plaza1);
            numero++;
        }
    }

    public void testCrearPlazas(Plaza nplaza) {
            plazas.add(nplaza);
            numero++;
    }
    
  /**
  * Es el numero de plazas creadas en un lugar.
  */
    public void numeroPlazas() {
        System.out.println("numero de plazas " + plazas.size());
    }

  /**
  * Crear Plaza es donde se añaden las plazas.
  *
  * @param plaza que indica la plaza a obtener.
  */
    public Plaza obtenerPlaza(int plaza) {
        return plazas.get(plaza);
    }

  /**
  * eliminar Plaza es donde se eliminan las plazas.
  *
  * @param plaza que indica la plaza a eliminar.
  */
    public boolean eliminarPlaza(int plaza) {
        plazas.remove(plaza);
        return true;
    }
 
  /**
  * consultar Plaza es donde se obtiene informacion de la plaza.
  *
  * @param posicion que indica el numero de la plaza a consultar
  * @param fecha que indica la fecha con hora de la plaza a consultar
  */   
    public void consultarPlaza(int posicion,Date fecha){  
      Plaza x=(Plaza)plazas.get(posicion);
       if(x.disponibilidad(fecha)){
        System.out.println("la plaza esta disponible ");
        //realizamos la reserva
       }else {
        System.out.println("la plaza no esta disponible ");
        //notificar o hacer algo si no se pudo hacer la reserva 
       }
    }

  /**
  * Reservar Plaza es donde se reserva la plaza deseada o disponible.
  *
  * @param posicion que indica el numero de la plaza a reservar
  * @param fecha que indica la fecha de la plaza a reservar
  */     
    public boolean ReservarPlaza(int posicion,Date fecha){
     Plaza p= (Plaza)plazas.get(posicion);       
      if(p.disponibilidad(fecha)){
       return p.reservar(fecha);
      }else {
       return false;
      }
    }
   
  
  // Fin de los metodos de la clase Lugar
}


