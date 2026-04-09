package com.seuapp.treinosdietas.dto;

import lombok.Data;

@Data
public class TreinoDTO {
    private String nome;
    private String descricao;
    private String diaSemana;
    private String nivel;
    private Long alunoId;
}