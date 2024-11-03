/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import Logica.Estudiante;
import Logica.Pedido_nuevolibro;
import Persistencia.exceptions.NonexistentEntityException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

/**
 *
 * @author amaya
 */
public class Pedido_nuevolibroJpaController implements Serializable {

    public Pedido_nuevolibroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Pedido_nuevolibroJpaController() {
        emf = Persistence.createEntityManagerFactory("bibliotecaxyztest");
    }

    public void create(Pedido_nuevolibro pedido_nuevolibro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estudiante estu = pedido_nuevolibro.getEstu();
            if (estu != null) {
                estu = em.getReference(estu.getClass(), estu.getId_estudiante());
                pedido_nuevolibro.setEstu(estu);
            }
            em.persist(pedido_nuevolibro);
            if (estu != null) {
                estu.getListaPedidosNL().add(pedido_nuevolibro);
                estu = em.merge(estu);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pedido_nuevolibro pedido_nuevolibro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedido_nuevolibro persistentPedido_nuevolibro = em.find(Pedido_nuevolibro.class, pedido_nuevolibro.getId_pedidoNuevoLibro());
            Estudiante estuOld = persistentPedido_nuevolibro.getEstu();
            Estudiante estuNew = pedido_nuevolibro.getEstu();
            if (estuNew != null) {
                estuNew = em.getReference(estuNew.getClass(), estuNew.getId_estudiante());
                pedido_nuevolibro.setEstu(estuNew);
            }
            pedido_nuevolibro = em.merge(pedido_nuevolibro);
            if (estuOld != null && !estuOld.equals(estuNew)) {
                estuOld.getListaPedidosNL().remove(pedido_nuevolibro);
                estuOld = em.merge(estuOld);
            }
            if (estuNew != null && !estuNew.equals(estuOld)) {
                estuNew.getListaPedidosNL().add(pedido_nuevolibro);
                estuNew = em.merge(estuNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = pedido_nuevolibro.getId_pedidoNuevoLibro();
                if (findPedido_nuevolibro(id) == null) {
                    throw new NonexistentEntityException("The pedido_nuevolibro with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedido_nuevolibro pedido_nuevolibro;
            try {
                pedido_nuevolibro = em.getReference(Pedido_nuevolibro.class, id);
                pedido_nuevolibro.getId_pedidoNuevoLibro();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pedido_nuevolibro with id " + id + " no longer exists.", enfe);
            }
            Estudiante estu = pedido_nuevolibro.getEstu();
            if (estu != null) {
                estu.getListaPedidosNL().remove(pedido_nuevolibro);
                estu = em.merge(estu);
            }
            em.remove(pedido_nuevolibro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pedido_nuevolibro> findPedido_nuevolibroEntities() {
        return findPedido_nuevolibroEntities(true, -1, -1);
    }

    public List<Pedido_nuevolibro> findPedido_nuevolibroEntities(int maxResults, int firstResult) {
        return findPedido_nuevolibroEntities(false, maxResults, firstResult);
    }

    private List<Pedido_nuevolibro> findPedido_nuevolibroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pedido_nuevolibro.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Pedido_nuevolibro findPedido_nuevolibro(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pedido_nuevolibro.class, id);
        } finally {
            em.close();
        }
    }

    public int getPedido_nuevolibroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pedido_nuevolibro> rt = cq.from(Pedido_nuevolibro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
