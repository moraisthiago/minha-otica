package br.edu.ifpb.minhaotica.dto;

import br.edu.ifpb.minhaotica.model.Armacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemArmacaoDTO {
    private Armacao armacao;
    private Integer quantidade;
}
