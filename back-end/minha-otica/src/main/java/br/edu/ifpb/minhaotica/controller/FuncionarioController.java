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

import br.edu.ifpb.minhaotica.dto.FuncionarioDTO;
import br.edu.ifpb.minhaotica.model.Funcionario;
import br.edu.ifpb.minhaotica.model.Endereco;
import br.edu.ifpb.minhaotica.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService _funcionarioService;

    @GetMapping
    private List<Funcionario> findAll() {
        return _funcionarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable UUID id) {
        return _funcionarioService.findById(id);
    }

    @GetMapping("{idFuncionario}/enderecos")
    public List<Endereco> findByFuncionarioId(@PathVariable UUID idFuncionario) {
        return _funcionarioService.findByFuncionarioId(idFuncionario);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario save(@RequestBody FuncionarioDTO funcionarioDTO) {
        return _funcionarioService.save(funcionarioDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable UUID id, @RequestBody FuncionarioDTO newFuncionarioDTO) {
        return _funcionarioService.update(id, newFuncionarioDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        return _funcionarioService.delete(id);
    }
}
