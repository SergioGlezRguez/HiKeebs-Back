package es.cifpcm.hikeebs.repository;

import es.cifpcm.hikeebs.entity.CarritoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoCompraRepository extends JpaRepository<CarritoCompra, Integer> {
}
