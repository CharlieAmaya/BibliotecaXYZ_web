/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Estudiante;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import Logica.Pedido_nuevolibro;
import Persistencia.exceptions.NonexistentEntityException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amaya
 */
public class EstudianteJpaController implements Serializable {

    public EstudianteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public EstudianteJpaController() {
        emf = Persistence.createEntityManagerFactory("bibliotecaxyztest");
    }

    public void create(Estudiante estudiante) {
        if (estudiante.getListaPedidosNL() == null) {
            estudiante.setListaPedidosNL(new ArrayList<Pedido_nuevolibro>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Pedido_nuevolibro> attachedListaPedidosNL = new ArrayList<Pedido_nuevolibro>();
            for (Pedido_nuevolibro listaPedidosNLPedido_nuevolibroToAttach : estudiante.getListaPedidosNL()) {
                listaPedidosNLPedido_nuevolibroToAttach = em.getReference(listaPedidosNLPedido_nuevolibroToAttach.getClass(), listaPedidosNLPedido_nuevolibroToAttach.getId_pedidoNuevoLibro());
                attachedListaPedidosNL.add(listaPedidosNLPedido_nuevolibroToAttach);
            }
            estudiante.setListaPedidosNL(attachedListaPedidosNL);
            em.persist(estudiante);
            for (Pedido_nuevolibro listaPedidosNLPedido_nuevolibro : estudiante.getListaPedidosNL()) {
                Estudiante oldEstuOfListaPedidosNLPedido_nuevolibro = listaPedidosNLPedido_nuevolibro.getEstu();
                listaPedidosNLPedido_nuevolibro.setEstu(estudiante);
                listaPedidosNLPedido_nuevolibro = em.merge(listaPedidosNLPedido_nuevolibro);
                if (oldEstuOfListaPedidosNLPedido_nuevolibro != null) {
                    oldEstuOfListaPedidosNLPedido_nuevolibro.getListaPedidosNL().remove(listaPedidosNLPedido_nuevolibro);
                    oldEstuOfListaPedidosNLPedido_nuevolibro = em.merge(oldEstuOfListaPedidosNLPedido_nuevolibro);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Estudiante estudiante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estudiante persistentEstudiante = em.find(Estudiante.class, estudiante.getId_estudiante());
            List<Pedido_nuevolibro> listaPedidosNLOld = persistentEstudiante.getListaPedidosNL();
            List<Pedido_nuevolibro> listaPedidosNLNew = estudiante.getListaPedidosNL();
            List<Pedido_nuevolibro> attachedListaPedidosNLNew = new ArrayList<Pedido_nuevolibro>();
            for (Pedido_nuevolibro listaPedidosNLNewPedido_nuevolibroToAttach : listaPedidosNLNew) {
                listaPedidosNLNewPedido_nuevolibroToAttach = em.getReference(listaPedidosNLNewPedido_nuevolibroToAttach.getClass(), listaPedidosNLNewPedido_nuevolibroToAttach.getId_pedidoNuevoLibro());
                attachedListaPedidosNLNew.add(listaPedidosNLNewPedido_nuevolibroToAttach);
            }
            listaPedidosNLNew = attachedListaPedidosNLNew;
            estudiante.setListaPedidosNL(listaPedidosNLNew);
            estudiante = em.merge(estudiante);
            for (Pedido_nuevolibro listaPedidosNLOldPedido_nuevolibro : listaPedidosNLOld) {
                if (!listaPedidosNLNew.contains(listaPedidosNLOldPedido_nuevolibro)) {
                    listaPedidosNLOldPedido_nuevolibro.setEstu(null);
                    listaPedidosNLOldPedido_nuevolibro = em.merge(listaPedidosNLOldPedido_nuevolibro);
                }
            }
            for (Pedido_nuevolibro listaPedidosNLNewPedido_nuevolibro : listaPedidosNLNew) {
                if (!listaPedidosNLOld.contains(listaPedidosNLNewPedido_nuevolibro)) {
                    Estudiante oldEstuOfListaPedidosNLNewPedido_nuevolibro = listaPedidosNLNewPedido_nuevolibro.getEstu();
                    listaPedidosNLNewPedido_nuevolibro.setEstu(estudiante);
                    listaPedidosNLNewPedido_nuevolibro = em.merge(listaPedidosNLNewPedido_nuevolibro);
                    if (oldEstuOfListaPedidosNLNewPedido_nuevolibro != null && !oldEstuOfListaPedidosNLNewPedido_nuevolibro.equals(estudiante)) {
                        oldEstuOfListaPedidosNLNewPedido_nuevolibro.getListaPedidosNL().remove(listaPedidosNLNewPedido_nuevolibro);
                        oldEstuOfListaPedidosNLNewPedido_nuevolibro = em.merge(oldEstuOfListaPedidosNLNewPedido_nuevolibro);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = estudiante.getId_estudiante();
                if (findEstudiante(id) == null) {
                    throw new NonexistentEntityException("The estudiante with id " + id + " no longer exists.");
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
            Estudiante estudiante;
            try {
                estudiante = em.getReference(Estudiante.class, id);
                estudiante.getId_estudiante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estudiante with id " + id + " no longer exists.", enfe);
            }
            List<Pedido_nuevolibro> listaPedidosNL = estudiante.getListaPedidosNL();
            for (Pedido_nuevolibro listaPedidosNLPedido_nuevolibro : listaPedidosNL) {
                listaPedidosNLPedido_nuevolibro.setEstu(null);
                listaPedidosNLPedido_nuevolibro = em.merge(listaPedidosNLPedido_nuevolibro);
            }
            em.remove(estudiante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Estudiante> findEstudianteEntities() {
        return findEstudianteEntities(true, -1, -1);
    }

    public List<Estudiante> findEstudianteEntities(int maxResults, int firstResult) {
        return findEstudianteEntities(false, maxResults, firstResult);
    }

    private List<Estudiante> findEstudianteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Estudiante.class));
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

    public Estudiante findEstudiante(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estudiante.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstudianteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Estudiante> rt = cq.from(Estudiante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
