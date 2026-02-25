package pe.edu.idat.webtech.service;

import pe.edu.idat.webtech.dto.categoria.CategoriaResponseDTO;
import pe.edu.idat.webtech.dto.producto.ProductoRequestDTO;
import pe.edu.idat.webtech.dto.producto.ProductoResponseDTO;

import java.util.List;

public interface ProductoService {
    ProductoResponseDTO createProducto (ProductoRequestDTO productoRequestDTO);
    List<ProductoResponseDTO> listarProductos ();
    List<ProductoResponseDTO>listarPorCategoriaId(Long id);
    ProductoResponseDTO findById(Long id);
    ProductoResponseDTO updateProducto(Long id,ProductoRequestDTO productoRequestDTO);
    void deleteProducto(Long id);
}
