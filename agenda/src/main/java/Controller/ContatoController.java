package Controller;

import Repositorio.*;
import model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Excecoes.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
public class ContatoController {

    @Autowired
    private ContatoRepositorio contatoRepositorio;
    
    public ContatoController() {
		Contato contato = new Contato(1,"João","123213");
		salvarContato(contato);
		Contato contato2 = new Contato(2,"João2","123213");
		salvarContato(contato);
		Contato contato3 = new Contato(3,"João3","123213");
		salvarContato(contato);
		Contato contato4 = new Contato(4,"João4","123213");
		salvarContato(contato);
    }

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
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + contatoId));
    }


    @DeleteMapping("/contatos/{contatoId}")
    public ResponseEntity<?> deleteContato(@PathVariable Long contatoId) {
        return contatoRepositorio.findById(contatoId)
                .map(contato -> {
                    contatoRepositorio.delete(contato);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + contatoId));
    }
}
