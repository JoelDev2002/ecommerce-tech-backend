package pe.edu.idat.webtech.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.idat.webtech.dto.categoria.CategoriaRequestDTO;
import pe.edu.idat.webtech.dto.categoria.CategoriaResponseDTO;
import pe.edu.idat.webtech.entity.Categoria;
import pe.edu.idat.webtech.mapper.CategoriaMapper;
import pe.edu.idat.webtech.repository.CategoriaRepository;
import pe.edu.idat.webtech.service.CategoriaService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    @Transactional
    @Override
    public CategoriaResponseDTO createCategoria(CategoriaRequestDTO categoriaRequestDTO) {
        String nombreNormalizado=categoriaRequestDTO.nombre().toUpperCase().trim();
        if(categoriaRepository.findByNombre(nombreNormalizado).isPresent()){
            throw new RuntimeException("esta categoria ya existe");
        }

        Categoria categoria=categoriaMapper.toEntity(categoriaRequestDTO);

        return categoriaMapper.toResponse(categoriaRepository.save(categoria));
    }

    @Transactional(readOnly = true)
    @Override
    public List<CategoriaResponseDTO> listarCategoria() {
        return categoriaRepository.findAll()
                .stream()
                .map(categoriaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCategoria(Long id) {
        Categoria categoria=categoriaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("la categoria no existe"));
        categoria.setActivo(false);

        categoriaRepository.save(categoria);
    }
}
