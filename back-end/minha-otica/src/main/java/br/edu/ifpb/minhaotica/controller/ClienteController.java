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

import br.edu.ifpb.minhaotica.dto.ClienteDTO;
import br.edu.ifpb.minhaotica.model.Cliente;
import br.edu.ifpb.minhaotica.model.Endereco;
import br.edu.ifpb.minhaotica.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService _clienteService;

    @GetMapping
    private List<Cliente> findAll() {
        return _clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable UUID id) {
        return _clienteService.findById(id);
    }

    @GetMapping("{idCliente}/enderecos")
    public List<Endereco> findByClienteId(@PathVariable UUID idCliente) {
        return _clienteService.findByClienteId(idCliente);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody ClienteDTO clienteDTO) {
        return _clienteService.save(clienteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable UUID id, @RequestBody ClienteDTO newClienteDTO) {
        return _clienteService.update(id, newClienteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        return _clienteService.delete(id);
    }
}
