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
import Logica.Libro;
import Logica.Prestamo;
import Persistencia.exceptions.NonexistentEntityException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

/**
 *
 * @author amaya
 */
public class PrestamoJpaController implements Serializable {

    public PrestamoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public PrestamoJpaController() {
        emf = Persistence.createEntityManagerFactory("bibliotecaxyztest");
    }

    public void create(Prestamo prestamo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estudiante estu = prestamo.getEstu();
            if (estu != null) {
                estu = em.getReference(estu.getClass(), estu.getId_estudiante());
                prestamo.setEstu(estu);
            }
            Libro lib = prestamo.getLib();
            if (lib != null) {
                lib = em.getReference(lib.getClass(), lib.getId_libro());
                prestamo.setLib(lib);
            }
            em.persist(prestamo);
            if (estu != null) {
                estu.getListaPrestamo().add(prestamo);
                estu = em.merge(estu);
            }
            if (lib != null) {
                lib.getListaPrestamo().add(prestamo);
                lib = em.merge(lib);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Prestamo prestamo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Prestamo persistentPrestamo = em.find(Prestamo.class, prestamo.getId_prestamo());
            Estudiante estuOld = persistentPrestamo.getEstu();
            Estudiante estuNew = prestamo.getEstu();
            Libro libOld = persistentPrestamo.getLib();
            Libro libNew = prestamo.getLib();
            if (estuNew != null) {
                estuNew = em.getReference(estuNew.getClass(), estuNew.getId_estudiante());
                prestamo.setEstu(estuNew);
            }
            if (libNew != null) {
                libNew = em.getReference(libNew.getClass(), libNew.getId_libro());
                prestamo.setLib(libNew);
            }
            prestamo = em.merge(prestamo);
            if (estuOld != null && !estuOld.equals(estuNew)) {
                estuOld.getListaPrestamo().remove(prestamo);
                estuOld = em.merge(estuOld);
            }
            if (estuNew != null && !estuNew.equals(estuOld)) {
                estuNew.getListaPrestamo().add(prestamo);
                estuNew = em.merge(estuNew);
            }
            if (libOld != null && !libOld.equals(libNew)) {
                libOld.getListaPrestamo().remove(prestamo);
                libOld = em.merge(libOld);
            }
            if (libNew != null && !libNew.equals(libOld)) {
                libNew.getListaPrestamo().add(prestamo);
                libNew = em.merge(libNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = prestamo.getId_prestamo();
                if (findPrestamo(id) == null) {
                    throw new NonexistentEntityException("The prestamo with id " + id + " no longer exists.");
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
            Prestamo prestamo;
            try {
                prestamo = em.getReference(Prestamo.class, id);
                prestamo.getId_prestamo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The prestamo with id " + id + " no longer exists.", enfe);
            }
            Estudiante estu = prestamo.getEstu();
            if (estu != null) {
                estu.getListaPrestamo().remove(prestamo);
                estu = em.merge(estu);
            }
            Libro lib = prestamo.getLib();
            if (lib != null) {
                lib.getListaPrestamo().remove(prestamo);
                lib = em.merge(lib);
            }
            em.remove(prestamo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Prestamo> findPrestamoEntities() {
        return findPrestamoEntities(true, -1, -1);
    }

    public List<Prestamo> findPrestamoEntities(int maxResults, int firstResult) {
        return findPrestamoEntities(false, maxResults, firstResult);
    }

    private List<Prestamo> findPrestamoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Prestamo.class));
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

    public Prestamo findPrestamo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Prestamo.class, id);
        } finally {
            em.close();
        }
    }

    public int getPrestamoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Prestamo> rt = cq.from(Prestamo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
