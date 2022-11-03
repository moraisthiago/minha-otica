package br.edu.ifpb.minhaotica.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_address")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_address")
    private UUID id;

    @Column(name = "street_address")
    @Size(min = 3, max = 50, message = "Invalid size! Enter minimum 3 and maximum 50 characters") // max=50,100 ou 255
    @NotNull(message = "Street may not be null")
    private String street;

    @Column(name = "number_address")
    @NotNull(message = "Number may not be null")
    private Integer number;

    @Column(name = "district_address")
    @Size(min = 3, max = 50, message = "Invalid size! Enter minimum 3 and maximum 50 characters")
    @NotNull(message = "District may not be null")
    private String district;

    @Column(name = "complement_address")
    private String complement;

    @Column(name = "cep_address")
    @Size(min = 11, max = 11, message = "Invalid size! Enter 11 characters")
    @NotNull(message = "CEP may not be null")
    private String cep;

    @Column(name = "city_address")
    @Size(min = 3, max = 50, message = "Invalid size! Enter minimum 3 and maximum 50 characters")
    @NotNull(message = "City may not be null")
    private String city;

    @Column(name = "state_addres")
    @Size(min = 2, max = 50, message = "Invalid size! Enter minimum 2 and maximum 50 characters")
    @NotNull(message = "State may not be null")
    private String state;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_person", nullable = false)
    private Pessoa person;
}
