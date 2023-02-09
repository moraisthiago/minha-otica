package br.edu.ifpb.minhaotica.dto;

import br.edu.ifpb.minhaotica.model.Armacao;
import br.edu.ifpb.minhaotica.model.Lente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private Armacao armacao;
    private Integer qtdArmacao;
    private Lente lente;
    private Integer qtdLente;
}
