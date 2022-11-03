package br.edu.ifpb.minhaotica.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_query")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_lens")
    private UUID id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss a")
    @NotNull(message = "Query data and time may not be null")
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_person", nullable = false)
    private Pessoa person;
}
