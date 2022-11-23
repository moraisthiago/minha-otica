package br.edu.ifpb.minhaotica.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_item")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "id_armacao")
    private Armacao armacao;

    @Column(name = "qtd_armacao")
    private Integer qtdArmacao;

    @OneToOne
    @JoinColumn(name = "id_lente")
    private Lente lente;

    @Column(name = "qtd_lente")
    private Integer qtdLente;
}
