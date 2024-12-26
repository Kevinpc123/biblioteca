package Biblioteca_paquete;
import Biblioteca_paquete.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UsuarioDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecaPU");

    public void registrarUsuario(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Usuario buscarUsuarioPorDNI(String dni) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT u FROM Usuario u WHERE u.dni = :dni", Usuario.class)
                    .setParameter("dni", dni)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }
}

