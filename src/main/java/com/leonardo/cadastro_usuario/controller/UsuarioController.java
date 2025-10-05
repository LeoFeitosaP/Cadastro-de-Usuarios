package com.leonardo.cadastro_usuario.controller;

import com.leonardo.cadastro_usuario.infrastructure.entity.Usuario;
import com.leonardo.cadastro_usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario) {
        usuarioService.salvatUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Usuario> bucarUsuarioPorEmail(@RequestParam String email) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

    @DeleteMapping("/email")
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email) {
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/telefone")
    public ResponseEntity<Void> deletarUsuarioPorTelefone(@RequestParam String telefone) {
        usuarioService.deletarUsusarioPorTelefone(telefone);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuario(@RequestParam Integer id, @RequestBody Usuario usuario) {
        usuarioService.atualizarUsuarioPorEmail(id, usuario);
        return ResponseEntity.ok().build();

    }
}
