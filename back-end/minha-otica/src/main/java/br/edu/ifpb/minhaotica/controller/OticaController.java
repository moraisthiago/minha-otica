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

import br.edu.ifpb.minhaotica.dto.OticaDTO;
import br.edu.ifpb.minhaotica.model.Otica;
import br.edu.ifpb.minhaotica.service.OticaService;

@RestController
@RequestMapping("/otica")
public class OticaController {

    @Autowired
    private OticaService _oticaService;

    @GetMapping
    private List<Otica> findAll() {
        return _oticaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Otica> findById(@PathVariable UUID id) {
        return _oticaService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Otica save(@RequestBody OticaDTO oticaDTO) {
        return _oticaService.save(oticaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Otica> update(@PathVariable UUID id, @RequestBody OticaDTO newOticaDTO) {
        return _oticaService.update(id, newOticaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        return _oticaService.delete(id);
    }
}
