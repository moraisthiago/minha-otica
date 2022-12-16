package br.edu.ifpb.minhaotica.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.minhaotica.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, UUID> {

    List<Consulta> findByPersonId(UUID idPerson);

    List<Consulta> findByDateTime(LocalDateTime dateTime);
}
