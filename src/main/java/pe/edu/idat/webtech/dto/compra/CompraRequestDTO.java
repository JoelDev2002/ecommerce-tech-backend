package pe.edu.idat.webtech.dto.compra;

import pe.edu.idat.webtech.dto.detalleCompra.DetalleCompraRequestDTO;
import pe.edu.idat.webtech.enums.MetodoPago;


import java.util.List;

public record CompraRequestDTO (
    MetodoPago metodoPago,
    Long usuarioId,
    List<DetalleCompraRequestDTO> detalleCompras
){}
