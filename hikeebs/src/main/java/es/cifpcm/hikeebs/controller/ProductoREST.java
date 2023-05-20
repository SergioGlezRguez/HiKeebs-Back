package es.cifpcm.hikeebs.controller;

import es.cifpcm.hikeebs.entity.Producto;
import es.cifpcm.hikeebs.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/producto")
public class ProductoREST {
    @Autowired
    private ProductoService proService;

    @GetMapping("/allProducts")
    public List<Producto> getAll(){
        return proService.findAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
        Optional<Producto> producto = proService.findById(id);
        if(!producto.isPresent()){
            return ResponseEntity.notFound().build();
        }
        proService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Producto a){
        Optional<Producto> optionalProducto = proService.findById(id);
        if(!optionalProducto.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Producto e = optionalProducto.get();
        e.setDescripcion(a.getDescripcion());
        e.setNombre(a.getNombre());
        e.setPrecio(a.getPrecio());
        proService.save(e);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping("/producto/{id}")
    public ResponseEntity<?> saveProducto(@RequestBody Producto producto, @PathVariable Integer id){
        Optional<Producto> optionalProducto = proService.findById(id);
        if(optionalProducto.isPresent()){
            Producto p = new Producto();
            p.setDescripcion(producto.getDescripcion());
            p.setNombre(producto.getNombre());
            p.setPrecio(producto.getPrecio());
            proService.save(p);
            return ResponseEntity.ok().build();
        }
        else{
            return  ResponseEntity.badRequest().build();
        }
    }
}
