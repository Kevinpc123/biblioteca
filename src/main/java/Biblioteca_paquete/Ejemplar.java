package Biblioteca_paquete;

import jakarta.persistence.*;

@Entity
public class Ejemplar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "isbn", nullable = false)
    private Libro libro;

    @Enumerated(EnumType.STRING)
    private EstadoEjemplar estado;

    // Constructor por defecto
    public Ejemplar() {}

    // Constructor
    public Ejemplar(Libro libro, EstadoEjemplar estado) {
        this.libro = libro;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public EstadoEjemplar getEstado() {
        return estado;
    }

    public void setEstado(EstadoEjemplar estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Ejemplar{" +
                "id=" + id +
                ", libro=" + libro +
                ", estado=" + estado +
                '}';
    }
}
