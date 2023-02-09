package br.edu.ifpb.minhaotica.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.ifpb.minhaotica.dto.ItemLenteDTO;
import br.edu.ifpb.minhaotica.model.ItemLente;
import br.edu.ifpb.minhaotica.repository.ItemLenteRepository;

@Service
public class ItemLenteService {

    @Autowired
    private ItemLenteRepository _itemLenteRepository;

    public List<ItemLente> findAll() {
        return _itemLenteRepository.findAll();
    }

    public ResponseEntity<ItemLente> findById(UUID id) {
        Optional<ItemLente> itemLente = _itemLenteRepository.findById(id);

        if (itemLente.isPresent()) {
            return new ResponseEntity<ItemLente>(itemLente.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ItemLente save(ItemLenteDTO itemLenteDTO) {

        ItemLente newItemLente = new ItemLente();

        newItemLente.setLente(itemLenteDTO.getLente());
        newItemLente.setQuantidade(itemLenteDTO.getQuantidade());

        return _itemLenteRepository.save(newItemLente);
    }

    public ResponseEntity<ItemLente> update(UUID id, ItemLenteDTO newItemLenteDTO) {
        Optional<ItemLente> oldItemLente = _itemLenteRepository.findById(id);

        if (oldItemLente.isPresent()) {
            ItemLente itemLente = oldItemLente.get();

            itemLente.setLente(newItemLenteDTO.getLente());

            _itemLenteRepository.save(itemLente);

            return new ResponseEntity<ItemLente>(itemLente, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> delete(UUID id) {
        Optional<ItemLente> itemLente = _itemLenteRepository.findById(id);

        if (itemLente.isPresent()) {
            _itemLenteRepository.delete(itemLente.get());

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
