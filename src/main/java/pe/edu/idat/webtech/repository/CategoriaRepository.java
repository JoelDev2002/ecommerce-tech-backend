package pe.edu.idat.webtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.idat.webtech.entity.Categoria;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
    Optional<Categoria> findByNombre (String nombre);
}
