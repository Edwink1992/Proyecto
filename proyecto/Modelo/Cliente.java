package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CLIENTE", uniqueConstraints = {
@UniqueConstraint(columnNames = "CedulaCliente")})
public class Cliente implements Serializable {
       
//atributos de la clase Usuario 
    @Id
    @Column(name = "CedulaCliente", nullable = false,length = 30)
    private int cedulaCliente; // numero de cedulaUsuario del Usuario.
    @Column(name="Nombre",nullable = false, length = 100)
    private String nombre; // nombre del usuario sin apellidos
    @Column(name="Apellido1",nullable = false, length = 100)
    private String apellido1; // apellido1 del usuario
    @Column(name="Apellido2", length = 100)
    private String apellido2; // apellido2 del usuario
    @Column(name="Telefono",length = 100)
    private String telefono; // telefono o celular del Usuario
    @Column(name="Direccion",length = 100)
    private String direccion; // direccion de residencia del Usuario
    @Column(name="Correo",length = 50)
    private String correo; // Correo electronico del Usuario

/**
* Constructor,se crea un objeto Usuario sin parametros
*/ 
    public Cliente() {
    }

    public Cliente(int cedulaCliente, String nombre, String apellido1,String apellido2, String telefono, String direccion, String correo) {
        this.cedulaCliente = cedulaCliente;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido1 = apellido1;
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

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
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
