package com.seuapp.treinosdietas.service;

import com.seuapp.treinosdietas.config.JwtUtil;
import com.seuapp.treinosdietas.dto.LoginDTO;
import com.seuapp.treinosdietas.dto.RegisterDTO;
import com.seuapp.treinosdietas.model.Usuario;
import com.seuapp.treinosdietas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String register(RegisterDTO dto) {
        if (usuarioRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
        usuario.setRole(dto.getRole());
        usuarioRepository.save(usuario);
        return jwtUtil.generateToken(usuario.getEmail(), usuario.getRole());
    }

    public String login(LoginDTO dto) {
        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!passwordEncoder.matches(dto.getSenha(), usuario.getSenha())) {
            throw new RuntimeException("Senha incorreta");
        }
        return jwtUtil.generateToken(usuario.getEmail(), usuario.getRole());
    }
}