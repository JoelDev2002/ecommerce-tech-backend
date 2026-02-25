package pe.edu.idat.webtech.dto.detalleCompra;

import java.math.BigDecimal;

public record DetalleCompraResponseDTO (
    Long detalleCompraId,
    Integer cantidad,
    BigDecimal precioUnitario,
    String productoNombre
){}
