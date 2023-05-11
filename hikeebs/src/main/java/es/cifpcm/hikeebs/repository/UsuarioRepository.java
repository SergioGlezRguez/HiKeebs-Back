package es.cifpcm.hikeebs.repository;

import es.cifpcm.hikeebs.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
