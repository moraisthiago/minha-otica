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

import br.edu.ifpb.minhaotica.dto.ItemLenteDTO;
import br.edu.ifpb.minhaotica.model.ItemLente;
import br.edu.ifpb.minhaotica.service.ItemLenteService;

@RestController
@RequestMapping("/itemLente")
public class ItemLenteController {

    @Autowired
    private ItemLenteService _itemLenteService;

    @GetMapping
    public List<ItemLente> findAll() {
        return _itemLenteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemLente> findById(@PathVariable UUID id) {
        return _itemLenteService.findById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemLente save(@RequestBody ItemLenteDTO itemLenteDTO) {
        return _itemLenteService.save(itemLenteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemLente> update(@PathVariable UUID id, @RequestBody ItemLenteDTO itemLenteDTO) {
        return _itemLenteService.update(id, itemLenteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        return _itemLenteService.delete(id);
    }
}
