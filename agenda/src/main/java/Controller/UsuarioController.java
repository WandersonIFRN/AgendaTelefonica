package Controller;

import Repositorio.*;
import model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @PostMapping("/usuario")
    public Usuario salvarUsuario(@Valid @RequestBody Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }
}
