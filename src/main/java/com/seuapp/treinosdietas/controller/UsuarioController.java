package com.seuapp.treinosdietas.controller;

import com.seuapp.treinosdietas.model.Usuario;
import com.seuapp.treinosdietas.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/perfil")
    public ResponseEntity<Usuario> getPerfil(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(usuarioService.buscarPorToken(token));
    }

    @PutMapping("/perfil")
    public ResponseEntity<Usuario> atualizarPerfil(
            @RequestHeader("Authorization") String token,
            @RequestBody Usuario dados) {
        return ResponseEntity.ok(usuarioService.atualizar(token, dados));
    }

    @GetMapping("/alunos")
    public ResponseEntity<List<Usuario>> listarAlunos() {
        return ResponseEntity.ok(usuarioService.listarAlunos());
    }

    @GetMapping("/alunos/buscar")
    public ResponseEntity<List<Usuario>> buscarAlunos(@RequestParam String q) {
        return ResponseEntity.ok(usuarioService.buscarAlunos(q));
    }

    @DeleteMapping("/alunos/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
        usuarioService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }

}