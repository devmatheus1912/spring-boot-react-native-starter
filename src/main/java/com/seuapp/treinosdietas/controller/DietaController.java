package com.seuapp.treinosdietas.controller;

import com.seuapp.treinosdietas.model.Dieta;
import com.seuapp.treinosdietas.service.DietaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dietas")
@RequiredArgsConstructor
public class DietaController {

    private final DietaService dietaService;

    @PostMapping
    public ResponseEntity<Dieta> criar(
            @RequestBody Dieta dieta,
            @RequestParam Long nutricionistaId,
            @RequestParam Long alunoId) {
        return ResponseEntity.ok(dietaService.criar(dieta, nutricionistaId, alunoId));
    }

    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<Dieta>> buscarPorAluno(@PathVariable Long alunoId) {
        return ResponseEntity.ok(dietaService.buscarPorAluno(alunoId));
    }
}