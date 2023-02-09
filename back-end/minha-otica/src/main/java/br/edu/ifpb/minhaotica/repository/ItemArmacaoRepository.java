package br.edu.ifpb.minhaotica.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.minhaotica.model.ItemArmacao;

public interface ItemArmacaoRepository extends JpaRepository<ItemArmacao, UUID> {

}
