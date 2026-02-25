package pe.edu.idat.webtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.idat.webtech.entity.Rol;


import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol,Long> {
    Optional<Rol> findByNombre(String nombre);
}
