package pe.edu.idat.webtech.service;

import pe.edu.idat.webtech.dto.categoria.CategoriaRequestDTO;
import pe.edu.idat.webtech.dto.categoria.CategoriaResponseDTO;

import java.util.List;

public interface CategoriaService {
    CategoriaResponseDTO createCategoria(CategoriaRequestDTO categoriaRequestDTO);
    List<CategoriaResponseDTO>listarCategoria();

    void deleteCategoria(Long id);
}
