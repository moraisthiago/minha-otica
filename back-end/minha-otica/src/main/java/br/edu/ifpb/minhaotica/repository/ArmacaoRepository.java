package br.edu.ifpb.minhaotica.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.minhaotica.model.Armacao;

public interface ArmacaoRepository extends JpaRepository<Armacao, UUID> {

}
