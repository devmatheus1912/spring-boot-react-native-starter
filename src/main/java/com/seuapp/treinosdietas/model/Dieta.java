package com.seuapp.treinosdietas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "dietas")
@Data
@NoArgsConstructor
public class Dieta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String objetivo;
    private Integer caloriasMeta;
    private Double proteinaMeta;
    private Double carboidratoMeta;
    private Double gorduraMeta;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    @JsonIgnoreProperties({"senha", "peso", "altura", "idade"})
    private Usuario aluno;

    @ManyToOne
    @JoinColumn(name = "nutricionista_id")
    @JsonIgnoreProperties({"senha", "peso", "altura", "idade"})
    private Usuario nutricionista;

    private LocalDateTime criadoEm;
}