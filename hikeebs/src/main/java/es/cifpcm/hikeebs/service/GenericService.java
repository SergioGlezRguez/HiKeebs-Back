package es.cifpcm.hikeebs.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T,E>{
    List<T> findAll();
    Optional<T> findById(E id);
    T save(T object);
    void deleteById(E id);
    void delete(T entity);
}
