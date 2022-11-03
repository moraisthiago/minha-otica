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

import br.edu.ifpb.minhaotica.dto.GerenteDTO;
import br.edu.ifpb.minhaotica.model.Gerente;
import br.edu.ifpb.minhaotica.model.Endereco;
import br.edu.ifpb.minhaotica.service.GerenteService;

@RestController
@RequestMapping("/gerente")
public class GerenteController {

    @Autowired
    private GerenteService _gerenteService;

    @GetMapping
    private List<Gerente> findAll() {
        return _gerenteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gerente> findById(@PathVariable UUID id) {
        return _gerenteService.findById(id);
    }

    @GetMapping("{idGerente}/enderecos")
    public List<Endereco> findByGerenteId(@PathVariable UUID idGerente) {
        return _gerenteService.findByGerenteId(idGerente);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Gerente save(@RequestBody GerenteDTO gerenteDTO) {
        return _gerenteService.save(gerenteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gerente> update(@PathVariable UUID id, @RequestBody GerenteDTO newGerenteDTO) {
        return _gerenteService.update(id, newGerenteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        return _gerenteService.delete(id);
    }
}
