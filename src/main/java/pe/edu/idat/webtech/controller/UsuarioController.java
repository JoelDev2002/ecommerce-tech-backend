package pe.edu.idat.webtech.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://frontend-eccomerce-tech.vercel.app")
@RestController
@RequestMapping("v1/usuario")
@RequiredArgsConstructor
public class UsuarioController {
}
