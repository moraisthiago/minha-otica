package br.edu.ifpb.minhaotica.model;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_person")
    private UUID id;

    @Column(name = "name_person")
    @Size(min = 3, max = 100, message = "Invalid size! Enter minimum 3 and maximum 100 characters") // max=50,100 ou 255
    @NotNull(message = "Name may not be null")
    private String name;

    @Column(name = "birth_date_person")
    @NotNull(message = "Birth date may not be null")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    @Column(name = "cpf_person", unique = true)
    @CPF
    @NotNull(message = "CPF may not be null")
    private String cpf;

    @Column(name = "phone_person")
    @Size(min = 11, max = 11, message = "Invalid size! Enter 11 characters")
    @NotNull(message = "Phone may not be null")
    private String phone;

}
