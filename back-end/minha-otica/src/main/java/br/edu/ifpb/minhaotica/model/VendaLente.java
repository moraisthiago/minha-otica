package br.edu.ifpb.minhaotica.model;

import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_venda_lente")
public class VendaLente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_venda_lente")
    private UUID id;

    @NotNull
    @Column(name = "cliente_venda_lente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_lente")
    private Lente lente;

    @Column(name = "qtd_lente")
    private Integer qtdLente;
}
