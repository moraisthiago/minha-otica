package br.edu.ifpb.minhaotica.model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import java.util.UUID;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_lens")
public class Lente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_lens")
    private UUID id;

    @Column(name = "type_lens")
    @Size(min = 3, max = 50, message = "Invalid size! Enter minimum 3 and maximum 50 characters") // max=50,100 ou 255
    @NotNull(message = "Lens type may not be null")
    private String type;

    @Column(name = "value_lens")
    @NotNull(message = "Lens value may not be null")
    private Double value;

    @Column(name = "laboratory_lens")
    @Size(min = 3, max = 50, message = "Invalid size! Enter minimum 3 and maximum 50 characters")
    @NotNull(message = "Lens laboratory may not be null")
    private String laboratory;
}
