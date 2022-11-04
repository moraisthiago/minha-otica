package br.edu.ifpb.minhaotica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArmacaoDTO {
    private String model;
    private String color;
    private String mark;
    private Double value;
}
