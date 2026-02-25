package pe.edu.idat.webtech.dto.usuario;

public record UsuarioRequestDTO(
        String nombre,
        String email,
        String password,
        String direccion
) {
}
