package br.edu.ifpb.minhaotica.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.ifpb.minhaotica.dto.ConsultaDTO;
import br.edu.ifpb.minhaotica.model.Consulta;
import br.edu.ifpb.minhaotica.model.Pessoa;
import br.edu.ifpb.minhaotica.repository.ConsultaRepository;
import br.edu.ifpb.minhaotica.repository.PessoaRepository;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository _consultaRepository;

    @Autowired
    private PessoaRepository _pessoaRepository;

    public List<Consulta> findAll() {
        return _consultaRepository.findAll();
    }

    public ResponseEntity<Consulta> findById(UUID id) {
        Optional<Consulta> consulta = _consultaRepository.findById(id);

        if (consulta.isPresent()) {
            return new ResponseEntity<Consulta>(consulta.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Consulta> save(ConsultaDTO consultaDTO) {
        Optional<Pessoa> personOptional = _pessoaRepository.findById(consultaDTO.getPerson().getId());

        if (personOptional.isPresent()) {
            Pessoa pessoa = personOptional.get();
            consultaDTO.setPerson(pessoa);

            Consulta newConsulta = new Consulta();

            newConsulta.setDateTime(consultaDTO.getDateTime());
            newConsulta.setPerson(consultaDTO.getPerson());

            _consultaRepository.save(newConsulta);

            return new ResponseEntity<Consulta>(newConsulta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Consulta> update(UUID id, ConsultaDTO newConsultaDTO) {
        Optional<Consulta> oldConsulta = _consultaRepository.findById(id);

        if (oldConsulta.isPresent()) {
            Consulta consulta = oldConsulta.get();

            consulta.setDateTime(newConsultaDTO.getDateTime());
            consulta.setPerson(newConsultaDTO.getPerson());

            _consultaRepository.save(consulta);

            return new ResponseEntity<Consulta>(consulta, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> delete(UUID id) {
        Optional<Consulta> consulta = _consultaRepository.findById(id);

        if (consulta.isPresent()) {
            _consultaRepository.delete(consulta.get());

            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
