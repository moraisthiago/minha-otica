package br.edu.ifpb.minhaotica.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.ifpb.minhaotica.dto.VendaArmacaoDTO;
import br.edu.ifpb.minhaotica.model.VendaArmacao;
import br.edu.ifpb.minhaotica.repository.VendaArmacaoRepository;

@Service
public class VendaArmacaoService {

    @Autowired
    private VendaArmacaoRepository _vendaArmacaoRepository;

    public List<VendaArmacao> findAll() {
        return _vendaArmacaoRepository.findAll();
    }

    public ResponseEntity<VendaArmacao> findById(UUID id) {
        Optional<VendaArmacao> vendaArmacao = _vendaArmacaoRepository.findById(id);

        if (vendaArmacao.isPresent()) {
            return new ResponseEntity<VendaArmacao>(vendaArmacao.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public VendaArmacao save(VendaArmacaoDTO vendaArmacaoDTO) {
        VendaArmacao newVendaArmacao = new VendaArmacao();

        newVendaArmacao.setCliente(vendaArmacaoDTO.getCliente());
        newVendaArmacao.setArmacao(vendaArmacaoDTO.getArmacao());
        newVendaArmacao.setQtdArmacao(vendaArmacaoDTO.getQtdArmacao());

        return _vendaArmacaoRepository.save(newVendaArmacao);
    }

    public ResponseEntity<VendaArmacao> update(UUID id, VendaArmacaoDTO newVendaArmacaoDTO) {
        Optional<VendaArmacao> oldVendaArmacao = _vendaArmacaoRepository.findById(id);

        if (oldVendaArmacao.isPresent()) {
            VendaArmacao vendaArmacao = oldVendaArmacao.get();

            vendaArmacao.setCliente(newVendaArmacaoDTO.getCliente());
            vendaArmacao.setArmacao(newVendaArmacaoDTO.getArmacao());
            vendaArmacao.setQtdArmacao(newVendaArmacaoDTO.getQtdArmacao());

            _vendaArmacaoRepository.save(vendaArmacao);

            return new ResponseEntity<VendaArmacao>(vendaArmacao, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> delete(UUID id) {
        Optional<VendaArmacao> vendaArmacao = _vendaArmacaoRepository.findById(id);

        if (vendaArmacao.isPresent()) {
            _vendaArmacaoRepository.delete(vendaArmacao.get());

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
