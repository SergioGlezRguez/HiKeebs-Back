package es.cifpcm.hikeebs.controller;

import es.cifpcm.hikeebs.entity.Usuario;
import es.cifpcm.hikeebs.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/usuario")
@Tag(name = "UsuarioREST Controller", description = "Controlador que maneja la logica de 'Usuario'")
public class UsuarioREST {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    @Operation(summary = "Obtiene todos los usuarios de nuestra aplicacion",
    description = "Mediante la consulta en nuestra base de datos, devuelve toda la lista de los usuarios de HiKeebs")
    public List<Usuario> getAll(){
        return usuarioService.findAll();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borra el usuario por el ID establecido",
    description = "Mediante la consulta en nuestra base de datos, elimina un usuario de HiKeebs en especifico por ID")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        Optional<Usuario> usuario = usuarioService.findById(id);
        if(!usuario.isPresent()){
            return ResponseEntity.notFound().build();
        }
        usuarioService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    @Operation(summary = "Obtiene un usuario y lo modifica segun los valores que se han establecido",
    description = "Mediante una consulta en la base de datos, devuelve un usuario y lo modifica segun lo que se ha establecido guardandolo en la base de datos")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Usuario a){
        Optional<Usuario> optionalUsuario = usuarioService.findById(id);
        if(!optionalUsuario.isPresent()){
            //Si no encuentra el usuario, devuelve una
            return ResponseEntity.notFound().build();
        }
        Usuario e = optionalUsuario.get();
        //Setteamos el usuario con la nueva informacion
        e.setDireccion(a.getDireccion());
        e.setNombre(a.getNombre());
        e.setTelefono(a.getTelefono());
        usuarioService.save(e);
        //Guardamos el usuario en nuestra base de datos y devolvemos un estado de "CREADO".
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping("/usuario/{idUsuario}")
    @Operation(summary = "Guarda en la base de datos un usuario que se ha creado",
    description = "Segun los datos que se ha introducido, se guarda un nuevo usuario en la base de datos")
    public ResponseEntity<?> saveUser(@RequestBody Usuario usuario, @PathVariable Integer idUsuario){
        Optional<Usuario> user = usuarioService.findById(idUsuario);
        if(user.isPresent()){
            Usuario p = new Usuario();
            p.setTelefono(user.get().getTelefono());
            p.setNombre(user.get().getNombre());
            p.setDireccion(user.get().getDireccion());
            usuarioService.save(p);
            return ResponseEntity.ok().build();
        }
        else{
            return  ResponseEntity.badRequest().build();
        }
    }
}
