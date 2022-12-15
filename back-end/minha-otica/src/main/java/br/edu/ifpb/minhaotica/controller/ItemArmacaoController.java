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

import br.edu.ifpb.minhaotica.dto.ItemArmacaoDTO;
import br.edu.ifpb.minhaotica.model.ItemArmacao;
import br.edu.ifpb.minhaotica.service.ItemArmacaoService;

@RestController
@RequestMapping("/itemArmacao")
public class ItemArmacaoController {

    @Autowired
    private ItemArmacaoService _itemArmacaoService;

    @GetMapping
    public List<ItemArmacao> findAll() {
        return _itemArmacaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemArmacao> findById(@PathVariable UUID id) {
        return _itemArmacaoService.findById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemArmacao save(@RequestBody ItemArmacaoDTO itemArmacaoDTO) {
        return _itemArmacaoService.save(itemArmacaoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemArmacao> update(@PathVariable UUID id, @RequestBody ItemArmacaoDTO itemArmacaoDTO) {
        return _itemArmacaoService.update(id, itemArmacaoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        return _itemArmacaoService.delete(id);
    }
}
