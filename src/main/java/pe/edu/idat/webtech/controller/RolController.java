package pe.edu.idat.webtech.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.idat.webtech.dto.rol.RolRequestDTO;
import pe.edu.idat.webtech.dto.rol.RolResponseDTO;
import pe.edu.idat.webtech.service.RolService;

import java.util.List;

@RestController
@RequestMapping("v1/rol")
@RequiredArgsConstructor
public class RolController {
    private final RolService rolService;

    @GetMapping
    public ResponseEntity<List<RolResponseDTO>> listarRoles() {
        return new ResponseEntity<>(rolService.listarRoles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolResponseDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(rolService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RolResponseDTO> crearRol(@RequestBody RolRequestDTO rolRequestDTO) {
        return new ResponseEntity<>(rolService.createRol(rolRequestDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Long id) {
        rolService.deleteRol(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
