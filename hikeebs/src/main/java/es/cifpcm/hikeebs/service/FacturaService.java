package es.cifpcm.hikeebs.service;

import es.cifpcm.hikeebs.entity.Factura;
import es.cifpcm.hikeebs.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService implements GenericService<Factura, Integer>{

    @Autowired
    FacturaRepository facRepo;
    @Override
    public List<Factura> findAll() {
        return facRepo.findAll();
    }

    @Override
    public Optional<Factura> findById(Integer id) {
        return facRepo.findById(id);
    }

    @Override
    public Factura save(Factura object) {
        return facRepo.save(object);
    }

    @Override
    public void deleteById(Integer id) {
        facRepo.deleteById(id);
    }

    @Override
    public void delete(Factura entity) {
        facRepo.delete(entity);
    }
}
