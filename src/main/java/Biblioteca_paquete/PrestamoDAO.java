package Biblioteca_paquete;
import Biblioteca_paquete.Ejemplar;
import Biblioteca_paquete.Prestamo;
import Biblioteca_paquete.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class PrestamoDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecaPU");

    public void registrarPrestamo(Prestamo prestamo) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(prestamo);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Prestamo> listarPrestamosActivos(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                            "SELECT p FROM Prestamo p WHERE p.usuario = :usuario AND p.fechaDevolucion IS NULL",
                            Prestamo.class)
                    .setParameter("usuario", usuario)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void registrarDevolucion(Prestamo prestamo) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Prestamo p = em.find(Prestamo.class, prestamo.getId());
            p.setFechaDevolucion(new Date());
            p.getEjemplar().setEstado(EstadoEjemplar.DISPONIBLE);
            em.merge(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
