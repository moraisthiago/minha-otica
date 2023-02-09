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

import br.edu.ifpb.minhaotica.dto.VendaDTO;
import br.edu.ifpb.minhaotica.model.Venda;
import br.edu.ifpb.minhaotica.service.VendaService;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaService _vendaService;

    @GetMapping
    private List<Venda> findAll() {
        return _vendaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> findById(@PathVariable UUID id) {
        return _vendaService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Venda> save(@RequestBody VendaDTO vendaDTO) {
        return _vendaService.save(vendaDTO);
    }

    @PostMapping("/{idItem}/{idVenda}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Venda> saveItemVenda(@PathVariable UUID idItem, @PathVariable UUID idVenda) {
        return _vendaService.saveItemVenda(idItem, idVenda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venda> update(@PathVariable UUID id, @RequestBody VendaDTO newVendaDTO) {
        return _vendaService.update(id, newVendaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        return _vendaService.delete(id);
    }
}
