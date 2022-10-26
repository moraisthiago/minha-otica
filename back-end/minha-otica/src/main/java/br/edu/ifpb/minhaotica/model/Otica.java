package br.edu.ifpb.minhaotica.model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import java.util.UUID;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_optics")
public class Otica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_optics")
    private UUID id;

    @Column(name = "name_optics")
    @Size(min = 5, max = 100, message = "Invalid size! Enter minimum 5 and maximum 100 characters") // max=50,100 ou 255
    @NotEmpty(message = "Name may not be empty")
    @NotNull(message = "Name may not be null")
    private String name;

    @Column(name = "cnpj_optics", unique = true)
    @CNPJ
    @NotEmpty(message = "CNPJ may not be empty")
    @NotNull(message = "Name may not be null")
    private String cnpj;

    @Column(name = "owner_name_optics")
    @Size(min = 5, max = 100, message = "Invalid size! Enter minimum 5 and maximum 100 characters")
    @NotEmpty(message = "Name may not be empty")
    @NotNull(message = "Name may not be null")
    private String ownerName;

    @Column(name = "manager_name_optics")
    @Size(min = 5, max = 100, message = "Invalid size! Enter minimum 5 and maximum 100 characters")
    @NotEmpty(message = "Name may not be empty")
    @NotNull(message = "Name may not be null")
    private String managerName;
}
