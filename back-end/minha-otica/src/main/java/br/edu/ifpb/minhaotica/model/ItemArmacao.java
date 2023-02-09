package br.edu.ifpb.minhaotica.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "idItem")
@Table(name = "tb_item_armacao")
@EqualsAndHashCode(callSuper = false)
public class ItemArmacao extends Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_item_armacao")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "id_armacao")
    private Armacao armacao;
}
