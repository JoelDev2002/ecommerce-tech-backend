package pe.edu.idat.webtech.mapper;

import org.mapstruct.Mapper;
import pe.edu.idat.webtech.dto.usuario.UsuarioRequestDTO;
import pe.edu.idat.webtech.dto.usuario.UsuarioResponseDTO;
import pe.edu.idat.webtech.entity.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioResponseDTO toResponse(Usuario usuario);

    Usuario toEntity (UsuarioRequestDTO usuarioRequestDTO);
}
