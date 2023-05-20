package es.cifpcm.hikeebs.controller;

import es.cifpcm.hikeebs.entity.CarritoCompra;
import es.cifpcm.hikeebs.service.CarritoCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/carritocompra")
public class CarritoCompraREST {

    @Autowired
    CarritoCompraService carService;

    @GetMapping("/all")
    public List<CarritoCompra> getAll() {
        return carService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShoppingCart(@PathVariable Integer id) {
        Optional<CarritoCompra> optionalShoppingCart = carService.findById(id);
        if (!optionalShoppingCart.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        carService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

