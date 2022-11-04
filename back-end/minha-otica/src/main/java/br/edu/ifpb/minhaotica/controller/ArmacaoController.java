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

import br.edu.ifpb.minhaotica.dto.ArmacaoDTO;
import br.edu.ifpb.minhaotica.model.Armacao;
import br.edu.ifpb.minhaotica.service.ArmacaoService;

@RestController
@RequestMapping("/armacao")
public class ArmacaoController {

    @Autowired
    private ArmacaoService _armacaoService;

    @GetMapping
    private List<Armacao> findAll() {
        return _armacaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Armacao> findById(@PathVariable UUID id) {
        return _armacaoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Armacao save(@RequestBody ArmacaoDTO armacaoDTO) {
        return _armacaoService.save(armacaoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Armacao> update(@PathVariable UUID id, @RequestBody ArmacaoDTO newArmacaoDTO) {
        return _armacaoService.update(id, newArmacaoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        return _armacaoService.delete(id);
    }
}
