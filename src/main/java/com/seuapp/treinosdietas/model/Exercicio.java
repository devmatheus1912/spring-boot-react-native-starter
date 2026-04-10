package com.seuapp.treinosdietas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exercicios")
@Data
@NoArgsConstructor
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String grupoMuscular;
    private Integer series;
    private Integer repeticoes;
    private Double carga;
    private Integer descanso;
    private String videoUrl;
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "treino_id")
    @JsonIgnoreProperties({"exercicios", "aluno", "personal"})
    private Treino treino;
}