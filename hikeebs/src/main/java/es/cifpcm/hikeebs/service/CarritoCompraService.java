package es.cifpcm.hikeebs.service;

import es.cifpcm.hikeebs.entity.CarritoCompra;
import es.cifpcm.hikeebs.repository.CarritoCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoCompraService implements GenericService<CarritoCompra, Integer>{
    @Autowired
    CarritoCompraRepository carRepo;
    @Override
    public List<CarritoCompra> findAll() {
        return carRepo.findAll();
    }

    @Override
    public Optional<CarritoCompra> findById(Integer id) {
        return carRepo.findById(id);
    }

    @Override
    public CarritoCompra save(CarritoCompra object) {
        return carRepo.save(object);
    }

    @Override
    public void deleteById(Integer id) {
        carRepo.deleteById(id);
    }

    @Override
    public void delete(CarritoCompra entity) {
        carRepo.delete(entity);
    }
}
