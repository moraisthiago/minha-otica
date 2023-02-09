package br.edu.ifpb.minhaotica.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.minhaotica.model.Lente;

public interface LenteRepository extends JpaRepository<Lente, UUID> {

}
