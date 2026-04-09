package com.seuapp.treinosdietas.dto;

import lombok.Data;

@Data
public class RegisterDTO {
    private String nome;
    private String email;
    private String senha;
    private String role; // ALUNO, PERSONAL, NUTRICIONISTA
}