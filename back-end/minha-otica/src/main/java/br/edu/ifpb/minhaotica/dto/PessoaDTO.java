package br.edu.ifpb.minhaotica.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {
    private String name;
    private LocalDate birthDate;
    private String cpf;
    private String phone;
}
