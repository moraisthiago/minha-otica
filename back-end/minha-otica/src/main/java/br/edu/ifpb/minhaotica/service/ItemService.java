package br.edu.ifpb.minhaotica.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.ifpb.minhaotica.dto.ItemDTO;
import br.edu.ifpb.minhaotica.model.Armacao;
import br.edu.ifpb.minhaotica.model.Item;
import br.edu.ifpb.minhaotica.model.Lente;
import br.edu.ifpb.minhaotica.repository.ArmacaoRepository;
import br.edu.ifpb.minhaotica.repository.ItemRepository;
import br.edu.ifpb.minhaotica.repository.LenteRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository _itemRepository;

    @Autowired
    private ArmacaoRepository _armacaoRepository;

    @Autowired
    private LenteRepository _lenteRepository;

    public List<Item> findAll() {
        return _itemRepository.findAll();
    }

    public ResponseEntity<Item> findById(UUID id) {
        Optional<Item> item = _itemRepository.findById(id);

        if (item.isPresent()) {
            return new ResponseEntity<Item>(item.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Item> save(ItemDTO itemDTO) {
        Optional<Armacao> armacaoOptional = _armacaoRepository.findById(itemDTO.getArmacao().getId());
        Optional<Lente> lenteOptional = _lenteRepository.findById(itemDTO.getLente().getId());

        if (armacaoOptional.isPresent() || lenteOptional.isPresent()) {
            Armacao armacao = armacaoOptional.get();
            Lente lente = lenteOptional.get();

            Item newItem = new Item();

            newItem.setArmacao(armacao);
            newItem.setQtdArmacao(itemDTO.getQtdArmacao());
            newItem.setLente(lente);
            newItem.setQtdLente(itemDTO.getQtdLente());

            _itemRepository.save(newItem);

            return new ResponseEntity<Item>(newItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Item> update(UUID id, ItemDTO newItemDTO) {
        Optional<Item> oldItem = _itemRepository.findById(id);

        if (oldItem.isPresent()) {
            Item item = oldItem.get();

            item.setArmacao(newItemDTO.getArmacao());
            item.setQtdArmacao(newItemDTO.getQtdArmacao());
            item.setLente(newItemDTO.getLente());
            item.setQtdLente(newItemDTO.getQtdLente());

            _itemRepository.save(item);

            return new ResponseEntity<Item>(item, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> delete(UUID id) {
        Optional<Item> item = _itemRepository.findById(id);

        if (item.isPresent()) {
            _itemRepository.delete(item.get());

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
