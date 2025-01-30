package forum.api.controller;

import forum.api.domain.DTO.UsuarioDto;
import forum.api.domain.model.Usuario;
import forum.api.domain.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastraUsuario(@RequestBody @Valid UsuarioDto usuarioDto){
        var usuario = new Usuario(usuarioDto);
        repository.save(usuario);

        return ResponseEntity.noContent().build();
    }
}
