package br.edu.ifpb.minhaotica.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.minhaotica.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, UUID> {

    List<Consulta> findByPersonId(UUID idPerson);

}
