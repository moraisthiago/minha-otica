package br.edu.ifpb.minhaotica.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.ifpb.minhaotica.dto.ArmacaoDTO;
import br.edu.ifpb.minhaotica.model.Armacao;
import br.edu.ifpb.minhaotica.repository.ArmacaoRepository;

@Service
public class ArmacaoService {

    @Autowired
    private ArmacaoRepository _armacaoRepository;

    public List<Armacao> findAll() {
        return _armacaoRepository.findAll();
    }

    public ResponseEntity<Armacao> findById(UUID id) {
        Optional<Armacao> armacao = _armacaoRepository.findById(id);

        if (armacao.isPresent()) {
            return new ResponseEntity<Armacao>(armacao.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public Armacao save(ArmacaoDTO armacaoDTO) {
        Armacao newArmacao = new Armacao();

        newArmacao.setModel(armacaoDTO.getModel());
        newArmacao.setColor(armacaoDTO.getColor());
        newArmacao.setMark(armacaoDTO.getMark());
        newArmacao.setValue(armacaoDTO.getValue());

        return _armacaoRepository.save(newArmacao);
    }

    public ResponseEntity<Armacao> update(UUID id, ArmacaoDTO newArmacaoDTO) {
        Optional<Armacao> oldArmacao = _armacaoRepository.findById(id);

        if (oldArmacao.isPresent()) {
            Armacao armacao = oldArmacao.get();

            armacao.setModel(newArmacaoDTO.getModel());
            armacao.setColor(newArmacaoDTO.getColor());
            armacao.setMark(newArmacaoDTO.getMark());
            armacao.setValue(newArmacaoDTO.getValue());

            _armacaoRepository.save(armacao);

            return new ResponseEntity<Armacao>(armacao, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> delete(UUID id) {
        Optional<Armacao> armacao = _armacaoRepository.findById(id);

        if (armacao.isPresent()) {
            _armacaoRepository.delete(armacao.get());

            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
