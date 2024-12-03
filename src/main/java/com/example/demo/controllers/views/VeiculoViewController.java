package com.example.demo.controllers.views;


import com.example.demo.Veiculo;
import com.example.demo.repositories.VeiculoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String criarVeiculo(Veiculo veiculo) {
        System.out.println(veiculo);
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

    @PutMapping("/{id}")
    public String atualizarVeiculo(@PathVariable Long id, Veiculo veiculo) {
        veiculo.setId(id);
        veiculoRepository.atualizar(veiculo);
        return "redirect:/veiculos";
    }
}


