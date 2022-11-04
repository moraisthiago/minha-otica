package br.edu.ifpb.minhaotica.dto;

import br.edu.ifpb.minhaotica.model.Pessoa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {
    private String street;
    private Integer number;
    private String district;
    private String complement;
    private String cep;
    private String city;
    private String state;
    private Pessoa person;
}
