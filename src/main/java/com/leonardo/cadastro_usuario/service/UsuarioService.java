package com.leonardo.cadastro_usuario.service;

import com.leonardo.cadastro_usuario.infrastructure.entity.Usuario;
import com.leonardo.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void salvatUsuario(Usuario usuario) {
        usuarioRepository.saveAndFlush(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email) {

        return usuarioRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado!")
        );
    }

    public void deletarUsuarioPorEmail(String email) {
        usuarioRepository.deleteByEmail(email);
    }

    public void deletarUsusarioPorTelefone(String telefone) {
        usuarioRepository.deleteByTelefone(telefone);
    }

    public void atualizarUsuarioPorEmail(Integer id, Usuario usuario) {
        Usuario usuarioEntity = usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuario não encontrado!"));
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getEmail())
                .idade(usuario.getIdade() != null ? usuario.getIdade() : usuarioEntity.getIdade())
                .telefone(usuario.getTelefone() != null ? usuario.getTelefone() : usuarioEntity.getTelefone())
                .id(usuarioEntity.getId())
                .build();

        usuarioRepository.saveAndFlush(usuarioAtualizado);


    }

}
