/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author EdwinK
 */
public class OperacionesDAO {

    private Session sesion;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        sesion = NewHibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException ex) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", ex);
    }
    
    private void terminaOperacion()
    {
        sesion.getTransaction().commit();
        sesion.close();
    }
    
    protected Session getSession()
    {
        return sesion;
    }

    public static void almacenaEntidad(Object entidad) throws HibernateException
    {
        OperacionesDAO dummy = new OperacionesDAO(){};

        try
        {
            dummy.iniciaOperacion();
            dummy.getSession().saveOrUpdate(entidad);
            dummy.getSession().flush();
        }
        catch (HibernateException he)
        {
            dummy.manejaExcepcion(he);
        }
        finally
        {
            dummy.terminaOperacion();
        }
    }

    public static <T> T getEntidad(Serializable id, Class<T> claseEntidad) throws HibernateException
    {
        OperacionesDAO dummy = new OperacionesDAO(){};

        T objetoRecuperado = null;

        try
        {
            dummy.iniciaOperacion();
            objetoRecuperado = (T) dummy.getSession().get(claseEntidad, id);
        }
        catch (HibernateException he)
        {
            dummy.manejaExcepcion(he);
        }
        finally
        {
            dummy.terminaOperacion();
        }

        return objetoRecuperado;
    }

    public static <T> List<T> getListaEntidades(Class<T> claseEntidad) throws HibernateException
    {
        OperacionesDAO dummy = new OperacionesDAO(){};

        List<T> listaResultado = null;

        try
        {
            dummy.iniciaOperacion();
            listaResultado = dummy.getSession().createQuery("FROM " + claseEntidad.getSimpleName()).list();
        }
        catch (HibernateException he)
        {
            dummy.manejaExcepcion(he);
        }
        finally
        {
            dummy.terminaOperacion();
        }

        return listaResultado;
    }


    //Crud tabla Usuario
    public int guardaUsuario(Usuario usuario) {

        int cedulaUsuario = 0;

        try {
            iniciaOperacion();
            cedulaUsuario = (int) sesion.save(usuario);
            tx.commit();
        } catch (HibernateException ex) {
            manejaExcepcion(ex);
            throw ex;
        } finally {
            sesion.close();
        }
        return cedulaUsuario;
    }

    public void actualizaUsuario(Usuario usuario) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.update(usuario);
            tx.commit();
        } catch (HibernateException ex) {
            manejaExcepcion(ex);
            throw ex;
        } finally {

            sesion.close();
        }
    }

    public void eliminaUsuario(Usuario usuario) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.delete(usuario);
            tx.commit();
        } catch (HibernateException ex) {
            manejaExcepcion(ex);
            throw ex;
        } finally {

            sesion.close();
        }
    }

    public Usuario obtenUsuario(int cedulaUsuario) throws HibernateException {

        Usuario usuario = null;

        try {
            iniciaOperacion();
            usuario = (Usuario) sesion.get(Usuario.class, cedulaUsuario);
        } finally {

            sesion.close();
        }
        return usuario;
    }

    public List<Usuario> listadeUsuario() {

        List<Usuario> listaUsuario = null;

        try {
            iniciaOperacion();
            listaUsuario = sesion.createQuery("from Usuario").list();
        } finally {

            sesion.close();
        }

        return listaUsuario;

    }

    //Crud tabla Contenedor
    public int guardaContenedor(Contenedor contenedor) {

        int idContenedor = 0;

        try {
            iniciaOperacion();
            idContenedor = (int) sesion.save(contenedor);
            tx.commit();
        } catch (HibernateException ex) {
            manejaExcepcion(ex);
            throw ex;
        } finally {
            sesion.close();
        }
        return idContenedor;
    }

    public void actualizaContenedor(Contenedor contenedor) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.update(contenedor);
            tx.commit();
        } catch (HibernateException ex) {
            manejaExcepcion(ex);
            throw ex;
        } finally {

            sesion.close();
        }
    }

    public void eliminaContenedor(Contenedor contenedor) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.delete(contenedor);
            tx.commit();
        } catch (HibernateException ex) {
            manejaExcepcion(ex);
            throw ex;
        } finally {

            sesion.close();
        }
    }

    public Contenedor obtenContenedor(int idContenedor) throws HibernateException {

        Contenedor contenedor = null;

        try {
            iniciaOperacion();
            contenedor = (Contenedor) sesion.get(Contenedor.class, idContenedor);
        } finally {

            sesion.close();
        }
        return contenedor;
    }

    public List<Contenedor> listadeContenedor() {

        List<Contenedor> listaContenedor = null;

        try {
            iniciaOperacion();
            listaContenedor = sesion.createQuery("from Contenedor").list();
        } finally {

            sesion.close();
        }

        return listaContenedor;

    }

    //Crud tabla Plaza
    public int guardaPlaza(Plaza plaza) {

        int idPlaza = 0;

        try {
            iniciaOperacion();
            idPlaza = (int) sesion.save(plaza);
            tx.commit();
        } catch (HibernateException ex) {
            manejaExcepcion(ex);
            throw ex;
        } finally {
            sesion.close();
        }
        return idPlaza;
    }

    public void actualizaPlaza(Plaza plaza) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.update(plaza);
            tx.commit();
        } catch (HibernateException ex) {
            manejaExcepcion(ex);
            throw ex;
        } finally {

            sesion.close();
        }
    }

    public void eliminaPlaza(Plaza plaza) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.delete(plaza);
            tx.commit();
        } catch (HibernateException ex) {
            manejaExcepcion(ex);
            throw ex;
        } finally {

            sesion.close();
        }
    }

    public Plaza obtenPlaza(int idPlaza) throws HibernateException {

        Plaza plaza = null;

        try {
            iniciaOperacion();
            plaza = (Plaza) sesion.get(Plaza.class, idPlaza);
        } finally {

            sesion.close();
        }
        return plaza;
    }

    public List<Plaza> listadePLaza() {

        List<Plaza> listaPlaza = null;

        try {
            iniciaOperacion();
            listaPlaza = sesion.createQuery("from Plaza").list();
        } finally {

            sesion.close();
        }

        return listaPlaza;

    }

    //Crud tabla Reserva
    public int guardaReserva(Reserva reserva) {

        int idReserva = 0;

        try {
            iniciaOperacion();
            idReserva = (int) sesion.save(reserva);
            tx.commit();
        } catch (HibernateException ex) {
            manejaExcepcion(ex);
            throw ex;
        } finally {
            sesion.close();
        }
        return idReserva;
    }

    public void actualizaReserva(Reserva reserva) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.update(reserva);
            tx.commit();
        } catch (HibernateException ex) {
            manejaExcepcion(ex);
            throw ex;
        } finally {

            sesion.close();
        }
    }

    public void eliminaReserva(Reserva reserva) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.delete(reserva);
            tx.commit();
        } catch (HibernateException ex) {
            manejaExcepcion(ex);
            throw ex;
        } finally {

            sesion.close();
        }
    }

    public Reserva obtenReserva(int idReserva) throws HibernateException {

        Reserva reserva = null;

        try {
            iniciaOperacion();
            reserva = (Reserva) sesion.get(Reserva.class, idReserva);
        } finally {

            sesion.close();
        }
        return reserva;
    }

    public List<Reserva> listadeReserva() {

        List<Reserva> listaReserva = null;

        try {
            iniciaOperacion();
            listaReserva = sesion.createQuery("from Reserva").list();
        } finally {

            sesion.close();
        }

        return listaReserva;

    }

    //Crud tabla Cliente
    public int guardaCliente(Cliente cliente) {

        int cedulaCliente = 0;

        try {
            iniciaOperacion();
            cedulaCliente = (int) sesion.save(cliente);
            tx.commit();
        } catch (HibernateException ex) {
            manejaExcepcion(ex);
            throw ex;
        } finally {
            sesion.close();
        }
        return cedulaCliente;
    }

    public void actualizaCliente(Cliente cliente) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.update(cliente);
            tx.commit();
        } catch (HibernateException ex) {
            manejaExcepcion(ex);
            throw ex;
        } finally {

            sesion.close();
        }
    }

    public void eliminaCliente(Cliente cliente) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.delete(cliente);
            tx.commit();
        } catch (HibernateException ex) {
            manejaExcepcion(ex);
            throw ex;
        } finally {

            sesion.close();
        }
    }

    public Cliente obtenCliente(int cedulaCliente) throws HibernateException {

        Cliente cliente = null;

        try {
            iniciaOperacion();
            cliente = (Cliente) sesion.get(Cliente.class, cedulaCliente);
        } finally {

            sesion.close();
        }
        return cliente;
    }

    public List<Cliente> listadeCliente() {

        List<Cliente> listaCliente = null;

        try {
            iniciaOperacion();
            listaCliente = sesion.createQuery("from Cliente").list();
        } finally {

            sesion.close();
        }

        return listaCliente;

    }
    
// Metodos de las clases
    
     public void obtenNombres()
    {
        iniciaOperacion();

        Query query = sesion.createQuery("SELECT u.nombre FROM Usuario as u");

        List<String> listaResultados = query.list();

        for (int i = 0; i < listaResultados.size(); i++)
        {
            System.out.println("Nombre " + i + ": " + listaResultados.get(i));
        }

        terminaOperacion();
    }
     
    public void obtenNombresYApellidos()
    {
        iniciaOperacion();

        Query query = sesion.createQuery("SELECT u.nombre, u.apellido FROM Usuario as u ");

        List<Object[]> listaResultados = query.list();

        for (int i = 0; i < listaResultados.size(); i++)
        {
            System.out.println("Nombre " + i + ": " + listaResultados.get(i)[0] + ", apellido: " + listaResultados.get(i)[1]);
        }

        terminaOperacion();
    } 

    
    public Usuario getUsuario(int cedulaUsuario, String nombre) throws HibernateException
    {
        Usuario usuario = null;

        try
        {
            iniciaOperacion();
            Query query = getSession().createQuery("FROM Usuario u WHERE u.cedulaUsuario = :cedula AND u.nombre = :nombre");
            query.setParameter("cedula", cedulaUsuario);
            query.setParameter("nombre", nombre);

            usuario = (Usuario)query.uniqueResult();
        }
        catch (HibernateException he)
        {
            manejaExcepcion(he);
        }
        finally
        {
            terminaOperacion();
        }


        return usuario;
    }
    
    public void buscaUsuario()
    {
        Usuario usuario = null;
       

        try
        {
            usuario = getUsuario(1098756741, "Lucas");
        }catch (HibernateException e)
        {
            System.err.println("Ocurrió un error al recuperar usuario");
            e.printStackTrace();
        }

        if(usuario == null)
        {
            System.out.println("No se encontró al usuario");
        }
        else
        {
            System.out.println("El usuario es: " + usuario.getNombre()+ "el apeiido es:" + usuario.getApellido());
        }
    }
}
