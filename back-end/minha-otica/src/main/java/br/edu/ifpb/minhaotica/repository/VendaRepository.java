package br.edu.ifpb.minhaotica.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.minhaotica.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, UUID> {

}
