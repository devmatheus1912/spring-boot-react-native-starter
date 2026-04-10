package com.seuapp.treinosdietas.service;

import com.seuapp.treinosdietas.model.Dieta;
import com.seuapp.treinosdietas.model.Usuario;
import com.seuapp.treinosdietas.repository.DietaRepository;
import com.seuapp.treinosdietas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DietaService {

    private final DietaRepository dietaRepository;
    private final UsuarioRepository usuarioRepository;

    public Dieta criar(Dieta dieta, Long nutricionistaId, Long alunoId) {
        Usuario nutricionista = usuarioRepository.findById(nutricionistaId)
                .orElseThrow(() -> new RuntimeException("Nutricionista nao encontrado"));
        Usuario aluno = usuarioRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno nao encontrado"));
        dieta.setNutricionista(nutricionista);
        dieta.setAluno(aluno);
        dieta.setCriadoEm(LocalDateTime.now());
        return dietaRepository.save(dieta);
    }

    public List<Dieta> buscarPorAluno(Long alunoId) {
        return dietaRepository.findByAlunoId(alunoId);
    }
}