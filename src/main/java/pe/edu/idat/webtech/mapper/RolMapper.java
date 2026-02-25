package pe.edu.idat.webtech.mapper;

import org.mapstruct.Mapper;
import pe.edu.idat.webtech.dto.rol.RolRequestDTO;
import pe.edu.idat.webtech.dto.rol.RolResponseDTO;
import pe.edu.idat.webtech.entity.Rol;

@Mapper(componentModel = "spring")
public interface RolMapper {
    RolResponseDTO toResponse(Rol rol);

    Rol toEntity(RolRequestDTO rolRequestDTO);
}
