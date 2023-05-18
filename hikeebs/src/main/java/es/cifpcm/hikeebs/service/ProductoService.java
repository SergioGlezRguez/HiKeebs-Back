package es.cifpcm.hikeebs.service;

import es.cifpcm.hikeebs.entity.Producto;
import es.cifpcm.hikeebs.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductoService implements GenericService<Producto, Integer> {

    @Autowired
    ProductoRepository proRepo;
    @Override
    public List<Producto> findAll() {
        return proRepo.findAll();
    }

    @Override
    public Optional<Producto> findById(Integer id) {
        return proRepo.findById(id);
    }

    @Override
    public Producto save(Producto object) {
        return proRepo.save(object);
    }

    @Override
    public void deleteById(Integer id) {
        proRepo.deleteById(id);
    }

    @Override
    public void delete(Producto entity) {
        proRepo.delete(entity);
    }
}
