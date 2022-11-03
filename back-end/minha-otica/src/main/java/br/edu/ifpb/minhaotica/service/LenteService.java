package br.edu.ifpb.minhaotica.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.ifpb.minhaotica.dto.LenteDTO;
import br.edu.ifpb.minhaotica.model.Lente;
import br.edu.ifpb.minhaotica.repository.LenteRepository;

@Service
public class LenteService {

    @Autowired
    private LenteRepository _lenteRepository;

    public List<Lente> findAll() {
        return _lenteRepository.findAll();
    }

    public ResponseEntity<Lente> findById(UUID id) {
        Optional<Lente> lente = _lenteRepository.findById(id);

        if (lente.isPresent()) {
            return new ResponseEntity<Lente>(lente.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public Lente save(LenteDTO lenteDTO) {
        Lente newLente = new Lente();

        newLente.setType(lenteDTO.getType());
        newLente.setValue(lenteDTO.getValue());
        newLente.setLaboratory(lenteDTO.getLaboratory());

        return _lenteRepository.save(newLente);
    }

    public ResponseEntity<Lente> update(UUID id, LenteDTO newLenteDTO) {
        Optional<Lente> oldLente = _lenteRepository.findById(id);

        if (oldLente.isPresent()) {
            Lente lente = oldLente.get();

            lente.setType(newLenteDTO.getType());
            lente.setValue(newLenteDTO.getValue());
            lente.setLaboratory(newLenteDTO.getLaboratory());

            _lenteRepository.save(lente);

            return new ResponseEntity<Lente>(lente, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> delete(UUID id) {
        Optional<Lente> lente = _lenteRepository.findById(id);

        if (lente.isPresent()) {
            _lenteRepository.delete(lente.get());

            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
