package com.seuapp.treinosdietas.dto;

import lombok.Data;

@Data
public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String role;
    private Double peso;
    private Double altura;
    private Integer idade;
}