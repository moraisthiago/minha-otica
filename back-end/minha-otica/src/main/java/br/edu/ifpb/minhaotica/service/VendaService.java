package br.edu.ifpb.minhaotica.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import br.edu.ifpb.minhaotica.dto.VendaDTO;
import br.edu.ifpb.minhaotica.model.Cliente;
import br.edu.ifpb.minhaotica.model.Item;
import br.edu.ifpb.minhaotica.model.Venda;
import br.edu.ifpb.minhaotica.repository.ClienteRepository;
import br.edu.ifpb.minhaotica.repository.ItemRepository;
import br.edu.ifpb.minhaotica.repository.VendaRepository;

@Service
public class VendaService {

    @Autowired
    private VendaRepository _vendaRepository;

    @Autowired
    private ItemRepository _itemRepository;

    @Autowired
    private ClienteRepository _clienteRepository;

    public List<Venda> findAll() {
        return _vendaRepository.findAll();
    }

    public ResponseEntity<Venda> findById(UUID id) {
        Optional<Venda> venda = _vendaRepository.findById(id);

        if (venda.isPresent()) {
            return new ResponseEntity<Venda>(venda.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Venda> save(VendaDTO vendaDTO) {
        Optional<Cliente> clienteExistente = _clienteRepository.findById(vendaDTO.getCliente().getId());

        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();

            Venda newVenda = new Venda();

            newVenda.setCliente(cliente);

            _vendaRepository.save(newVenda);

            return new ResponseEntity<Venda>(newVenda, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Venda> saveItemVenda(UUID idItem, UUID idVenda) {
        Optional<Item> itemExistente = _itemRepository.findById(idItem);
        Optional<Venda> vendaExistente = _vendaRepository.findById(idVenda);

        if (itemExistente.isPresent() && vendaExistente.isPresent()) {
            vendaExistente.get().getItens().add(itemExistente.get());

            _vendaRepository.save(vendaExistente.get());

            return new ResponseEntity<Venda>(vendaExistente.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Venda> update(UUID id, VendaDTO newVendaDTO) {
        Optional<Venda> oldVenda = _vendaRepository.findById(id);

        if (oldVenda.isPresent()) {
            Venda venda = oldVenda.get();

            venda.setCliente(newVendaDTO.getCliente());
            venda.setItens(newVendaDTO.getItens());

            _vendaRepository.save(venda);

            return new ResponseEntity<Venda>(venda, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> delete(UUID id) {
        Optional<Venda> venda = _vendaRepository.findById(id);

        if (venda.isPresent()) {
            _vendaRepository.delete(venda.get());

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
