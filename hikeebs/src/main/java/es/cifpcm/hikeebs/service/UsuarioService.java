package es.cifpcm.hikeebs.service;

import es.cifpcm.hikeebs.entity.Usuario;
import es.cifpcm.hikeebs.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements GenericService<Usuario, Integer> {

    @Autowired
    UsuarioRepository userRepo;
    @Override
    public List<Usuario> findAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        //Tener en cuenta que si devuelve un NULL es porque no se ha encontrado el usuario
        return userRepo.findById(id);
    }

    @Override
    public Usuario save(Usuario object) {
        return userRepo.save(object);
    }

    @Override
    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }

    @Override
    public void delete(Usuario entity) {
        userRepo.delete(entity);
    }
}
