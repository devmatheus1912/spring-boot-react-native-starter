package com.seuapp.treinosdietas.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

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
    private Usuario aluno;

    @ManyToOne
    @JoinColumn(name = "nutricionista_id")
    private Usuario nutricionista;

    private LocalDateTime criadoEm;
}