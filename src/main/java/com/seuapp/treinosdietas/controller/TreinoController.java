package com.seuapp.treinosdietas.controller;

import com.seuapp.treinosdietas.dto.TreinoDTO;
import com.seuapp.treinosdietas.model.Treino;
import com.seuapp.treinosdietas.service.ExercicioService;
import com.seuapp.treinosdietas.service.TreinoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treinos")
@RequiredArgsConstructor
public class TreinoController {

    private final TreinoService treinoService;
    private final ExercicioService exercicioService;

    @PostMapping
    public ResponseEntity<Treino> criar(@RequestBody TreinoDTO dto,
                                        @RequestParam Long personalId) {
        return ResponseEntity.ok(treinoService.criarTreino(dto, personalId));
    }

    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<Treino>> buscarPorAluno(@PathVariable Long alunoId) {
        return ResponseEntity.ok(treinoService.buscarTreinosDoAluno(alunoId));
    }

    @GetMapping("/personal/{personalId}")
    public ResponseEntity<List<Treino>> buscarPorPersonal(@PathVariable Long personalId) {
        return ResponseEntity.ok(treinoService.buscarTreinosDoPersonal(personalId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Treino> atualizar(@PathVariable Long id,
                                            @RequestBody TreinoDTO dto) {
        return ResponseEntity.ok(treinoService.atualizarTreino(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTreino(@PathVariable Long id) {
        treinoService.deletarTreino(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{treinoId}/exercicios/{exercicioId}")
    public ResponseEntity<Void> deletarExercicio(
            @PathVariable Long treinoId,
            @PathVariable Long exercicioId) {
        exercicioService.deletar(treinoId, exercicioId);
        return ResponseEntity.noContent().build();
    }
}