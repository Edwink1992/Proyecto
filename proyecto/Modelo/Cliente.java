package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CLIENTE", uniqueConstraints = {
@UniqueConstraint(columnNames = "CedulaCliente")})
public class Cliente implements Serializable {
       
//atributos de la clase Usuario 
    @Id
    @Column(name = "CedulaCliente", nullable = false)
    private int cedulaCliente; // numero de cedulaUsuario del Usuario.
    
    private String nombre; // nombre del usuario sin apellidos
    @Column(name="Apellido")
    private String apellido; // apellido del usuario
    @Column(name="Telefono")
    private int telefono; // telefono o celular del Usuario
    @Column(name="Direccion")
    private String direccion; // direccion de residencia del Usuario
    @Column(name="Correo")
    private String correo; // Correo electronico del Usuario

/**
* Constructor,se crea un objeto Usuario sin parametros
*/ 
    public Cliente() {
    }

    public Cliente(int cedulaCliente, String nombre, String apellido, int telefono, String direccion, String correo) {
        this.cedulaCliente = cedulaCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    public int getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(int cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    


    
    
    
}
