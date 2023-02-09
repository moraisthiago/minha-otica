package br.edu.ifpb.minhaotica.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.minhaotica.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {

}
