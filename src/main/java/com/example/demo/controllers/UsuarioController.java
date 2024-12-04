package com.example.demo.controllers;

import com.example.demo.Usuario;
import com.example.demo.repositories.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository = new UsuarioRepository();

    @PostMapping
    public void criarUsuario(@RequestBody Usuario usuario) {
        usuarioRepository.salvar(usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.buscarTodos();
    }
}

