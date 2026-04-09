package com.seuapp.treinosdietas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "treinos")
@Data
@NoArgsConstructor
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String diaSemana;
    private String nivel;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    @JsonIgnoreProperties({"senha", "peso", "altura", "idade"})
    private Usuario aluno;

    @ManyToOne
    @JoinColumn(name = "personal_id")
    @JsonIgnoreProperties({"senha", "peso", "altura", "idade"})
    private Usuario personal;

    private LocalDateTime criadoEm;
}