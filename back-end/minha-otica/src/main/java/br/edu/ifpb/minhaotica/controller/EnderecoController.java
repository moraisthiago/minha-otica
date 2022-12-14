package br.edu.ifpb.minhaotica.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.minhaotica.dto.EnderecoDTO;
import br.edu.ifpb.minhaotica.model.Endereco;
import br.edu.ifpb.minhaotica.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService _enderecoService;

    @GetMapping
    private List<Endereco> findAll() {
        return _enderecoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable UUID id) {
        return _enderecoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Endereco> save(@RequestBody EnderecoDTO enderecoDTO) {
        return _enderecoService.save(enderecoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> update(@PathVariable UUID id, @RequestBody EnderecoDTO newEnderecoDTO) {
        return _enderecoService.update(id, newEnderecoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        return _enderecoService.delete(id);
    }
}
