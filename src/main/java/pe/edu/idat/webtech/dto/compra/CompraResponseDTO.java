package pe.edu.idat.webtech.dto.compra;

import pe.edu.idat.webtech.dto.detalleCompra.DetalleCompraResponseDTO;
import pe.edu.idat.webtech.enums.MetodoPago;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record CompraResponseDTO (
    Long compraId,
    BigDecimal total,
    LocalDate fechaCompra,
    MetodoPago metodoPago,
    String usuarioNombre,
    List<DetalleCompraResponseDTO> detalleCompras
){}
