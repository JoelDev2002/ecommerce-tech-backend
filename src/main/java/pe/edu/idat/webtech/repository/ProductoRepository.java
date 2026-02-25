package pe.edu.idat.webtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.idat.webtech.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto,Long> {

    List<Producto> findByCategoria_CategoriaId(Long id);
}
