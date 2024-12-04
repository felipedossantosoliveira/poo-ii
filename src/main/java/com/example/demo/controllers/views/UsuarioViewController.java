package com.example.demo.controllers.views;

import com.example.demo.Usuario;
import com.example.demo.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioViewController {

    private final UsuarioRepository usuarioRepository = new UsuarioRepository();

    @GetMapping
    public String view(Model model) {
        List<Usuario> usuarios = usuarioRepository.buscarTodos();
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }

    @GetMapping("/criar")
    public String criarUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "criar-usuario";
    }

    @PostMapping
    public String criarUsuario(@Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "criar-usuario";
        }
        usuarioRepository.salvar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Long id, Model model) {
        Optional<Usuario> usuario = Optional.ofNullable(usuarioRepository.buscarPorId(id));
        if (usuario.isEmpty()) {
            return "redirect:/erro";
        }
        model.addAttribute("usuario", usuario.get());
        return "editar-usuario";
    }

    @PostMapping("/{id}")
    public String atualizarUsuario(@PathVariable Long id, @Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "editar-usuario";
        }
        usuario.setId(id);
        usuarioRepository.atualizar(usuario);
        return "redirect:/usuarios";
    }

    @DeleteMapping("deletar/{id}")
    public String deletarUsuario(@PathVariable Long id) {
        usuarioRepository.deletar(id);
        return "redirect:/usuarios";
    }

}
