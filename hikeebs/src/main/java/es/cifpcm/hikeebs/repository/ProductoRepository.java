package es.cifpcm.hikeebs.repository;

import es.cifpcm.hikeebs.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
