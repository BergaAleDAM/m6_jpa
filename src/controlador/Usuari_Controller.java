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
public class Usuari_Controller {

    public void Insertar(Usuari u) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(u);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public void Modificar(Usuari u) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(u);

        System.out.println("commit");
        
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public void Eliminar(Usuari u) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(u) ? u : em.merge(u));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public Usuari Buscar(Long id) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda");

        Usuari u = (Usuari) em.find(Usuari.class, id);

        System.out.println("close");
        em.close();

        return u;
    }
    /*
    public Usuari BuscarPerNom(String nom) {
        
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Busqueda per nom");
        
        Query query = em.createNamedQuery(Usuari.CONSULTA,Usuari.class);
        query.setParameter("nombre", nom);
        Usuari u = (Usuari) query.getSingleResult();

        System.out.println("close");
        em.close();

        return u;
    }

    public void Consulta() {
        
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Consulta");
        
        Query q = em.createQuery("FROM Usuari");
        List<Usuari> lista = (List<Usuari>) q.getResultList();
        //imprimirLista(lista);

        System.out.println("close");
        em.close();
    }

    public void imprimirLista(List<Usuari> lista) {
        System.out.println("Numero d'empleats= " + lista.size());
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    public void imprimirVehicle(Usuari u) {
        System.out.println(u);
    }
*/
}
