package br.edu.ifpb.minhaotica.dto;

import br.edu.ifpb.minhaotica.model.Armacao;
import br.edu.ifpb.minhaotica.model.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaArmacaoDTO {
    private Cliente cliente;
    private Armacao armacao;
    private Integer qtdArmacao;
}
