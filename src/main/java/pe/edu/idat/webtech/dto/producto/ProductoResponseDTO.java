package pe.edu.idat.webtech.dto.producto;

import java.math.BigDecimal;
import java.util.Map;

public record ProductoResponseDTO(
        Long productoId,
        String nombre,
        BigDecimal precio,
        Integer stock,
        String urlImagen,
        Map<String,Object>descripcion,
        Long categoriaId,
        String categoriaNombre
) { }
