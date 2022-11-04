package br.edu.ifpb.minhaotica.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "idPessoa")
@Table(name = "tb_client")
public class Cliente extends Pessoa {

}
