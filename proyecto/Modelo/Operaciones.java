package Modelo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 *
 * @author EdwinK
 */
public class Operaciones {
    
    private Session sesion;
    
    private void iniciaOperacion(){
        
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
        configuration.getProperties()).build();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);
        sesion = sessionFactory.openSession();
        sesion.getTransaction().begin();
    }
        
    private void terminaOperacion(){
        
        sesion.getTransaction().commit();
        sesion.close();
    }
    
    public int guardaUsuario(Usuario usuario){
        
        int cedulaUsuario = 0;
        iniciaOperacion();
        cedulaUsuario=(int)sesion.save(usuario);
        terminaOperacion();
        
        return cedulaUsuario;
    }   
    
    public void actualizaUsuario(Usuario usuario){
        
        iniciaOperacion();
        sesion.update(usuario);
        terminaOperacion();
    }
    
    public void eliminaUsuario(Usuario usuario){
        
        iniciaOperacion();
        sesion.delete(usuario);
        terminaOperacion();
    }
    
    public Usuario obtenUsuario(int cedulaUsuario){
        
        Usuario usuario= null;
        
        iniciaOperacion();
        usuario =(Usuario)sesion.get(Usuario.class, cedulaUsuario);
        terminaOperacion();
        
        return usuario;
    }
    
    public List<Usuario> listadeUsuario(){
        
       List<Usuario> listaUsuario = null;
       iniciaOperacion();
       listaUsuario=sesion.createQuery("from Usuario").list();
       terminaOperacion();
       
       return listaUsuario;
        
    }
    
    
    
}
