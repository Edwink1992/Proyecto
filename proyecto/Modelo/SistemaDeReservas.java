package Modelo;

import java.util.List;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


/**
 * Sistema de reserva es donde se ejecuta toda la aplicacion.
 *
 * @author Edwin Camargo
 * @versión 2017
 */

public class SistemaDeReservas {
    
    //Lista de objetos contenedor con el nombre de contenedores.
    private List<Contenedor> contenedores;

    public static void main(String[] args) {
        //cargar base de datos......................
        Configuration config= new Configuration();
        config.addAnnotatedClass(Cliente.class);
        config.addAnnotatedClass(Usuario.class);
        config.addAnnotatedClass(Contenedor.class);
        config.addAnnotatedClass(Lugar.class);
        config.addAnnotatedClass(Plaza.class);
        config.addAnnotatedClass(Reserva.class);
       
        config.configure("hibernate.cfg.xml");
        new SchemaExport(config).create(true, true);
        
        
      /**String option = JOptionPane.showInputDialog("Escoja un rol"+"\n"+"1) Cliente \n "+"2) Usuario");
        
        if(option.equals("1")){//entra como cliente
            JOptionPane.showMessageDialog(null, "bienvenido cliente");
        }
        else{//entra como usuario
            JOptionPane.showMessageDialog(null, "bienvenido usuario");
        };
        */
        
    }

}


