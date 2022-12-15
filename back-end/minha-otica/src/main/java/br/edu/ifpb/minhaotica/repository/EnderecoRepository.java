package br.edu.ifpb.minhaotica.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.minhaotica.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {

    List<Endereco> findByPersonId(UUID idPerson);

}
