package com.seuapp.treinosdietas.service;

import com.seuapp.treinosdietas.dto.TreinoDTO;
import com.seuapp.treinosdietas.model.Treino;
import com.seuapp.treinosdietas.model.Usuario;
import com.seuapp.treinosdietas.repository.TreinoRepository;
import com.seuapp.treinosdietas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TreinoService {

    private final TreinoRepository treinoRepository;
    private final UsuarioRepository usuarioRepository;

    public Treino criarTreino(TreinoDTO dto, Long personalId) {
        Usuario aluno = usuarioRepository.findById(dto.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        Usuario personal = usuarioRepository.findById(personalId)
                .orElseThrow(() -> new RuntimeException("Personal não encontrado"));

        Treino treino = new Treino();
        treino.setNome(dto.getNome());
        treino.setDescricao(dto.getDescricao());
        treino.setDiaSemana(dto.getDiaSemana());
        treino.setNivel(dto.getNivel());
        treino.setAluno(aluno);
        treino.setPersonal(personal);
        treino.setCriadoEm(LocalDateTime.now());

        return treinoRepository.save(treino);
    }

    public List<Treino> buscarTreinosDoAluno(Long alunoId) {
        return treinoRepository.findByAlunoId(alunoId);
    }

    public Treino atualizarTreino(Long id, TreinoDTO dto) {
        Treino treino = treinoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Treino não encontrado"));
        treino.setNome(dto.getNome());
        treino.setDescricao(dto.getDescricao());
        treino.setNivel(dto.getNivel());
        return treinoRepository.save(treino);
    }

    public void deletarTreino(Long id) {
        treinoRepository.deleteById(id);
    }
}