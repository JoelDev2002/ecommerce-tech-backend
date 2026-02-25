package pe.edu.idat.webtech.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import pe.edu.idat.webtech.dto.producto.ProductoRequestDTO;
import pe.edu.idat.webtech.dto.producto.ProductoResponseDTO;
import pe.edu.idat.webtech.entity.Producto;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    @Mapping(source = "categoria.nombre", target = "categoriaNombre")
    @Mapping(source= "categoria.categoriaId", target="categoriaId")
    ProductoResponseDTO toResponse(Producto producto);

    Producto toEntity(ProductoRequestDTO productoRequestDTO);

    void updateEntityFromRequest(ProductoRequestDTO productoRequestDTO, @MappingTarget Producto producto);
}
