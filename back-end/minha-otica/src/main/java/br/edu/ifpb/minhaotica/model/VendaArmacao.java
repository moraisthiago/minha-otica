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
@Table(name = "tb_venda_armacao")
public class VendaArmacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_venda_armacao")
    private UUID id;

    @NotNull
    @Column(name = "cliente_venda_armacao")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_armacao")
    private Armacao armacao;

    @Column(name = "qtd_armacao")
    private Integer qtdArmacao;

}
