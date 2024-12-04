package com.example.demo.controllers.views;


import com.example.demo.Veiculo;
import com.example.demo.repositories.VeiculoRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/veiculos")
public class VeiculoViewController {

    private final VeiculoRepository veiculoRepository = new VeiculoRepository();

    @GetMapping
    public String view(Model model) {
        List<Veiculo> veiculos = veiculoRepository.buscarTodos();
        model.addAttribute("veiculos", veiculos);
        return "veiculos";
    }

    @GetMapping("/criar")
    public String criarVeiculo(Model model) {
        model.addAttribute("veiculo", new Veiculo());
        return "criar-veiculo";
    }

    @PostMapping
    public String criarVeiculo(@Valid Veiculo veiculo, BindingResult result) {
        if (result.hasErrors()) {
            return "criar-veiculo";
        }
        veiculoRepository.salvar(veiculo);
        return "redirect:/veiculos";
    }

    @GetMapping("/editar/{id}")
    public String editarVeiculo(@PathVariable Long id, Model model) {
        Optional<Veiculo> veiculo = Optional.ofNullable(veiculoRepository.buscarPorId(id));
        if (veiculo.isEmpty()) {
            return "redirect:/erro";
        }
        model.addAttribute("veiculo", veiculo.get());
        return "editar-veiculo";
    }

    @PostMapping("/{id}")
    public String atualizarVeiculo(@PathVariable Long id, @Valid Veiculo veiculo, BindingResult result) {
        if (result.hasErrors()) {
            return "editar-veiculo";
        }
        veiculo.setId(id);
        veiculoRepository.atualizar(veiculo);
        return "redirect:/veiculos";
    }

    @DeleteMapping("deletar/{id}")
    public String deletarVeiculo(@PathVariable Long id) {
        veiculoRepository.deletar(id);
        return "redirect:/veiculos";
    }
}


