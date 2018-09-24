package Modelo;


import java.util.List;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Session;
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
        //new SchemaExport(config).create(true, true);
        
        OperacionesDAO opr= new OperacionesDAO();
//        opr.obtenNombres();
//        opr.obtenNombresYApellidos();
          opr.buscaUsuario();
        
        
        
//        Session session = NewHibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        
//        
// 
////       // Add new Usuario object
////        Usuario usr = new Usuario();
////        usr.setCedulaUsuario(1098756741);
////        usr.setNombre("Lucas");
////        usr.setApellido("Hernandez");
////        usr.setTelefono("3178541285");
////        session.save(usr);
////        
////         // Add new Usuario1 object
////        Usuario usr1 = new Usuario();
////        usr1.setCedulaUsuario(1098778956);
////        usr1.setNombre("Juan");
////        usr1.setApellido("Perez");
////        usr1.setTelefono("3115274896");
////        session.save(usr1);
////        
////        // Add new Usuario2 object
////        Usuario usr2 = new Usuario();
////        usr2.setCedulaUsuario(1095841256);
////        usr2.setNombre("Pablo");
////        usr2.setApellido("Torres");
////        usr2.setTelefono("3104578942");
////        session.save(usr2);
////        
////        // Add new Cliente object
////        Cliente cli = new Cliente();
////        cli.setCedulaCliente(5874124);
////        cli.setNombre("Ramiro");
////        cli.setApellido1("Gonzalez");
////        cli.setApellido2("Miranda");
////        cli.setTelefono("6408745");
////        cli.setDireccion("calle10");
////        cli.setCorreo("ramigo@hotmail.com");
////        session.save(cli);
////
////        // Add new Cliente1 object
////        Cliente cli1 = new Cliente();
////        cli1.setCedulaCliente(5568741);
////        cli1.setNombre("Pedro");
////        cli1.setApellido1("Ortiz");
////        cli1.setApellido2("Muñoz");
////        cli1.setTelefono("6748562");
////        cli1.setDireccion("calle20");
////        cli1.setCorreo("pedro@hotmail.com");
////        session.save(cli1);
////      
////        // Add new Cliente2 object
////        Cliente cli2 = new Cliente();
////        cli2.setCedulaCliente(5841562);
////        cli2.setNombre("Frank");
////        cli2.setApellido1("Oviedo");
////        cli2.setApellido2("Gimenez");
////        cli2.setTelefono("3114578458");
////        cli2.setDireccion("Carrera16");
////        cli2.setCorreo("franko@hotmail.com"); 
////        session.save(cli2);
//
//     
//          
//          
//          
//          
//          
//           
//       
//        session.getTransaction().commit();
//        NewHibernateUtil.shutdown();
        
        
        
        
       
        

        
       
        
        
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


