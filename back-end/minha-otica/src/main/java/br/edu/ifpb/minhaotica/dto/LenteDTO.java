package br.edu.ifpb.minhaotica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LenteDTO {
    private String type;
    private Double value;
    private String laboratory;
}
