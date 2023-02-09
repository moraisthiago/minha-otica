package br.edu.ifpb.minhaotica.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.ifpb.minhaotica.dto.ItemArmacaoDTO;
import br.edu.ifpb.minhaotica.model.ItemArmacao;
import br.edu.ifpb.minhaotica.repository.ItemArmacaoRepository;

@Service
public class ItemArmacaoService {

    @Autowired
    private ItemArmacaoRepository _itemArmacaoRepository;

    public List<ItemArmacao> findAll() {
        return _itemArmacaoRepository.findAll();
    }

    public ResponseEntity<ItemArmacao> findById(UUID id) {
        Optional<ItemArmacao> itemArmacao = _itemArmacaoRepository.findById(id);

        if (itemArmacao.isPresent()) {
            return new ResponseEntity<ItemArmacao>(itemArmacao.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ItemArmacao save(ItemArmacaoDTO itemArmacaoDTO) {

        ItemArmacao newItemArmacao = new ItemArmacao();

        newItemArmacao.setArmacao(itemArmacaoDTO.getArmacao());
        newItemArmacao.setQuantidade(itemArmacaoDTO.getQuantidade());

        return _itemArmacaoRepository.save(newItemArmacao);
    }

    public ResponseEntity<ItemArmacao> update(UUID id, ItemArmacaoDTO newItemArmacaoDTO) {
        Optional<ItemArmacao> oldItemArmacao = _itemArmacaoRepository.findById(id);

        if (oldItemArmacao.isPresent()) {
            ItemArmacao itemArmacao = oldItemArmacao.get();

            itemArmacao.setArmacao(newItemArmacaoDTO.getArmacao());

            _itemArmacaoRepository.save(itemArmacao);

            return new ResponseEntity<ItemArmacao>(itemArmacao, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> delete(UUID id) {
        Optional<ItemArmacao> itemArmacao = _itemArmacaoRepository.findById(id);

        if (itemArmacao.isPresent()) {
            _itemArmacaoRepository.delete(itemArmacao.get());

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
