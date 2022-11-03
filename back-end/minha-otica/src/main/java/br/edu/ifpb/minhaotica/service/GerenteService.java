package br.edu.ifpb.minhaotica.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.ifpb.minhaotica.dto.GerenteDTO;
import br.edu.ifpb.minhaotica.model.Gerente;
import br.edu.ifpb.minhaotica.model.Endereco;
import br.edu.ifpb.minhaotica.repository.GerenteRepository;
import br.edu.ifpb.minhaotica.repository.EnderecoRepository;

@Service
public class GerenteService {

    @Autowired
    private GerenteRepository _gerenteRepository;

    @Autowired
    private EnderecoRepository _enderecoRepository;

    public List<Gerente> findAll() {
        return _gerenteRepository.findAll();
    }

    public ResponseEntity<Gerente> findById(UUID id) {
        Optional<Gerente> gerente = _gerenteRepository.findById(id);

        if (gerente.isPresent()) {
            return new ResponseEntity<Gerente>(gerente.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public List<Endereco> findByGerenteId(UUID idPerson) {
        return _enderecoRepository.findByPersonId(idPerson);
    }

    public Gerente save(GerenteDTO gerenteDTO) {
        Gerente newGerente = new Gerente();

        newGerente.setName(gerenteDTO.getName());
        newGerente.setBirthDate(gerenteDTO.getBirthDate());
        newGerente.setCpf(gerenteDTO.getCpf());
        newGerente.setPhone(gerenteDTO.getPhone());

        return _gerenteRepository.save(newGerente);
    }

    public ResponseEntity<Gerente> update(UUID id, GerenteDTO newGerenteDTO) {
        Optional<Gerente> oldGerente = _gerenteRepository.findById(id);

        if (oldGerente.isPresent()) {
            Gerente gerente = oldGerente.get();

            gerente.setName(newGerenteDTO.getName());
            gerente.setBirthDate(newGerenteDTO.getBirthDate());
            gerente.setCpf(newGerenteDTO.getCpf());
            gerente.setPhone(newGerenteDTO.getPhone());

            _gerenteRepository.save(gerente);

            return new ResponseEntity<Gerente>(gerente, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> delete(UUID id) {
        Optional<Gerente> gerente = _gerenteRepository.findById(id);

        if (gerente.isPresent()) {
            _gerenteRepository.delete(gerente.get());

            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
