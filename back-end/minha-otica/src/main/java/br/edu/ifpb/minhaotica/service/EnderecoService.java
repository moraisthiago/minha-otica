package br.edu.ifpb.minhaotica.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.ifpb.minhaotica.dto.EnderecoDTO;
import br.edu.ifpb.minhaotica.model.Endereco;
import br.edu.ifpb.minhaotica.model.Pessoa;
import br.edu.ifpb.minhaotica.repository.EnderecoRepository;
import br.edu.ifpb.minhaotica.repository.PessoaRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository _enderecoRepository;

    @Autowired
    private PessoaRepository _pessoaRepository;

    public List<Endereco> findAll() {
        return _enderecoRepository.findAll();
    }

    public ResponseEntity<Endereco> findById(UUID id) {
        Optional<Endereco> endereco = _enderecoRepository.findById(id);

        if (endereco.isPresent()) {
            return new ResponseEntity<Endereco>(endereco.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Endereco> save(EnderecoDTO enderecoDTO) {
        Optional<Pessoa> personOptional = _pessoaRepository.findById(enderecoDTO.getPerson().getId());

        if (personOptional.isPresent()) {
            Pessoa pessoa = personOptional.get();
            enderecoDTO.setPerson(pessoa);

            Endereco newEndereco = new Endereco();

            newEndereco.setStreet(enderecoDTO.getStreet());
            newEndereco.setNumber(enderecoDTO.getNumber());
            newEndereco.setDistrict(enderecoDTO.getDistrict());
            newEndereco.setComplement(enderecoDTO.getComplement());
            newEndereco.setCep(enderecoDTO.getCep());
            newEndereco.setCity(enderecoDTO.getCity());
            newEndereco.setState(enderecoDTO.getState());
            newEndereco.setPerson(enderecoDTO.getPerson());

            _enderecoRepository.save(newEndereco);

            return new ResponseEntity<Endereco>(newEndereco, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Endereco> update(UUID id, EnderecoDTO newEnderecoDTO) {
        Optional<Endereco> oldEndereco = _enderecoRepository.findById(id);

        if (oldEndereco.isPresent()) {
            Endereco endereco = oldEndereco.get();

            endereco.setStreet(newEnderecoDTO.getStreet());
            endereco.setNumber(newEnderecoDTO.getNumber());
            endereco.setDistrict(newEnderecoDTO.getDistrict());
            endereco.setComplement(newEnderecoDTO.getComplement());
            endereco.setCep(newEnderecoDTO.getCep());
            endereco.setCity(newEnderecoDTO.getCity());
            endereco.setState(newEnderecoDTO.getState());

            _enderecoRepository.save(endereco);

            return new ResponseEntity<Endereco>(endereco, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> delete(UUID id) {
        Optional<Endereco> endereco = _enderecoRepository.findById(id);

        if (endereco.isPresent()) {
            _enderecoRepository.delete(endereco.get());

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
