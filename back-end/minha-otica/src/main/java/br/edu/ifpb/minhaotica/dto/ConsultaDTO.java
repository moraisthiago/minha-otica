package br.edu.ifpb.minhaotica.dto;

import java.time.LocalDateTime;

import br.edu.ifpb.minhaotica.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaDTO {
    private LocalDateTime dateTime;
    private Pessoa person;
}
