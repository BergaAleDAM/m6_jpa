/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import modelo.*;

/**
 *
 * @author Jorge
 */
public class Polissa_Controller {

    public void Insertar(Polissa p) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(p);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public void Modificar(Polissa p) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(p);

        System.out.println("commit");
        
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public void Eliminar(Polissa p) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(p) ? p : em.merge(p));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public Polissa Buscar(Long id) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda");

        Polissa p = (Polissa) em.find(Polissa.class, id);

        System.out.println("close");
        em.close();

        return p;
    }
    
    public Polissa BuscarPerClient(String nom) {
        
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Busqueda per nom");
        
        Query query = em.createNamedQuery(Polissa.CONSULTA2,Usuari.class);
        query.setParameter("nombre", nom);
        Polissa p = (Polissa) query.getSingleResult();

        System.out.println("close");
        em.close();

        return p;
    }
    
        public Polissa BuscarPerVehicle(String nom) {
        
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Busqueda per nom");
        
        Query query = em.createNamedQuery(Polissa.CONSULTA1,Usuari.class);
        query.setParameter("nombre", nom);
        Polissa p = (Polissa) query.getSingleResult();

        System.out.println("close");
        em.close();

        return p;
    }

    public void Consulta() {
        
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Consulta");
        
        Query q = em.createQuery("SELECT * FROM Polissa");
        List<Polissa> lista = (List<Polissa>) q.getResultList();
        imprimirLista(lista);

        System.out.println("close");
        em.close();
    }

    private void imprimirLista(List<Polissa> lista) {
     
        for (Polissa polissa : lista) {
            System.out.println(polissa.toString());
        }
}

    }

