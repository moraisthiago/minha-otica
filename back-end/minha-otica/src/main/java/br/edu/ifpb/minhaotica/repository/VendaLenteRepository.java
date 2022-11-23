package br.edu.ifpb.minhaotica.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.minhaotica.model.VendaLente;

@Repository
public interface VendaLenteRepository extends JpaRepository<VendaLente, UUID> {

}
