package Biblioteca_paquete;
import Biblioteca_paquete.UsuarioDAO;
import Biblioteca_paquete.PrestamoDAO;
import Biblioteca_paquete.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        PrestamoDAO prestamoDAO = new PrestamoDAO();
        // Crear un usuario
        Usuario usuario = new Usuario("12345678A", "Juan Pérez", "juan.perez@example.com", "password123", TipoUsuario.NORMAL);
        usuarioDAO.registrarUsuario(usuario);
        // Registrar un préstamo
        /**Prestamo prestamo = new Prestamo(usuario, ejemplarDisponible, new Date());
        prestamoDAO.registrarPrestamo(prestamo);**/
        // Listar préstamos activos
        prestamoDAO.listarPrestamosActivos(usuario).forEach(System.out::println);
        // Registrar devolución
        prestamoDAO.registrarDevolucion(prestamo);
    }
}
