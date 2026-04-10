package com.seuapp.treinosdietas.service;

import com.seuapp.treinosdietas.config.JwtUtil;
import com.seuapp.treinosdietas.model.Usuario;
import com.seuapp.treinosdietas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}