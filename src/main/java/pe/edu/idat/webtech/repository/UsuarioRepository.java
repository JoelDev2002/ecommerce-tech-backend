package pe.edu.idat.webtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.idat.webtech.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
