package Biblioteca_paquete;
import Biblioteca_paquete.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class LibroDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecaPU");

    public void registrarLibro(Libro libro) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Libro> listarLibros() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
        } finally {
            em.close();
        }
    }
}
