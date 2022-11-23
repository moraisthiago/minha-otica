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

import br.edu.ifpb.minhaotica.dto.VendaLenteDTO;
import br.edu.ifpb.minhaotica.model.VendaLente;
import br.edu.ifpb.minhaotica.service.VendaLenteService;

@RestController
@RequestMapping("/vendaLente")
public class VendaLenteController {

    @Autowired
    private VendaLenteService _vendaLenteService;

    @GetMapping
    private List<VendaLente> findAll() {
        return _vendaLenteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaLente> findById(@PathVariable UUID id) {
        return _vendaLenteService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendaLente save(@RequestBody VendaLenteDTO vendaLenteDTO) {
        return _vendaLenteService.save(vendaLenteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendaLente> update(@PathVariable UUID id, @RequestBody VendaLenteDTO newVendaLenteDTO) {
        return _vendaLenteService.update(id, newVendaLenteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        return _vendaLenteService.delete(id);
    }
}
