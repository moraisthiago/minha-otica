package br.edu.ifpb.minhaotica.controller;

import java.time.LocalDateTime;
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

import br.edu.ifpb.minhaotica.dto.ConsultaDTO;
import br.edu.ifpb.minhaotica.model.Consulta;
import br.edu.ifpb.minhaotica.service.ConsultaService;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService _consultaService;

    @GetMapping
    private List<Consulta> findAll() {
        return _consultaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> findById(@PathVariable UUID id) {
        return _consultaService.findById(id);
    }

    @GetMapping("{dateTime}")
    public List<Consulta> findByDateTime(@PathVariable LocalDateTime dateTime) {
        return _consultaService.findByDateTime(dateTime);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Consulta> save(@RequestBody ConsultaDTO ConsultaDTO) {
        return _consultaService.save(ConsultaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> update(@PathVariable UUID id, @RequestBody ConsultaDTO newConsultaDTO) {
        return _consultaService.update(id, newConsultaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        return _consultaService.delete(id);
    }
}
