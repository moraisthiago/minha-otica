package br.edu.ifpb.minhaotica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OticaDTO {
    private String name;
    private String cnpj;
    private String ownerName;
    private String managerName;
}
