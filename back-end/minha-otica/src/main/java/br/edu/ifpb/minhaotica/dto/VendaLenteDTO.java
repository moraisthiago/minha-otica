package br.edu.ifpb.minhaotica.dto;

import br.edu.ifpb.minhaotica.model.Cliente;
import br.edu.ifpb.minhaotica.model.Lente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaLenteDTO {
    private Cliente cliente;
    private Lente lente;
    private Integer qtdLente;
}
