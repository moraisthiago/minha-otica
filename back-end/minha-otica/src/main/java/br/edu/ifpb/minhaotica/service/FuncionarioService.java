package br.edu.ifpb.minhaotica.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.ifpb.minhaotica.dto.FuncionarioDTO;
import br.edu.ifpb.minhaotica.model.Funcionario;
import br.edu.ifpb.minhaotica.model.Endereco;
import br.edu.ifpb.minhaotica.repository.FuncionarioRepository;
import br.edu.ifpb.minhaotica.repository.EnderecoRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository _funcionarioRepository;

    @Autowired
    private EnderecoRepository _enderecoRepository;

    public List<Funcionario> findAll() {
        return _funcionarioRepository.findAll();
    }

    public ResponseEntity<Funcionario> findById(UUID id) {
        Optional<Funcionario> funcionario = _funcionarioRepository.findById(id);

        if (funcionario.isPresent()) {
            return new ResponseEntity<Funcionario>(funcionario.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public List<Endereco> findByFuncionarioId(UUID idPerson) {
        return _enderecoRepository.findByPersonId(idPerson);
    }

    public Funcionario save(FuncionarioDTO funcionarioDTO) {
        Funcionario newFuncionario = new Funcionario();

        newFuncionario.setName(funcionarioDTO.getName());
        newFuncionario.setBirthDate(funcionarioDTO.getBirthDate());
        newFuncionario.setCpf(funcionarioDTO.getCpf());
        newFuncionario.setPhone(funcionarioDTO.getPhone());
        newFuncionario.setEmail(funcionarioDTO.getEmail());

        String passwordEnconde = new BCryptPasswordEncoder().encode(funcionarioDTO.getPassword());

        newFuncionario.setPassword(passwordEnconde);

        return _funcionarioRepository.save(newFuncionario);
    }

    public ResponseEntity<Funcionario> update(UUID id, FuncionarioDTO newFuncionarioDTO) {
        Optional<Funcionario> oldFuncionario = _funcionarioRepository.findById(id);

        if (oldFuncionario.isPresent()) {
            Funcionario funcionario = oldFuncionario.get();

            funcionario.setName(newFuncionarioDTO.getName());
            funcionario.setBirthDate(newFuncionarioDTO.getBirthDate());
            funcionario.setCpf(newFuncionarioDTO.getCpf());
            funcionario.setPhone(newFuncionarioDTO.getPhone());
            funcionario.setEmail(newFuncionarioDTO.getEmail());

            String passwordEnconde = new BCryptPasswordEncoder().encode(newFuncionarioDTO.getPassword());

            funcionario.setPassword(passwordEnconde);

            _funcionarioRepository.save(funcionario);

            return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> delete(UUID id) {
        Optional<Funcionario> funcionario = _funcionarioRepository.findById(id);

        if (funcionario.isPresent()) {
            _funcionarioRepository.delete(funcionario.get());

            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
