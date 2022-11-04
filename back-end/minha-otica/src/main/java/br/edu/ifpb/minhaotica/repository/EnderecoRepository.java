package br.edu.ifpb.minhaotica.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.minhaotica.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {

    List<Endereco> findByPersonId(UUID idPerson);

}
