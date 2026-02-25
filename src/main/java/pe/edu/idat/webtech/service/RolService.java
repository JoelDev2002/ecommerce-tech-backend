package pe.edu.idat.webtech.service;

import pe.edu.idat.webtech.dto.rol.RolRequestDTO;
import pe.edu.idat.webtech.dto.rol.RolResponseDTO;

import java.util.List;

public interface RolService {
    RolResponseDTO createRol (RolRequestDTO rolRequestDTO);
    List<RolResponseDTO> listarRoles ();
    RolResponseDTO findById(Long id);
    void deleteRol(Long id);
}
