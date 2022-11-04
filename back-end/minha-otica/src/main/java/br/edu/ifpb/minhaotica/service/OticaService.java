package br.edu.ifpb.minhaotica.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.ifpb.minhaotica.dto.OticaDTO;
import br.edu.ifpb.minhaotica.model.Otica;
import br.edu.ifpb.minhaotica.repository.OticaRepository;

@Service
public class OticaService {

    @Autowired
    private OticaRepository _oticaRepository;

    public List<Otica> findAll() {
        return _oticaRepository.findAll();
    }

    public ResponseEntity<Otica> findById(UUID id) {
        Optional<Otica> otica = _oticaRepository.findById(id);

        if (otica.isPresent()) {
            return new ResponseEntity<Otica>(otica.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public Otica save(OticaDTO oticaDTO) {
        Otica newOtica = new Otica();

        newOtica.setName(oticaDTO.getName());
        newOtica.setCnpj(oticaDTO.getCnpj());
        newOtica.setOwnerName(oticaDTO.getOwnerName());
        newOtica.setManagerName(oticaDTO.getManagerName());

        return _oticaRepository.save(newOtica);
    }

    public ResponseEntity<Otica> update(UUID id, OticaDTO newOticaDTO) {
        Optional<Otica> oldOtica = _oticaRepository.findById(id);

        if (oldOtica.isPresent()) {
            Otica otica = oldOtica.get();

            otica.setName(newOticaDTO.getName());
            otica.setCnpj(newOticaDTO.getCnpj());
            otica.setOwnerName(newOticaDTO.getOwnerName());
            otica.setManagerName(newOticaDTO.getManagerName());

            _oticaRepository.save(otica);

            return new ResponseEntity<Otica>(otica, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> delete(UUID id) {
        Optional<Otica> otica = _oticaRepository.findById(id);

        if (otica.isPresent()) {
            _oticaRepository.delete(otica.get());

            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
