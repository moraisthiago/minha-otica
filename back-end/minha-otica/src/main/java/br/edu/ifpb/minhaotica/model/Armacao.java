package br.edu.ifpb.minhaotica.model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import java.util.UUID;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_frame")
public class Armacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_frame")
    private UUID id;

    @Column(name = "model_frame")
    @Size(min = 3, max = 50, message = "Invalid size! Enter minimum 3 and maximum 50 characters") // max=50,100 ou 255
    @NotNull(message = "Frame model may not be null")
    private String model;

    @Column(name = "color_frame")
    @Size(min = 3, max = 50, message = "Invalid size! Enter minimum 3 and maximum 50 characters")
    @NotNull(message = "Frame color may not be null")
    private String color;

    @Column(name = "mark_frame")
    @Size(min = 3, max = 50, message = "Invalid size! Enter minimum 3 and maximum 50 characters")
    @NotNull(message = "Frame mark may not be null")
    private String mark;

    @Column(name = "value_frame")
    @NotNull(message = "Frame value may not be null")
    private Double value;
}
