package es.cifpcm.hikeebs.controller;

import es.cifpcm.hikeebs.entity.Factura;
import es.cifpcm.hikeebs.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/factura")
public class FacturaREST {
    @Autowired
    FacturaService billSer;
    @GetMapping("/allFacturas")
    public List<Factura> getAll(){
        return billSer.findAll();
    }
}
