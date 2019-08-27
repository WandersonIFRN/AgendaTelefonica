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
public class ContatoController {

    @Autowired
    private ContatoRepositorio contatoRepositorio;

    @GetMapping("/contatos")
    public Page<Contato> getcontatos(Pageable pageable) {
        return contatoRepositorio.findAll(pageable);
    }


    @PostMapping("/contatos")
    public Contato salvarContato(@Valid @RequestBody Contato contato) {
        return contatoRepositorio.save(contato);
    }

    @PutMapping("/contatos/{contatoId}")
    public Contato updateContato(@PathVariable Long contatoId, @Valid @RequestBody Contato contatoRequest) {
        return contatoRepositorio.findById(contatoId)
                .map(contato -> {
                    contato.setNome(contatoRequest.getNome());
                    contato.setTelefone(contatoRequest.getTelefone());
                    return contatoRepositorio.save(contato);
                }).orElseThrow();
    }


    @DeleteMapping("/contatos/{contatoId}")
    public ResponseEntity<?> deleteContato(@PathVariable Long contatoId) {
        return contatoRepositorio.findById(contatoId)
                .map(contato -> {
                    contatoRepositorio.delete(contato);
                    return ResponseEntity.ok().build();
                }).orElseThrow();
    }
}
