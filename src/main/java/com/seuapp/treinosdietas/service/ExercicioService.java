package com.seuapp.treinosdietas.service;

import com.seuapp.treinosdietas.model.Exercicio;
import com.seuapp.treinosdietas.model.Treino;
import com.seuapp.treinosdietas.repository.ExercicioRepository;
import com.seuapp.treinosdietas.repository.TreinoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExercicioService {

    private final ExercicioRepository exercicioRepository;
    private final TreinoRepository treinoRepository;

    public List<Exercicio> listarPorTreino(Long treinoId) {
        return exercicioRepository.findByTreinoId(treinoId);
    }

    public Exercicio criar(Long treinoId, Exercicio exercicio) {
        Treino treino = treinoRepository.findById(treinoId)
                .orElseThrow(() -> new RuntimeException("Treino nao encontrado"));
        exercicio.setTreino(treino);
        return exercicioRepository.save(exercicio);
    }
    public void deletar(Long treinoId, Long exercicioId) {
        Exercicio exercicio = exercicioRepository.findById(exercicioId)
                .orElseThrow(() -> new RuntimeException("Exercício não encontrado"));
        if (!exercicio.getTreino().getId().equals(treinoId)) {
            throw new RuntimeException("Exercício não pertence a este treino");
        }
        exercicioRepository.delete(exercicio);
    }
}