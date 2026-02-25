package pe.edu.idat.webtech.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.idat.webtech.dto.producto.ProductoRequestDTO;
import pe.edu.idat.webtech.dto.producto.ProductoResponseDTO;
import pe.edu.idat.webtech.entity.Categoria;
import pe.edu.idat.webtech.entity.Producto;
import pe.edu.idat.webtech.mapper.ProductoMapper;
import pe.edu.idat.webtech.repository.CategoriaRepository;
import pe.edu.idat.webtech.repository.ProductoRepository;
import pe.edu.idat.webtech.service.ProductoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProductoMapper productoMapper;

    @Transactional
    @Override
    public ProductoResponseDTO createProducto(ProductoRequestDTO productoRequestDTO) {
        Categoria categoria=categoriaRepository.findById(productoRequestDTO.categoriaId())
                .orElseThrow(()-> new RuntimeException("categoria no existe: "+ productoRequestDTO.categoriaId()));
        Producto producto= productoMapper.toEntity(productoRequestDTO);
        producto.setCategoria(categoria);

        return productoMapper.toResponse(productoRepository.save(producto));
    }

    @Override
    public List<ProductoResponseDTO> listarProductos() {
        return productoRepository.findAll()
                .stream()
                .map(productoMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductoResponseDTO> listarPorCategoriaId(Long id) {
        return productoRepository.findByCategoria_CategoriaId(id)
                .stream()
                .map(productoMapper::toResponse)
                .toList();
    }

    @Override
    public ProductoResponseDTO findById(Long id) {
        Producto producto=productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("producto no encontrado"));

        return productoMapper.toResponse(producto);
    }

    @Override
    public ProductoResponseDTO updateProducto(Long id, ProductoRequestDTO productoRequestDTO) {
        Producto producto=productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("producto no encontrado"));
        productoMapper.updateEntityFromRequest(productoRequestDTO,producto);
        return productoMapper.toResponse(producto);
    }

    @Override
    public void deleteProducto(Long id) {
        Producto producto=productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("producto no encontrado"));

        producto.setActivo(false);
        productoRepository.save(producto);
    }
}
