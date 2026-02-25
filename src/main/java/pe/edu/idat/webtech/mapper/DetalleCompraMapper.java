package pe.edu.idat.webtech.mapper;

import org.mapstruct.Mapper;
import pe.edu.idat.webtech.dto.detalleCompra.DetalleCompraRequestDTO;
import pe.edu.idat.webtech.dto.detalleCompra.DetalleCompraResponseDTO;
import pe.edu.idat.webtech.entity.DetalleCompra;

@Mapper(componentModel = "spring")
public interface DetalleCompraMapper {
    DetalleCompraResponseDTO toResponse(DetalleCompra detalleCompra);

    DetalleCompra toEntity(DetalleCompraRequestDTO detalleCompraRequestDTO);
}
