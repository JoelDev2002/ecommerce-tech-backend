package pe.edu.idat.webtech.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.webtech.dto.compra.CompraRequestDTO;
import pe.edu.idat.webtech.dto.compra.CompraResponseDTO;
import pe.edu.idat.webtech.entity.Usuario;
import pe.edu.idat.webtech.mapper.CompraMapper;
import pe.edu.idat.webtech.mapper.DetalleCompraMapper;
import pe.edu.idat.webtech.repository.CompraRepository;
import pe.edu.idat.webtech.repository.UsuarioRepository;
import pe.edu.idat.webtech.service.CompraService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompraServiceImpl implements CompraService {

    private final CompraRepository compraRepository;
    private final CompraMapper compraMapper;
    private final DetalleCompraMapper detalleCompraMapper;
    private final UsuarioRepository usuarioRepository;

    @Override
    public CompraResponseDTO createCompra(CompraRequestDTO compraRequestDTO) {
        Usuario usuario =usuarioRepository.findById(compraRequestDTO.usuarioId()).
                orElseThrow(()->new RuntimeException("usuario no encontrado: "+ compraRequestDTO.usuarioId()));
        return null;
    }

    @Override
    public List<CompraResponseDTO> listarCompras() {
        return List.of();
    }
}
