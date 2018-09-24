package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Contenedor permite crear cualquier espacio que se desee como (Salas de cine,
 * parqueaderos,habitaciones, etc)
 *
 * @author Edwin Camargo
 * @version 2017
*/
@Entity
@Table(name = "CONTENEDOR", uniqueConstraints = {
@UniqueConstraint(columnNames = "IdContenedor")})
public class Contenedor implements Serializable {   
 //Atributos de la clase Contenedor
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "IdContenedor", nullable = false)
    private int idContenedor; // IdContenedor del espacio que lo diferencia de los demas.
    @ManyToOne
    @JoinColumn(name="CedulaUsuario", nullable=false)
    private Usuario usuario; // Quien adquiere la reserva
    @Column(name="Tipo",nullable = false, length = 100)
    private String tipo; // Genero es el tipo de espacio que se crea(salas de cine, parqueaderos...)
    @Column(name="Nombre", length = 50)
    private String nombre; // Nombre que le damos al espacio a crear
    @Column(name="Descripcion", length =500)
    private String descripcion; // Descripcion que tendra cada espacio creado.
    @Column(name="Capacidad",length = 10)
    private int capacidad; // Capacidad es el numero de plazas que tiene cada espacio creado.
    @OneToMany(mappedBy="contenedor",fetch=FetchType.LAZY)
    private List<Lugar> lugares;// Lista de objetos Lugar que tiene como nombre lugares.

  /**
  * Constructor,se crea un objecto contenedor sin parametros
  */
    public Contenedor() {
    }
    
    public Contenedor(int idContenedor, Usuario Usuario, String tipo, String nombre, String descripcion, int capacidad) {
        this.idContenedor = idContenedor;
        this.usuario = Usuario;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
    }

    public int getIdContenedor() {
        return idContenedor;
    }

    public void setIdContenedor(int idContenedor) {
        this.idContenedor = idContenedor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.usuario = Usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

 
 

    public List<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
    }

    
    // Fin de los metodos GET Y SET de los atributos
    // Inicio de los metodos de la clase Contenedor
    /**
     * Permite crear lugares de uno en uno.
     */
    public void crearLugar() {
        Lugar lugar1 = new Lugar(this);
        lugares.add(lugar1);
         
    }

  /**
  * Permite crear todos los lugares que desee.
  * @param nlugar El nlugar es el numero de lugares que quiere crear.
  */
    public void crearLugares(int nlugar) {
        for (int i = 0; i < nlugar; i++) {
           Lugar lugar1 = new Lugar(this);
           lugares.add(lugar1);
           
        }
       System.out.println("fueron creados: "+ nlugar + " lugares");
    }

  /**
  * Obtiene el lugar de acuerdo al lugar ingresado.
  *
  * @param nlugar que indica el lugar a obtener.
  * @return el lugar ingresado.
  */
    public Lugar obtenerLugar(int nlugar) {
       Lugar lugar2= null;
       try{
           lugar2 = (Lugar)lugares.get(nlugar);
        } catch(Exception e){
            
           System.out.println("Error al obtener el lugar:"+ nlugar );
        }
     
       return lugar2;
    }

  /**
  * Numero de lugares creados
  */
    public void numeroLugares() {
       System.out.println("Numero de lugares creados: " + lugares.size());
    }

  /**
  * Guardar lugar creado
  */
    public void guardarLugar() {

    }

  /**
  * Elimina el lugar deacuerdo al lugar ingresado.
  *
  * @param idlugar que indica el lugar a eliminar.
  */
    public void eliminarLugar(int idlugar) {
        lugares.remove(idlugar);
        System.out.println("Lugar eliminado");
    }

   
  /**
  * Agrega una plaza de uno en uno
  *
  * @param nlugar El nlugar indica el lugar donde se quiere agregar la plaza.
  */
    public void agregarPlaza(int nlugar) {
       Lugar lugar3 = (Lugar) obtenerLugar(nlugar);
       if(lugar3 != null){
         if (lugar3.crearPlaza()) {
            System.out.println("Plaza agregada en el lugar seleccionado");
         } else {
            System.out.println("Error agregando la plaza");
         }
        }  else {
            System.out.println("Error agregando la plaza");
        }
    
    }

  /**
  * Agrega una o varias plazas al lugar creado
  * @param nlugar El nlugar indica el lugar donde se quiere agregar las plazas.
  * @param nplazas El nplazas indica el numero de plazas que se quieren agregar.
  */
    public void agregarPlazas(int nlugar, int nplazas) {
        Lugar lugar3 = (Lugar) obtenerLugar(nlugar);
        if(lugar3 != null){
         for (int i = 0; i < nplazas; i++) {
            if (lugar3.crearPlaza()) {
                System.out.println("Plazas agregadas en el lugar seleccionado");
            } else {
                System.out.println("error agregando las plazas");
            }
         }
       } else {
            System.out.println("error agregando las plazas");
       }
     }
    
 /* public void agregarPlazass(int nlugar, int nplazas) {
      Lugar lugar3 = (Lugar) obtenerLugar(nlugar);
      lugar3.crearPlazas(nplazas);
    } */

  /**
  * Obtener una plaza deacuerdo al lugar ingresado .
  *
  * @param nlugar que indica el lugar a obtener
  * @param nplaza que indica la plaza a obtener
  */
    public void obtenerPlaza(int nlugar, int nplaza) {
        Lugar lugar4 = (Lugar) obtenerLugar(nlugar);
        lugar4.crearPlaza();
        Plaza plaza1 = (Plaza) lugar4.obtenerPlaza(nplaza);
        plaza1.numeroPlazas();
    }

  /**
  * Guardar plaza agregada
  */
    public void guardarPlaza() {

    }

  /**
  * Eliminar una plaza deacuerdo al lugar ingresado.
  *
  * @param identificador La identificacion indica el espacio donde se quiere
  * eliminar las plazas
  * @param nlugar El nlugar es el numero del lugar donde se quiere eliminar una plaza
  * @param nplaza El nplaza es el numero de plaza a eliminar
  */
    public void eliminarPlaza(int identificador, int nlugar, int nplaza) {
        Lugar x = lugares.get(nlugar);
        x.eliminarPlaza(nplaza);
        System.out.println("Plaza eliminada");
    }

  /**
  * Mostrar algunas estadísticas del espacio
  */
    public void mostrarEstadisticas() {

    }
  // Fin de los metodos de la clase contenedor
}

