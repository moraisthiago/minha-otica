package br.edu.ifpb.minhaotica.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.ifpb.minhaotica.dto.VendaLenteDTO;
import br.edu.ifpb.minhaotica.model.VendaLente;
import br.edu.ifpb.minhaotica.repository.VendaLenteRepository;

@Service
public class VendaLenteService {

    @Autowired
    private VendaLenteRepository _vendaLenteRepository;

    public List<VendaLente> findAll() {
        return _vendaLenteRepository.findAll();
    }

    public ResponseEntity<VendaLente> findById(UUID id) {
        Optional<VendaLente> vendaLente = _vendaLenteRepository.findById(id);

        if (vendaLente.isPresent()) {
            return new ResponseEntity<VendaLente>(vendaLente.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public VendaLente save(VendaLenteDTO vendaLenteDTO) {
        VendaLente newVendaLente = new VendaLente();

        newVendaLente.setCliente(vendaLenteDTO.getCliente());
        newVendaLente.setLente(vendaLenteDTO.getLente());
        newVendaLente.setQtdLente(vendaLenteDTO.getQtdLente());

        return _vendaLenteRepository.save(newVendaLente);
    }

    public ResponseEntity<VendaLente> update(UUID id, VendaLenteDTO newVendaLenteDTO) {
        Optional<VendaLente> oldVendaLente = _vendaLenteRepository.findById(id);

        if (oldVendaLente.isPresent()) {
            VendaLente vendaLente = oldVendaLente.get();

            vendaLente.setCliente(newVendaLenteDTO.getCliente());
            vendaLente.setLente(newVendaLenteDTO.getLente());
            vendaLente.setQtdLente(newVendaLenteDTO.getQtdLente());

            _vendaLenteRepository.save(vendaLente);

            return new ResponseEntity<VendaLente>(vendaLente, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> delete(UUID id) {
        Optional<VendaLente> vendaLente = _vendaLenteRepository.findById(id);

        if (vendaLente.isPresent()) {
            _vendaLenteRepository.delete(vendaLente.get());

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
