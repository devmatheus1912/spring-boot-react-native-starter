package com.seuapp.treinosdietas.controller;

import com.seuapp.treinosdietas.model.Exercicio;
import com.seuapp.treinosdietas.service.ExercicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treinos")
@RequiredArgsConstructor
public class ExercicioController {

    private final ExercicioService exercicioService;

    @GetMapping("/{treinoId}/exercicios")
    public ResponseEntity<List<Exercicio>> listar(@PathVariable Long treinoId) {
        return ResponseEntity.ok(exercicioService.listarPorTreino(treinoId));
    }

    @PostMapping("/{treinoId}/exercicios")
    public ResponseEntity<Exercicio> criar(@PathVariable Long treinoId,
                                           @RequestBody Exercicio exercicio) {
        return ResponseEntity.ok(exercicioService.criar(treinoId, exercicio));
    }
}