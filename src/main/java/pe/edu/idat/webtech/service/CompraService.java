package pe.edu.idat.webtech.service;

import pe.edu.idat.webtech.dto.compra.CompraRequestDTO;
import pe.edu.idat.webtech.dto.compra.CompraResponseDTO;

import java.util.List;

public interface CompraService {
    CompraResponseDTO createCompra (CompraRequestDTO compraRequestDTO);
    List<CompraResponseDTO> listarCompras();

}
