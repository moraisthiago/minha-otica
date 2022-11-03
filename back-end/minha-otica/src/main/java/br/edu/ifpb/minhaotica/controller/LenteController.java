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

import br.edu.ifpb.minhaotica.dto.LenteDTO;
import br.edu.ifpb.minhaotica.model.Lente;
import br.edu.ifpb.minhaotica.service.LenteService;

@RestController
@RequestMapping("/lente")
public class LenteController {

    @Autowired
    private LenteService _lenteService;

    @GetMapping
    private List<Lente> findAll() {
        return _lenteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lente> findById(@PathVariable UUID id) {
        return _lenteService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lente save(@RequestBody LenteDTO lenteDTO) {
        return _lenteService.save(lenteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lente> update(@PathVariable UUID id, @RequestBody LenteDTO newLenteDTO) {
        return _lenteService.update(id, newLenteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        return _lenteService.delete(id);
    }
}
