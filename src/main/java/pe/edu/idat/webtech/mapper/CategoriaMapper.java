package pe.edu.idat.webtech.mapper;

import org.mapstruct.Mapper;
import pe.edu.idat.webtech.dto.categoria.CategoriaRequestDTO;
import pe.edu.idat.webtech.dto.categoria.CategoriaResponseDTO;
import pe.edu.idat.webtech.entity.Categoria;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaResponseDTO toResponse (Categoria categoria);
    Categoria toEntity (CategoriaRequestDTO categoriaRequestDTO);
}
