package br.edu.ifpb.minhaotica.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.ifpb.minhaotica.dto.ClienteDTO;
import br.edu.ifpb.minhaotica.model.Cliente;
import br.edu.ifpb.minhaotica.model.Consulta;
import br.edu.ifpb.minhaotica.model.Endereco;
import br.edu.ifpb.minhaotica.repository.ClienteRepository;
import br.edu.ifpb.minhaotica.repository.ConsultaRepository;
import br.edu.ifpb.minhaotica.repository.EnderecoRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository _clienteRepository;

    @Autowired
    private EnderecoRepository _enderecoRepository;

    @Autowired
    private ConsultaRepository _consultaRepository;

    public List<Cliente> findAll() {
        return _clienteRepository.findAll();
    }

    public ResponseEntity<Cliente> findById(UUID id) {
        Optional<Cliente> cliente = _clienteRepository.findById(id);

        if (cliente.isPresent()) {
            return new ResponseEntity<Cliente>(cliente.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public List<Endereco> findByEnderecos(UUID idPerson) {
        return _enderecoRepository.findByPersonId(idPerson);
    }

    public List<Consulta> finByConsultas(UUID idPerson) {
        return _consultaRepository.findByPersonId(idPerson);
    }

    public Cliente save(ClienteDTO clienteDTO) {
        Cliente newCliente = new Cliente();

        newCliente.setName(clienteDTO.getName());
        newCliente.setBirthDate(clienteDTO.getBirthDate());
        newCliente.setCpf(clienteDTO.getCpf());
        newCliente.setPhone(clienteDTO.getPhone());

        return _clienteRepository.save(newCliente);
    }

    public ResponseEntity<Cliente> update(UUID id, ClienteDTO newClienteDTO) {
        Optional<Cliente> oldCliente = _clienteRepository.findById(id);

        if (oldCliente.isPresent()) {
            Cliente cliente = oldCliente.get();

            cliente.setName(newClienteDTO.getName());
            cliente.setBirthDate(newClienteDTO.getBirthDate());
            cliente.setCpf(newClienteDTO.getCpf());
            cliente.setPhone(newClienteDTO.getPhone());

            _clienteRepository.save(cliente);

            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> delete(UUID id) {
        Optional<Cliente> cliente = _clienteRepository.findById(id);

        if (cliente.isPresent()) {
            _clienteRepository.delete(cliente.get());

            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
