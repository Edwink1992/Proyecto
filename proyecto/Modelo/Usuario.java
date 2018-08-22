package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * El usuario es quien realiza y usa la reserva
 * @author Edwin Camargo 
 * @version 2017 
*/
@Entity
@Table(name = "USUARIO", uniqueConstraints = {
@UniqueConstraint(columnNames = "CedulaUsuario")})
public class Usuario implements Serializable{  
    
//atributos de la clase Usuario 
    @Id
    @Column(name = "CedulaUsuario", nullable = false)
    private int cedulaUsuario; // numero de cedulaUsuario del Usuario.
    @Column(name="Nombre")
    private String nombre; // nombre del usuario sin apellidos
    @Column(name="Apellido")
    private String apellido; // apellido del usuario
    @Column(name="Telefono")
    private int telefono; // telefono o celular del Usuario
 
    

/**
* Constructor,se crea un objeto Usuario sin parametros
*/  
    public Usuario() {
    }

    public Usuario(int cedulaUsuario, String nombre, String apellido, int telefono) {
        this.cedulaUsuario = cedulaUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
    
    

//Metodos GET Y SET de los atributos

    public int getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(int cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }  
}

