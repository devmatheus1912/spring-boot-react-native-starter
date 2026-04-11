package com.seuapp.treinosdietas.service;

import com.seuapp.treinosdietas.config.JwtUtil;
import com.seuapp.treinosdietas.model.Usuario;
import com.seuapp.treinosdietas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final JwtUtil jwtUtil;

    public Usuario buscarPorToken(String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        String email = jwtUtil.extractEmail(token);
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
    }

    public Usuario atualizar(String authHeader, Usuario dados) {
        Usuario usuario = buscarPorToken(authHeader);
        if (dados.getNome() != null) usuario.setNome(dados.getNome());
        if (dados.getPeso() != null) usuario.setPeso(dados.getPeso());
        if (dados.getAltura() != null) usuario.setAltura(dados.getAltura());
        if (dados.getIdade() != null) usuario.setIdade(dados.getIdade());
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarAlunos() {
        return usuarioRepository.findAll()
                .stream()
                .filter(u -> "ALUNO".equals(u.getRole()))
                .collect(Collectors.toList());
    }

    public List<Usuario> buscarAlunos(String q) {
        String query = q.toLowerCase().trim();
        return usuarioRepository.findAll()
                .stream()
                .filter(u -> "ALUNO".equals(u.getRole()))
                .filter(u -> {
                    // busca por ID exato
                    if (q.matches("\\d+")) {
                        return String.valueOf(u.getId()).equals(q);
                    }
                    // busca por nome
                    return u.getNome() != null && u.getNome().toLowerCase().contains(query);
                })
                .collect(Collectors.toList());
    }

    public void deletarAluno(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if (!"ALUNO".equals(usuario.getRole())) {
            throw new RuntimeException("Usuário não é um aluno");
        }
        usuarioRepository.delete(usuario);
    }
}