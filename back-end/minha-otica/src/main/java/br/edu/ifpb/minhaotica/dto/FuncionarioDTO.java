package br.edu.ifpb.minhaotica.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO {
    private String name;
    private LocalDate birthDate;
    private String cpf;
    private String phone;
    private String email;
    private String password;
}
