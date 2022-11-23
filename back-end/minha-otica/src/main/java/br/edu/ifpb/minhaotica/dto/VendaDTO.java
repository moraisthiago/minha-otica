package br.edu.ifpb.minhaotica.dto;

import java.util.List;

import br.edu.ifpb.minhaotica.model.Cliente;
import br.edu.ifpb.minhaotica.model.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaDTO {
    private Cliente cliente;
    private List<Item> itens;
}
