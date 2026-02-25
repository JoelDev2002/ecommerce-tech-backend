package pe.edu.idat.webtech.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.webtech.dto.rol.RolRequestDTO;
import pe.edu.idat.webtech.dto.rol.RolResponseDTO;
import pe.edu.idat.webtech.entity.Rol;
import pe.edu.idat.webtech.mapper.RolMapper;
import pe.edu.idat.webtech.repository.RolRepository;
import pe.edu.idat.webtech.service.RolService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    @Override
    public RolResponseDTO createRol(RolRequestDTO rolRequestDTO) {
        if(rolRepository.findByNombre(rolRequestDTO.nombre()).isPresent()){
            throw new RuntimeException("rol ya existente");
        }
        Rol rol=rolMapper.toEntity(rolRequestDTO);

        return rolMapper.toResponse(rolRepository.save(rol));
    }

    @Override
    public List<RolResponseDTO> listarRoles() {
        return rolRepository.findAll()
                .stream()
                .map(rolMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RolResponseDTO findById(Long id) {
        Rol rol=rolRepository.findById(id)
                .orElseThrow(()->new RuntimeException("rol no encontrado"));

        return rolMapper.toResponse(rol);
    }

    @Override
    public void deleteRol(Long id) {
        Rol rol=rolRepository.findById(id)
                .orElseThrow(()->new RuntimeException("rol no encontrado"));

        rol.setActivo(false);
        rolRepository.save(rol);
    }
}
