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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Reserva  es donde se hace la reserva de las plazas
 * @author Edwin Camargo 
 * @versión 2017 
*/

@Entity
@Table(name = "RESERVA", uniqueConstraints = {
@UniqueConstraint(columnNames = "IdReserva")})
public class Reserva implements Serializable {
    
 //atributos de la clase Reserva   
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "IdReserva", nullable = false)
    private int idReserva; // Identificador de la reserva
    @ManyToOne
    @JoinColumn(name="IdPlaza", nullable=false)
    private Plaza plaza; // plaza o plazas a reservar.
    @ManyToOne
    @JoinColumn(name="CedulaCliente", nullable=false)
    private Cliente cliente; // Quien adquiere la reserva 
    @Column(name="Fecha",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha; // fecha y hora en que se realizo la reserva
    @Column(name="FechaInicio",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name="FechaFinal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;
    @Column(name="Valor")
    private double valor; // valor que tiene la reserva
    @Column(name="Estado")
    private boolean estado; // estado de la reserva true=activa y false=cancelada.
    
 /**
 * Constructor,se crea un objeto Reserva sin parametros
 */     
    public Reserva(){
    }

    public Reserva(int idReserva, Plaza plaza, Cliente cliente, Date fecha, Date fechaInicio, Date fechaFinal, double valor, boolean estado) {
        this.idReserva = idReserva;
        this.plaza = plaza;
        this.cliente = cliente;
        this.fecha = fecha;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.valor = valor;
        this.estado = estado;
    }
 
  public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Plaza getPlaza() {
        return plaza;
    }

    public void setPlaza(Plaza plaza) {
        this.plaza = plaza;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isEstado() {
        return estado;
    }

    // Metodos GET y SET de los atributos
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    // Fin de los metodos GET y SET
    // Inicio de los metodos de la clase Reserva
    /**
     * confirmar reserva
     */
    public void confirmarReserva() {
    }
  
  /** 
  * Cancelar reserva
  */ 
  public void cancelarReserva(int x) {
   }

  /** 
  * Modificar reserva
  */ 
  public void modificarReserva(int x) {
   }
  
  /** 
  * Buscar reserva
  */ 
  public void buscarReserva(int x) {
   }
 //Fin de los metodos de la clase Reserva
  
}

