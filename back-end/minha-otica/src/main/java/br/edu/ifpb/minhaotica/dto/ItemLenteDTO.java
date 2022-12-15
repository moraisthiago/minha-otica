package br.edu.ifpb.minhaotica.dto;

import br.edu.ifpb.minhaotica.model.Lente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemLenteDTO {
    private Lente lente;
    private Integer quantidade;
}
