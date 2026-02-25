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
import pe.edu.idat.webtech.dto.producto.ProductoRequestDTO;
import pe.edu.idat.webtech.dto.producto.ProductoResponseDTO;
import pe.edu.idat.webtech.service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("v1/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> listarProductos()
    {
        return new ResponseEntity<>(productoService.listarProductos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> findById(@PathVariable Long id)
    {
        return new ResponseEntity<>(productoService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductoResponseDTO>> listarPorCategoria(@PathVariable Long id)
    {
        return new ResponseEntity<>(productoService.listarPorCategoriaId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductoResponseDTO> crearProducto(@RequestBody ProductoRequestDTO productoRequestDTO)
    {
        return new ResponseEntity<>(productoService.createProducto(productoRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> actualizarProducto(@RequestBody ProductoRequestDTO productoRequestDTO,@PathVariable Long id)
    {
        return new ResponseEntity<>(productoService.updateProducto(id,productoRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id)
    {
        productoService.deleteProducto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
