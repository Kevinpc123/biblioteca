package Biblioteca_paquete;
import Biblioteca_paquete.Ejemplar;
import Biblioteca_paquete.EstadoEjemplar;
import Biblioteca_paquete.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class EjemplarDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecaPU");

    public void registrarEjemplar(Ejemplar ejemplar) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ejemplar);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Ejemplar> listarEjemplaresDisponibles(String isbn) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                            "SELECT e FROM Ejemplar e WHERE e.libro.isbn = :isbn AND e.estado = :estado",
                            Ejemplar.class)
                    .setParameter("isbn", isbn)
                    .setParameter("estado", EstadoEjemplar.DISPONIBLE)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}

