package com.seuapp.treinosdietas.controller;

import com.seuapp.treinosdietas.model.Usuario;
import com.seuapp.treinosdietas.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}