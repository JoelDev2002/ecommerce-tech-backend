package pe.edu.idat.webtech.dto.usuario;

public record UsuarioResponseDTO (
        Long usuarioId,
        String nombre,
        String email,
        String password,
        String direccion,
        String rolNombre
) {
}
